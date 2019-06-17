package com.github.wxiaoqi.security.things.biz;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.util.IdWorker;
import com.github.wxiaoqi.security.things.entity.DataRuleRead;
import com.github.wxiaoqi.security.things.entity.DataRuleRealtime;
import com.github.wxiaoqi.security.things.mapper.DataRuleMapper;
import com.github.wxiaoqi.security.things.mapper.DataRuleReadMapper;
import com.github.wxiaoqi.security.things.mapper.DataRuleRealtimeMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ExcelServiceBiz {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DataRuleRealtimeMapper dataRuleRealtimeMapper;

	@Autowired
	DataRuleReadMapper dataRuleReadMapper;

	@Autowired
	DataRuleMapper dataRuleMapper;

	/**
	 * 执行构建Excel文档
	 *
	 * @param batchId        批次ID
	 * @param sheetDataArray 数据组，支持多个sheet页导出
	 * @param isAsync        是否异步
	 * @throws Exception
	 */
	protected void buildExcel(long batchId, JSONArray sheetDataArray, boolean isAsync, HttpServletResponse response) throws Exception {
		File tempFile = null;
		try {
			String folder = System.getProperty("java.io.tmpdir");
			tempFile = new File(folder + "/" + batchId + ".xls");
			if (!tempFile.exists()) {
				tempFile.createNewFile();
			}
//
			// 创建新的Excel 工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			workbook.createInformationProperties();
			// Aqua background
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			// 支持多个sheet页
			for (int sheetIndex = 0, sheetLen = sheetDataArray.size(); sheetIndex < sheetLen; sheetIndex++) {
				JSONObject sheetData = sheetDataArray.getJSONObject(sheetIndex);
				String title = sheetData.getString("title");
				if (title == null || title.length() == 0) {
					title = String.valueOf(sheetIndex);
				}
				Sheet sheet = workbook.createSheet(title);

				//构建头部菜单
				JSONArray jsonFields = sheetData.getJSONArray("header");
				String[] fields = new String[jsonFields.size()];
				JSONArray jsonRows = sheetData.getJSONArray("rows");
				Row row = sheet.createRow(0);
				if (jsonFields != null && jsonFields.size() > 0) {
					for (int colIndex = 0, len = jsonFields.size(); colIndex < len; colIndex++) {
						JSONObject field = jsonFields.getJSONObject(colIndex);
						String key = field.getString("key");
						if (key == null || key.length() == 0) {
							continue;
						}
						fields[colIndex] = key;
						String label = field.getString("label");
						Cell cell = row.createCell(colIndex);
						cell.setCellValue(label);
					}
				} else if (jsonRows.size() > 0) {
					// 当没有提供头部标签时使用字段名作为头部标签
					int colIndex = 0;
					JSONObject jsonRow = jsonRows.getJSONObject(0);
					Set<Map.Entry<String, Object>> set = jsonRow.entrySet();
					for (Map.Entry<String, Object> item : set) {
						fields[colIndex] = item.getKey();
						Cell cell = row.createCell(colIndex++);
						cell.setCellValue(item.getValue().toString());
						cell.setCellStyle(headerStyle);
					}
				}

				//构建数据
				for (int rowIndex = 0, len = jsonRows.size(); rowIndex < len; rowIndex++) {
					JSONObject jsonRow = jsonRows.getJSONObject(rowIndex);
					row = sheet.createRow(rowIndex + 1);// 从第二行开始
					int colIndex = 0;
					for (String field : fields) {
						Cell cell = row.createCell(colIndex++);
						cell.setCellValue(jsonRow.getString(field));
					}
				}
			}

//			response.setHeader("Content-type","application/vnd.ms-excel");
//			// 解决导出文件名中文乱码
//			response.setCharacterEncoding("UTF-8");
//			response.setHeader("Content-Disposition","attachment;filename="+new String("工资模版".getBytes("UTF-8"),"ISO-8859-1")+".xls");
//			workbook.write(response.getOutputStream());

			FileOutputStream fos = new FileOutputStream(tempFile);
			workbook.write(fos);
			fos.flush();
			// 操作结束，关闭文件
			fos.close();
			workbook.close();
//
		} catch (Exception e) {
			// 异步做状态缓存	
			String msg = "(批次号：" + batchId + ")导出异常：" + e.getMessage();
			logger.error(msg, e);
			throw new Exception(msg);
		}
	}

	public void exportFromJson(long batchId, JSONArray sheetDataArray, HttpServletResponse response)
			throws Exception {
		try {
			buildExcel(batchId, sheetDataArray, false, response);
		} catch (Exception e) {
			logger.error("Excel数据导出异常", e);
			throw e;
		}
	}


	/**
	 * 导入Excel
	 *
	 * @param file
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public ObjectRestResponse<Object> importDataRuleRealtime(MultipartFile file,String isUpdate,String dataRuleId) throws Exception {
		ObjectRestResponse<Object> result = new ObjectRestResponse<>();
		try {
			String fileName = file.getOriginalFilename();
			if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
				result.setMessage("上传文件格式不正确");
				result.setStatus(500);
				return result;
			}
			boolean isExcel2003 = true;
			if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
				isExcel2003 = false;
			}
			InputStream is = file.getInputStream();
			Workbook wb = null;
			if (isExcel2003) {
				wb = new HSSFWorkbook(is);
			} else {
				wb = new XSSFWorkbook(is);
			}
			Sheet sheet = wb.getSheetAt(0);

			List<DataRuleRealtime> insertDataRuleRealtime = new ArrayList<>();
			//有多少个sheet
			int sheets = wb.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				//获取多少行
				int rows = sheet.getPhysicalNumberOfRows();
				DataRuleRealtime s = null;
				//遍历每一行，注意：第 0 行为标题
				for (int j = 1; j < rows; j++) {
					s = new DataRuleRealtime();
					//获得第 j 行
					Row row = sheet.getRow(j);
					//转换格式 row.getCell(0).setCellType(Cell.CELL_TYPE_STRING)
					// 主键id
					s.setId(new Long(row.getCell(0).getStringCellValue()));
					// 数据规则id
//					s.setDataRuleId(new Long(row.getCell(1).getStringCellValue()));
					s.setDataRuleId(new Long(dataRuleId));
					// 数据规则实时数据type类型id
					s.setSystemDictId(new Long(row.getCell(2).getStringCellValue()));
					//NULL从站地址
					s.setSubStationAddr(row.getCell(3).getStringCellValue());
					//功能码(1,2,3,4.1，2，3，4.如果选择1和2，则数据类型为开关量。如果为3，4，为其他数据类型
					s.setFunctionCode(row.getCell(4).getStringCellValue());
					//寄存器地址
					s.setRegisterAddr(row.getCell(5).getStringCellValue());
					//数据类型
					s.setDataType(row.getCell(6).getStringCellValue());
					//解码顺序
					s.setDecodeFlag(row.getCell(7).getStringCellValue());
					//数据单位
					Cell cell8 = row.getCell(8);
					if(cell8 != null){
						s.setDataUnit(cell8.getStringCellValue());
					}
					//bit位
					Cell cell9 = row.getCell(9);
					if(cell9 != null){
						s.setDataBit(cell9.getStringCellValue());
					}
					//0 对应的内容 开关量对应
					Cell cell10 = row.getCell(10);
					if(cell10 != null){
						s.setContentZero(cell10.getStringCellValue());
					}
					//1 对应的内容 开关量对应
					Cell cell11 = row.getCell(11);
					if(cell11 != null){
						s.setContentOne(cell11.getStringCellValue());
					}
					//小数位
					Cell cell12 = row.getCell(12);
					if(cell12 != null){
						cell12.setCellType(CellType.STRING);
						s.setDataDigit(new Integer(cell12.getStringCellValue()));
					}
					//换算系数
					Cell cell13 = row.getCell(13);
					if(cell13 != null){
						cell13.setCellType(CellType.STRING);
						s.setRatioExchange(new Integer(cell13.getStringCellValue()));
					}
					//数据处理公式
					Cell cell14 = row.getCell(14);
					if(cell13 != null){
						s.setDataDealFun(cell14.getStringCellValue());
					}
					//映射
					Cell cell15 = row.getCell(15);
					if(cell15 != null){
						s.setDataMapping(cell15.getStringCellValue());
					}
					//寄存器起始地址
					Cell cell16 = row.getCell(16);
					if(cell16 != null){
						s.setRegisterStart(cell16.getStringCellValue());
					}
					//是否在历史数据中显示 0否 1是
					Cell cell17 = row.getCell(17);
					if(cell17 != null){
						cell17.setCellType(CellType.STRING);
						s.setHistoryShowFlag(new Integer(cell17.getStringCellValue()));
					}
					//图片地址
					Cell cell18 = row.getCell(18);
					if(cell18 != null){
						s.setPicAddr(cell18.getStringCellValue());
					}
					//排序字段
					Cell cell19 = row.getCell(19);
					if(cell19 != null){
						s.setDataOrderby(new Long(cell19.getStringCellValue()));
					}
					//是否启用报警 0否 1是
					Cell cell20 = row.getCell(20);
					if(cell20 != null){
						cell20.setCellType(CellType.STRING);
						s.setAlarmFlag(new Integer(cell20.getStringCellValue()));
					}
					//报警上限/报警值 (如果是开关量,文件描述为报警值)
					Cell cell21 = row.getCell(21);
					if(cell21 != null){
						s.setAlarmTopLimit(new BigDecimal(cell21.getStringCellValue()));
					}
					//varchar(255) NULL上限报警内容/报警内容
					Cell cell22 = row.getCell(22);
					if(cell22 != null){
						s.setAlarmContentUp(cell22.getStringCellValue());
					}
					//报警下限
					Cell cell23 = row.getCell(23);
					if(cell23 != null){
						s.setAlarmLowLimit(new BigDecimal(cell23.getStringCellValue()));
					}
					//下限报警内容
					Cell cell24 = row.getCell(24);
					if(cell24 != null){
						s.setAlarmContentDown(cell24.getStringCellValue());
					}

					//int(11) NOT NULL报警滤波次数
					Cell cell25 = row.getCell(25);
					if(cell25 != null){
						cell25.setCellType(CellType.STRING);
						s.setAlarmWaveFilter(new Integer(cell25.getStringCellValue()));
					}

					//datetime NOT NULL创建时间
					Cell cell26 = row.getCell(26);
					if(cell26 != null){
						Date date = strToDate(cell26.getStringCellValue(),"yyyy-MM-dd HH:mm:ss");
						s.setCreateTime(date);
					}
					insertDataRuleRealtime.add(s);
				}
			}
			IdWorker idWorker = new IdWorker();
			// 等于0 不更新数据
			if("0".equals(isUpdate)){
				for (DataRuleRealtime dataRuleRealtime : insertDataRuleRealtime) {
					long id = idWorker.nextId();
					dataRuleRealtime.setId(id);
					dataRuleRealtime.setDataOrderby(id);
					dataRuleRealtimeMapper.insertSelective(dataRuleRealtime);
					System.out.println(" 插入 "+dataRuleRealtime);
				}
			}else{
				for (DataRuleRealtime dataRuleRealtime : insertDataRuleRealtime) {
					DataRuleRealtime ruleRealtime = dataRuleRealtimeMapper.selectByPrimaryKey(dataRuleRealtime.getId());
					if (ruleRealtime == null) {
						long id = idWorker.nextId();
						dataRuleRealtime.setId(id);
						dataRuleRealtime.setDataOrderby(id);
						dataRuleRealtimeMapper.insertSelective(dataRuleRealtime);
						System.out.println(" 插入 "+dataRuleRealtime);
					} else {
						dataRuleRealtimeMapper.updateByPrimaryKeySelective(dataRuleRealtime);
					}
				}
			}
			result.setData(insertDataRuleRealtime);
			return result;
		}catch(Exception e){
			logger.error("导入实时数据Excel到数据数错误", e);
			throw e;
		}
	}


	/**
	 * 导入Excel
	 *
	 * @param file
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public ObjectRestResponse<Object> importDataRuleRead(MultipartFile file,String isUpdate,String dataRuleId) throws Exception {
		ObjectRestResponse<Object> result = new ObjectRestResponse<>();
		try {
			String fileName = file.getOriginalFilename();
			if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
				result.setMessage("上传文件格式不正确");
				result.setStatus(500);
				return result;
			}
			boolean isExcel2003 = true;
			if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
				isExcel2003 = false;
			}
			InputStream is = file.getInputStream();
			Workbook wb = null;
			if (isExcel2003) {
				wb = new HSSFWorkbook(is);
			} else {
				wb = new XSSFWorkbook(is);
			}
			Sheet sheet = wb.getSheetAt(0);

			List<DataRuleRead> insertDataRuleRead = new ArrayList<>();
			//有多少个sheet
			int sheets = wb.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				//获取多少行
				int rows = sheet.getPhysicalNumberOfRows();
				DataRuleRead s = null;
				//遍历每一行，注意：第 0 行为标题
				for (int j = 1; j < rows; j++) {
					s = new DataRuleRead();
					//获得第 j 行
					Row row = sheet.getRow(j);
					//转换格式 row.getCell(0).setCellType(Cell.CELL_TYPE_STRING)
					// 主键id
					s.setId(new Long(row.getCell(0).getStringCellValue()));
					// 数据规则id
//					s.setDataRuleId(new Long(row.getCell(1).getStringCellValue()));
					s.setDataRuleId(new Long(dataRuleId));
					// 数据规则实时数据type类型id
					s.setSystemDictId(new Long(row.getCell(2).getStringCellValue()));
					//NULL从站地址
					s.setSubStationAddr(row.getCell(3).getStringCellValue());
					//功能码(5,6,16. 5.写单个线圈 6单个寄存器 16多个寄存器)
					s.setFunctionCode(row.getCell(4).getStringCellValue());
					//寄存器地址
					s.setRegisterAddr(row.getCell(5).getStringCellValue());
					//数据类型
					s.setDataType(row.getCell(6).getStringCellValue());
					//解码顺序
					s.setDecodeFlag(row.getCell(7).getStringCellValue());
					//数据单位
					Cell cell8 = row.getCell(8);
					if(cell8 != null){
						s.setDataUnit(cell8.getStringCellValue());
					}
					//换算系数
					Cell cell9 = row.getCell(9);
					if(cell9 != null){
						cell9.setCellType(CellType.STRING);
						s.setRatioExchange(new BigDecimal(cell9.getStringCellValue()));
					}
					//输入上限
					Cell cell10 = row.getCell(10);
					if(cell10 != null){
						cell10.setCellType(CellType.STRING);
						s.setInputTopLimit(new BigDecimal(cell10.getStringCellValue()));
					}
					//输入下限
					Cell cell11 = row.getCell(11);
					if(cell11 != null){
						cell11.setCellType(CellType.STRING);
						s.setInputLowLimit(new BigDecimal(cell10.getStringCellValue()));
					}
					//0 对应的内容 开关量对应
					Cell cell12 = row.getCell(12);
					if(cell12 != null){
						s.setContentZero(cell12.getStringCellValue());
					}
					//1 对应的内容 开关量对应
					Cell cell13 = row.getCell(13);
					if(cell13 != null){
						s.setContentOne(cell13.getStringCellValue());
					}

					//图片地址
					Cell cell14 = row.getCell(14);
					if(cell14 != null){
						s.setPicAddr(cell14.getStringCellValue());
					}

					//datetime NOT NULL创建时间
					Cell cell15 = row.getCell(15);
					if(cell15 != null){
						Date date = strToDate(cell15.getStringCellValue(),"yyyy-MM-dd HH:mm:ss");
						s.setCreateTime(date);
					}
					//排序字段
					Cell cell16 = row.getCell(16);
					if(cell16 != null){
						s.setDataOrderby(new Long(cell16.getStringCellValue()));
					}

					insertDataRuleRead.add(s);
				}
			}
			IdWorker idWorker = new IdWorker();
			// 等于0 不更新数据
			if("0".equals(isUpdate)){
				for (DataRuleRead dataRuleRead : insertDataRuleRead) {
					long id = idWorker.nextId();
					dataRuleRead.setId(id);
					dataRuleRead.setDataOrderby(id);
					dataRuleReadMapper.insertSelective(dataRuleRead);
					System.out.println(" 插入 "+dataRuleRead);
				}
			}else{
				for (DataRuleRead dataRuleRead : insertDataRuleRead) {
					DataRuleRead ruleRealtime = dataRuleReadMapper.selectByPrimaryKey(dataRuleRead.getId());
					if (ruleRealtime == null) {
						long id = idWorker.nextId();
						dataRuleRead.setId(id);
						dataRuleRead.setDataOrderby(id);
						dataRuleReadMapper.insertSelective(dataRuleRead);
						System.out.println(" 插入 "+dataRuleRead);
					} else {
						dataRuleReadMapper.updateByPrimaryKeySelective(dataRuleRead);
					}
				}
			}
			result.setData(insertDataRuleRead);
			return result;
		}catch(Exception e){
			logger.error("导入读写数据Excel数据到数据数错误", e);
			throw e;
		}
	}

	/***
	 * 将string字符串转化为Date类型的字符串
	 * @param dateTimeStr 需要转化的string类型的字符串
	 * @param formatStr 转化规则
	 * @return 返回转化后的Date类型的时间
	 */
	public static Date strToDate(String dateTimeStr, String formatStr){
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
		DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
		return dateTime.toDate();
	}

}
