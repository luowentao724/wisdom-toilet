package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-13 15:13:48
 */
@Table(name = "stations")
public class Stations implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //子站(公厕)id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //对应数据规则id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "data_rule_id")
    private Long dataRuleId;
	
	    //sim号
    @Column(name = "sim")
    private String sim;
	
	    //是否公开(1公开 0不公开)
    @Column(name = "is_public")
    private Integer isPublic;
	
	    //所在地址
    @Column(name = "area_info")
    private String areaInfo;
	
	    //sn码
    @Column(name = "code_sn")
    private String codeSn;
	
	    //公厕名称
    @Column(name = "totil_name")
    private String totilName;
	
	    //公厕编号
    @Column(name = "totil_id")
    private String totilId;
	
	    //区域位置id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "area_id")
    private Long areaId;
	
	    //便器数量
    @Column(name = "totil_nums")
    private Integer totilNums;
	
	    //泵站数量
    @Column(name = "bump_nums")
    private Integer bumpNums;
	
	    //所属客户id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "customer_id")
    private Long customerId;
	
	    //备注
    @Column(name = "remark")
    private String remark;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	
	    //创建人id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "create_man")
    private Long createMan;
	
	    //照片地址
    @Column(name = "totil_pic")
    private String totilPic;
	
	    //公厕类型编号
    @Column(name = "totil_type_id")
    private Long totilTypeId;
	
	    //公厕状态
    @Column(name = "totil_state")
    private Integer totilState;
	
	    //联系人姓名
    @Column(name = "rel_name")
    private String relName;
	
	    //联系人电话
    @Column(name = "rel_phone")
    private String relPhone;
	
	    //联系人邮箱
    @Column(name = "rel_email")
    private String relEmail;
	
	    //经度
    @Column(name = "lng")
    private Double lng;
	
	    //维度
    @Column(name = "lat")
    private Double lat;
	
	    //实时真空度
    @Column(name = "current_pump_station_data")
    private Integer currentPumpStationData;
	
	    //是否报警标识 0没有报警数据 1有报警数据
    @Column(name = "alarm_status")
    private Integer alarmStatus;
	
	    //登录ip地址
    @Column(name = "ip_address")
    private String ipAddress;
	
	    //屏蔽报警标识(默认值为0) 0 未屏蔽 1 已屏蔽
    @Column(name = "ignore_alarm")
    private Integer ignoreAlarm;
	
	    //屏蔽报警开始时间
    @Column(name = "ignore_time")
    private Date ignoreTime;
	
	    //
    @Column(name = "alarm_packet")
    private String alarmPacket;
	
	    //该厕所是否公开 0 未公开 1公开
    @Column(name = "is_open")
    private String isOpen;

	//厂商code
	@Column(name = "factory")
	private String factory;
	
	    //
    @Column(name = "reverse1")
    private Integer reverse1;
	
	    //
    @Column(name = "reverse2")
    private Integer reverse2;
	
	    //
    @Column(name = "reverse3")
    private Integer reverse3;
	
	    //
    @Column(name = "reverse4")
    private Integer reverse4;
	
	    //
    @Column(name = "reverse_alarm")
    private Integer reverseAlarm;


	//客户名称
	@Transient
	private String customerName;

	//数据规则名称
	@Transient
	private String dataRuleName;

	//累积冲洗次数 3/3/3
	@Transient
	private String accumulateTimes;

	public String getDataRuleName() {
		return dataRuleName;
	}

	public void setDataRuleName(String dataRuleName) {
		this.dataRuleName = dataRuleName;
	}

	//客户实体类
	@Transient
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccumulateTimes() {
		return accumulateTimes;
	}

	public void setAccumulateTimes(String accumulateTimes) {
		this.accumulateTimes = accumulateTimes;
	}


	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	/**
	 * 设置：子站(公厕)id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：子站(公厕)id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：对应数据规则id
	 */
	public void setDataRuleId(Long dataRuleId) {
		this.dataRuleId = dataRuleId;
	}
	/**
	 * 获取：对应数据规则id
	 */
	public Long getDataRuleId() {
		return dataRuleId;
	}
	/**
	 * 设置：sim号
	 */
	public void setSim(String sim) {
		this.sim = sim;
	}
	/**
	 * 获取：sim号
	 */
	public String getSim() {
		return sim;
	}
	/**
	 * 设置：是否公开(1公开 0不公开)
	 */
	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}
	/**
	 * 获取：是否公开(1公开 0不公开)
	 */
	public Integer getIsPublic() {
		return isPublic;
	}
	/**
	 * 设置：所在地址
	 */
	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}
	/**
	 * 获取：所在地址
	 */
	public String getAreaInfo() {
		return areaInfo;
	}
	/**
	 * 设置：sn码
	 */
	public void setCodeSn(String codeSn) {
		this.codeSn = codeSn;
	}
	/**
	 * 获取：sn码
	 */
	public String getCodeSn() {
		return codeSn;
	}
	/**
	 * 设置：公厕名称
	 */
	public void setTotilName(String totilName) {
		this.totilName = totilName;
	}
	/**
	 * 获取：公厕名称
	 */
	public String getTotilName() {
		return totilName;
	}
	/**
	 * 设置：公厕编号
	 */
	public void setTotilId(String totilId) {
		this.totilId = totilId;
	}
	/**
	 * 获取：公厕编号
	 */
	public String getTotilId() {
		return totilId;
	}
	/**
	 * 设置：区域位置id
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：区域位置id
	 */
	public Long getAreaId() {
		return areaId;
	}
	/**
	 * 设置：便器数量
	 */
	public void setTotilNums(Integer totilNums) {
		this.totilNums = totilNums;
	}
	/**
	 * 获取：便器数量
	 */
	public Integer getTotilNums() {
		return totilNums;
	}
	/**
	 * 设置：泵站数量
	 */
	public void setBumpNums(Integer bumpNums) {
		this.bumpNums = bumpNums;
	}
	/**
	 * 获取：泵站数量
	 */
	public Integer getBumpNums() {
		return bumpNums;
	}
	/**
	 * 设置：所属客户id
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：所属客户id
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：创建人id
	 */
	public void setCreateMan(Long createMan) {
		this.createMan = createMan;
	}
	/**
	 * 获取：创建人id
	 */
	public Long getCreateMan() {
		return createMan;
	}
	/**
	 * 设置：照片地址
	 */
	public void setTotilPic(String totilPic) {
		this.totilPic = totilPic;
	}
	/**
	 * 获取：照片地址
	 */
	public String getTotilPic() {
		return totilPic;
	}
	/**
	 * 设置：公厕类型编号
	 */
	public void setTotilTypeId(Long totilTypeId) {
		this.totilTypeId = totilTypeId;
	}
	/**
	 * 获取：公厕类型编号
	 */
	public Long getTotilTypeId() {
		return totilTypeId;
	}
	/**
	 * 设置：公厕状态
	 */
	public void setTotilState(Integer totilState) {
		this.totilState = totilState;
	}
	/**
	 * 获取：公厕状态
	 */
	public Integer getTotilState() {
		return totilState;
	}
	/**
	 * 设置：联系人姓名
	 */
	public void setRelName(String relName) {
		this.relName = relName;
	}
	/**
	 * 获取：联系人姓名
	 */
	public String getRelName() {
		return relName;
	}
	/**
	 * 设置：联系人电话
	 */
	public void setRelPhone(String relPhone) {
		this.relPhone = relPhone;
	}
	/**
	 * 获取：联系人电话
	 */
	public String getRelPhone() {
		return relPhone;
	}
	/**
	 * 设置：联系人邮箱
	 */
	public void setRelEmail(String relEmail) {
		this.relEmail = relEmail;
	}
	/**
	 * 获取：联系人邮箱
	 */
	public String getRelEmail() {
		return relEmail;
	}
	/**
	 * 设置：经度
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}
	/**
	 * 获取：经度
	 */
	public Double getLng() {
		return lng;
	}
	/**
	 * 设置：维度
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}
	/**
	 * 获取：维度
	 */
	public Double getLat() {
		return lat;
	}
	/**
	 * 设置：实时真空度
	 */
	public void setCurrentPumpStationData(Integer currentPumpStationData) {
		this.currentPumpStationData = currentPumpStationData;
	}
	/**
	 * 获取：实时真空度
	 */
	public Integer getCurrentPumpStationData() {
		return currentPumpStationData;
	}
	/**
	 * 设置：是否报警标识 0没有报警数据 1有报警数据
	 */
	public void setAlarmStatus(Integer alarmStatus) {
		this.alarmStatus = alarmStatus;
	}
	/**
	 * 获取：是否报警标识 0没有报警数据 1有报警数据
	 */
	public Integer getAlarmStatus() {
		return alarmStatus;
	}
	/**
	 * 设置：登录ip地址
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * 获取：登录ip地址
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * 设置：屏蔽报警标识(默认值为0) 0 未屏蔽 1 已屏蔽
	 */
	public void setIgnoreAlarm(Integer ignoreAlarm) {
		this.ignoreAlarm = ignoreAlarm;
	}
	/**
	 * 获取：屏蔽报警标识(默认值为0) 0 未屏蔽 1 已屏蔽
	 */
	public Integer getIgnoreAlarm() {
		return ignoreAlarm;
	}
	/**
	 * 设置：屏蔽报警开始时间
	 */
	public void setIgnoreTime(Date ignoreTime) {
		this.ignoreTime = ignoreTime;
	}
	/**
	 * 获取：屏蔽报警开始时间
	 */
	public Date getIgnoreTime() {
		return ignoreTime;
	}
	/**
	 * 设置：
	 */
	public void setAlarmPacket(String alarmPacket) {
		this.alarmPacket = alarmPacket;
	}
	/**
	 * 获取：
	 */
	public String getAlarmPacket() {
		return alarmPacket;
	}
	/**
	 * 设置：该厕所是否公开 0 未公开 1公开
	 */
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	/**
	 * 获取：该厕所是否公开 0 未公开 1公开
	 */
	public String getIsOpen() {
		return isOpen;
	}
	/**
	 * 设置：
	 */
	public void setReverse1(Integer reverse1) {
		this.reverse1 = reverse1;
	}
	/**
	 * 获取：
	 */
	public Integer getReverse1() {
		return reverse1;
	}
	/**
	 * 设置：
	 */
	public void setReverse2(Integer reverse2) {
		this.reverse2 = reverse2;
	}
	/**
	 * 获取：
	 */
	public Integer getReverse2() {
		return reverse2;
	}
	/**
	 * 设置：
	 */
	public void setReverse3(Integer reverse3) {
		this.reverse3 = reverse3;
	}
	/**
	 * 获取：
	 */
	public Integer getReverse3() {
		return reverse3;
	}
	/**
	 * 设置：
	 */
	public void setReverse4(Integer reverse4) {
		this.reverse4 = reverse4;
	}
	/**
	 * 获取：
	 */
	public Integer getReverse4() {
		return reverse4;
	}
	/**
	 * 设置：
	 */
	public void setReverseAlarm(Integer reverseAlarm) {
		this.reverseAlarm = reverseAlarm;
	}
	/**
	 * 获取：
	 */
	public Integer getReverseAlarm() {
		return reverseAlarm;
	}
}
