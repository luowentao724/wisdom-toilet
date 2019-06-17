package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.wxiaoqi.security.things.biz.SystemDictBiz;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 数据规则读写数据
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-29 15:41:05
 */
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@Table(name = "data_rule_read")
public class DataRuleRead implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Id
	private Long id;

	//数据规则id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "data_rule_id")
	private Long dataRuleId;

	//实时数据类型(关联系统字典表的 id 字段)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "system_dict_id")
	private Long systemDictId;

	//从站地址
	@Column(name = "sub_station_addr")
	private String subStationAddr;

	//功能码(1,2,3. 1.写单个线圈 2单个寄存器 3多个寄存器
	@Column(name = "function_code")
	private String functionCode;

	//寄存器地址
	@Column(name = "register_addr")
	private String registerAddr;

	//数据类型
	@Column(name = "data_type")
	private String dataType;

	//解码顺序
	@Column(name = "decode_flag")
	private String decodeFlag;

	//单位
	@Column(name = "data_unit")
	private String dataUnit;

	//换算系数
	@Column(name = "ratio_exchange")
	private BigDecimal ratioExchange;

	//输入上限
	@Column(name = "input_top_limit")
	private BigDecimal inputTopLimit;

	//输入下限
	@Column(name = "input_low_limit")
	private BigDecimal inputLowLimit;

	//0 对应的内容 开关量对应
	@Column(name = "content_zero")
	private String contentZero;

	//1 对应的内容 开关量对应
	@Column(name = "content_one")
	private String contentOne;

	//图片地址
	@Column(name = "pic_addr")
	private String picAddr;

	//创建时间
	@Column(name = "create_time")
	private Date createTime;

	//排序字段
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "data_orderby")
	private Long dataOrderby;

	//数据名称
	@Transient
	private String dictName;

	//用来存储写入数据
	@Transient
	private String dataValue;

	//存储当前实时数据对应的实时数据对象
	@Transient
	private RealDataInfo realDataInfo;

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public RealDataInfo getRealDataInfo() {
		return realDataInfo;
	}

	public void setRealDataInfo(RealDataInfo realDataInfo) {
		this.realDataInfo = realDataInfo;
	}

	//报警类型名称
	public String getDictName() {
		if (systemDictId == null) return null;
		return SystemDictBiz.getDictNameKey(systemDictId);
	}

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：数据规则id
	 */
	public void setDataRuleId(Long dataRuleId) {
		this.dataRuleId = dataRuleId;
	}
	/**
	 * 获取：数据规则id
	 */
	public Long getDataRuleId() {
		return dataRuleId;
	}
	/**
	 * 设置：实时数据类型(关联系统字典表的 id 字段)
	 */
	public void setSystemDictId(Long systemDictId) {
		this.systemDictId = systemDictId;
	}
	/**
	 * 获取：实时数据类型(关联系统字典表的 id 字段)
	 */
	public Long getSystemDictId() {
		return systemDictId;
	}
	/**
	 * 设置：从站地址
	 */
	public void setSubStationAddr(String subStationAddr) {
		this.subStationAddr = subStationAddr;
	}
	/**
	 * 获取：从站地址
	 */
	public String getSubStationAddr() {
		return subStationAddr;
	}
	/**
	 * 设置：功能码(1,2,3. 1.写单个线圈 2单个寄存器 3多个寄存器
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	/**
	 * 获取：功能码(1,2,3. 1.写单个线圈 2单个寄存器 3多个寄存器
	 */
	public String getFunctionCode() {
		return functionCode;
	}
	/**
	 * 设置：寄存器地址
	 */
	public void setRegisterAddr(String registerAddr) {
		this.registerAddr = registerAddr;
	}
	/**
	 * 获取：寄存器地址
	 */
	public String getRegisterAddr() {
		return registerAddr;
	}
	/**
	 * 设置：数据类型
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * 获取：数据类型
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * 设置：解码顺序
	 */
	public void setDecodeFlag(String decodeFlag) {
		this.decodeFlag = decodeFlag;
	}
	/**
	 * 获取：解码顺序
	 */
	public String getDecodeFlag() {
		return decodeFlag;
	}
	/**
	 * 设置：单位
	 */
	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}
	/**
	 * 获取：单位
	 */
	public String getDataUnit() {
		return dataUnit;
	}
	/**
	 * 设置：换算系数
	 */
	public void setRatioExchange(BigDecimal ratioExchange) {
		this.ratioExchange = ratioExchange;
	}
	/**
	 * 获取：换算系数
	 */
	public BigDecimal getRatioExchange() {
		return ratioExchange;
	}
	/**
	 * 设置：输入上限
	 */
	public void setInputTopLimit(BigDecimal inputTopLimit) {
		this.inputTopLimit = inputTopLimit;
	}
	/**
	 * 获取：输入上限
	 */
	public BigDecimal getInputTopLimit() {
		return inputTopLimit;
	}
	/**
	 * 设置：输入下限
	 */
	public void setInputLowLimit(BigDecimal inputLowLimit) {
		this.inputLowLimit = inputLowLimit;
	}
	/**
	 * 获取：输入下限
	 */
	public BigDecimal getInputLowLimit() {
		return inputLowLimit;
	}
	/**
	 * 设置：0 对应的内容 开关量对应
	 */
	public void setContentZero(String contentZero) {
		this.contentZero = contentZero;
	}
	/**
	 * 获取：0 对应的内容 开关量对应
	 */
	public String getContentZero() {
		return contentZero;
	}
	/**
	 * 设置：1 对应的内容 开关量对应
	 */
	public void setContentOne(String contentOne) {
		this.contentOne = contentOne;
	}
	/**
	 * 获取：1 对应的内容 开关量对应
	 */
	public String getContentOne() {
		return contentOne;
	}
	/**
	 * 设置：图片地址
	 */
	public void setPicAddr(String picAddr) {
		this.picAddr = picAddr;
	}
	/**
	 * 获取：图片地址
	 */
	public String getPicAddr() {
		return picAddr;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：排序字段
	 */
	public void setDataOrderby(Long dataOrderby) {
		this.dataOrderby = dataOrderby;
	}
	/**
	 * 获取：排序字段
	 */
	public Long getDataOrderby() {
		return dataOrderby;
	}
}
