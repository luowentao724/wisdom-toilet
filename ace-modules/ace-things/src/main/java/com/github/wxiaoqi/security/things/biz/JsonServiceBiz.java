package com.github.wxiaoqi.security.things.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.util.IdWorker;
import com.github.wxiaoqi.security.things.entity.DataRule;
import com.github.wxiaoqi.security.things.entity.DataRuleRead;
import com.github.wxiaoqi.security.things.entity.DataRuleRealtime;
import com.github.wxiaoqi.security.things.mapper.DataRuleMapper;
import com.github.wxiaoqi.security.things.mapper.DataRuleReadMapper;
import com.github.wxiaoqi.security.things.mapper.DataRuleRealtimeMapper;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

@Service
public class JsonServiceBiz {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DataRuleRealtimeMapper dataRuleRealtimeMapper;

	@Autowired
	DataRuleReadMapper dataRuleReadMapper;

	@Autowired
	DataRuleMapper dataRuleMapper;



	/**
	 * 导入数据规则Json，并导入到数据库
	 * @param file
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public ObjectRestResponse<Object> importDataRule(MultipartFile file) throws Exception {
		ObjectRestResponse<Object> result = new ObjectRestResponse<>();
		BufferedReader reader = null;
		try {
			String fileName = file.getOriginalFilename();
			if (!fileName.matches("^.+\\.(?i)(json)$")) {
				result.setMessage("上传文件格式不正确");
				result.setStatus(500);
				return result;
			}
			String JsonContext = readFile(file.getInputStream());
			JSONObject jsonObject = JSON.parseObject(JsonContext);
			DataRule dataRule = JSON.toJavaObject(jsonObject,DataRule.class);
			System.out.println(dataRule.toString());
			IdWorker idWorker = new IdWorker();
			Date nowDate = new Date();
			long dataRuleId = idWorker.nextId();
			dataRule.setId(dataRuleId);
			dataRule.setRuleName(dataRule.getRuleName()+"-导入");
			dataRule.setCreateTime(nowDate);
			dataRuleMapper.insertSelective(dataRule);
			List<DataRuleRealtime> dataRuleRealtimeList = dataRule.getDataRuleRealtimeList();
			if(dataRuleRealtimeList != null && dataRuleRealtimeList.size() > 0){
				// 循环新增实时数据
				for(DataRuleRealtime insertDataRuleRealtime : dataRuleRealtimeList){
					long dataRuleRealtimeId = idWorker.nextId();
					insertDataRuleRealtime.setId(dataRuleRealtimeId);
					insertDataRuleRealtime.setDataRuleId(dataRuleId);
					insertDataRuleRealtime.setDataOrderby(dataRuleRealtimeId);
					insertDataRuleRealtime.setCreateTime(new Date());
					dataRuleRealtimeMapper.insertSelective(insertDataRuleRealtime);
				}
			}

			// 查找读写数据
			List<DataRuleRead> dataRuleReadList = dataRule.getDataRuleReadList();
			if(dataRuleReadList != null && dataRuleReadList.size() > 0){
				for(DataRuleRead insertDataRuleRead : dataRuleReadList){
					long dataRuleReadId = idWorker.nextId();
					insertDataRuleRead.setId(dataRuleReadId);
					insertDataRuleRead.setDataRuleId(dataRuleId);
					insertDataRuleRead.setDataOrderby(dataRuleReadId);
					insertDataRuleRead.setCreateTime(new Date());
					dataRuleReadMapper.insertSelective(insertDataRuleRead);
				}
			}
			idWorker = null;
			return result;
		}catch(Exception e) {
			logger.error("导入数据规则Json数据到数据数错误", e);
			throw e;
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String readFile(InputStream is){
		BufferedReader reader = null;
		String laststr = "";
		try{
			InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while((tempString = reader.readLine()) != null){
				laststr += tempString;
			}
			reader.close();
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return laststr;
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
