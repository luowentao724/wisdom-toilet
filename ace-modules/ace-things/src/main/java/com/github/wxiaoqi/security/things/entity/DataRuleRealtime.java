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
 * 数据规则实时数据
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-29 17:23:59
 */
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@Table(name = "data_rule_realtime")
public class DataRuleRealtime implements Serializable {
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
	
	    //功能码(1,2,3,4.1，2，3，4.如果选择1和2，则数据类型为开关量。如果为3，4，为其他数据类型
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
	
	    //数据单位
    @Column(name = "data_unit")
    private String dataUnit;
	
	    //bit位
    @Column(name = "data_bit")
    private String dataBit;
	
	    //0 对应的内容 开关量对应
    @Column(name = "content_zero")
    private String contentZero;
	
	    //1 对应的内容 开关量对应
    @Column(name = "content_one")
    private String contentOne;
	
	    //小数位
    @Column(name = "data_digit")
    private Integer dataDigit;
	
	    //换算系数
    @Column(name = "ratio_exchange")
    private Integer ratioExchange;
	
	    //数据处理公式
    @Column(name = "data_deal_fun")
    private String dataDealFun;
	
	    //映射
    @Column(name = "data_mapping")
    private String dataMapping;
	
	    //寄存器起始地址
    @Column(name = "register_start")
    private String registerStart;
	
	    //是否在历史数据中显示 0否 1是
    @Column(name = "history_show_flag")
    private Integer historyShowFlag;
	
	    //图片地址
    @Column(name = "pic_addr")
    private String picAddr;
	
	    //排序字段
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "data_orderby")
    private Long dataOrderby;
	
	    //是否启用报警
    @Column(name = "alarm_flag")
    private Integer alarmFlag;
	
	    //报警上限/报警值 (如果是开关量,文件描述为报警值)
    @Column(name = "alarm_top_limit")
    private BigDecimal alarmTopLimit;
	
	    //上限报警内容/报警内容
    @Column(name = "alarm_content_up")
    private String alarmContentUp;
	
	    //报警下限
    @Column(name = "alarm_low_limit")
    private BigDecimal alarmLowLimit;
	
	    //下限报警内容
    @Column(name = "alarm_content_down")
    private String alarmContentDown;
	
	    //报警滤波次数
    @Column(name = "alarm_wave_filter")
    private Integer alarmWaveFilter;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;

	//数据名称
	@Transient
	private String dictName;

	//存储当前实时数据对应的实时数据对象
	@Transient
	private RealDataInfo realDataInfo;

	//报警类型名称
	public String getDictName() {
		if (systemDictId == null) return null;
		return SystemDictBiz.getDictNameKey(systemDictId);
	}

	public RealDataInfo getRealDataInfo() {
		return realDataInfo;
	}

	public void setRealDataInfo(RealDataInfo realDataInfo) {
		this.realDataInfo = realDataInfo;
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
	 * 设置：功能码(1,2,3,4.1，2，3，4.如果选择1和2，则数据类型为开关量。如果为3，4，为其他数据类型
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	/**
	 * 获取：功能码(1,2,3,4.1，2，3，4.如果选择1和2，则数据类型为开关量。如果为3，4，为其他数据类型
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
	 * 设置：数据单位
	 */
	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}
	/**
	 * 获取：数据单位
	 */
	public String getDataUnit() {
		return dataUnit;
	}
	/**
	 * 设置：bit位
	 */
	public void setDataBit(String dataBit) {
		this.dataBit = dataBit;
	}
	/**
	 * 获取：bit位
	 */
	public String getDataBit() {
		return dataBit;
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
	 * 设置：小数位
	 */
	public void setDataDigit(Integer dataDigit) {
		this.dataDigit = dataDigit;
	}
	/**
	 * 获取：小数位
	 */
	public Integer getDataDigit() {
		return dataDigit;
	}
	/**
	 * 设置：换算系数
	 */
	public void setRatioExchange(Integer ratioExchange) {
		this.ratioExchange = ratioExchange;
	}
	/**
	 * 获取：换算系数
	 */
	public Integer getRatioExchange() {
		return ratioExchange;
	}
	/**
	 * 设置：数据处理公式
	 */
	public void setDataDealFun(String dataDealFun) {
		this.dataDealFun = dataDealFun;
	}
	/**
	 * 获取：数据处理公式
	 */
	public String getDataDealFun() {
		return dataDealFun;
	}
	/**
	 * 设置：映射
	 */
	public void setDataMapping(String dataMapping) {
		this.dataMapping = dataMapping;
	}
	/**
	 * 获取：映射
	 */
	public String getDataMapping() {
		return dataMapping;
	}
	/**
	 * 设置：寄存器起始地址
	 */
	public void setRegisterStart(String registerStart) {
		this.registerStart = registerStart;
	}
	/**
	 * 获取：寄存器起始地址
	 */
	public String getRegisterStart() {
		return registerStart;
	}
	/**
	 * 设置：是否在历史数据中显示 0否 1是
	 */
	public void setHistoryShowFlag(Integer historyShowFlag) {
		this.historyShowFlag = historyShowFlag;
	}
	/**
	 * 获取：是否在历史数据中显示 0否 1是
	 */
	public Integer getHistoryShowFlag() {
		return historyShowFlag;
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
	/**
	 * 设置：是否启用报警
	 */
	public void setAlarmFlag(Integer alarmFlag) {
		this.alarmFlag = alarmFlag;
	}
	/**
	 * 获取：是否启用报警
	 */
	public Integer getAlarmFlag() {
		return alarmFlag;
	}
	/**
	 * 设置：报警上限/报警值 (如果是开关量,文件描述为报警值)
	 */
	public void setAlarmTopLimit(BigDecimal alarmTopLimit) {
		this.alarmTopLimit = alarmTopLimit;
	}
	/**
	 * 获取：报警上限/报警值 (如果是开关量,文件描述为报警值)
	 */
	public BigDecimal getAlarmTopLimit() {
		return alarmTopLimit;
	}
	/**
	 * 设置：上限报警内容/报警内容
	 */
	public void setAlarmContentUp(String alarmContentUp) {
		this.alarmContentUp = alarmContentUp;
	}
	/**
	 * 获取：上限报警内容/报警内容
	 */
	public String getAlarmContentUp() {
		return alarmContentUp;
	}
	/**
	 * 设置：报警下限
	 */
	public void setAlarmLowLimit(BigDecimal alarmLowLimit) {
		this.alarmLowLimit = alarmLowLimit;
	}
	/**
	 * 获取：报警下限
	 */
	public BigDecimal getAlarmLowLimit() {
		return alarmLowLimit;
	}
	/**
	 * 设置：下限报警内容
	 */
	public void setAlarmContentDown(String alarmContentDown) {
		this.alarmContentDown = alarmContentDown;
	}
	/**
	 * 获取：下限报警内容
	 */
	public String getAlarmContentDown() {
		return alarmContentDown;
	}
	/**
	 * 设置：报警滤波次数
	 */
	public void setAlarmWaveFilter(Integer alarmWaveFilter) {
		this.alarmWaveFilter = alarmWaveFilter;
	}
	/**
	 * 获取：报警滤波次数
	 */
	public Integer getAlarmWaveFilter() {
		return alarmWaveFilter;
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
}
