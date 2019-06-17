package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.wxiaoqi.security.things.biz.SystemDictBiz;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * 报警信息表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-09 21:39:13
 */
@Table(name = "concent_alarm")
public class ConcentAlarm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //报警id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long alarmId;
	
	    //子站(公厕)id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "dtu_id")
    private Long dtuId;
	
	    //报警类型
    @Column(name = "alarm_type")
    private Integer alarmType;
	
	    //用于发生邮件等的报警内容
    @Column(name = "alarm_content")
    private String alarmContent;
	
	    //报警时间
    @Column(name = "alarm_time")
    private Date alarmTime;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	
	    //详细信息
    @Column(name = "descn")
    private String descn;
	
	    //处理方式
    @Column(name = "fix_type")
    private Integer fixType;
	
	    //处理时间
    @Column(name = "fix_time")
    private Date fixTime;
	
	    //描述信息
    @Column(name = "fix_descn")
    private String fixDescn;
	
	    //处理人id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "fix_user_id")
    private Long fixUserId;
	
	    //处理人姓名
    @Column(name = "fix_user_name")
    private String fixUserName;
	
	    //
    @Column(name = "sms_count")
    private Integer smsCount;
	
	    //短信通知标识
    @Column(name = "sms")
    private Integer sms;
	
	    //手机号
    @Column(name = "sms_phone")
    private String smsPhone;
	
	    //邮件通知标识
    @Column(name = "email")
    private Integer email;
	
	    //邮件地址
    @Column(name = "email_address")
    private String emailAddress;
	
	    //
    @Column(name = "alarm_packet")
    private String alarmPacket;
	
	    //状态[1竣工0未竣工]
    @Column(name = "status")
    private Integer status;


	// DTU名称
	@Transient
	private String totilName;

	// DTU标识码
	@Transient
	private String totilId;

	// 报警类型
	@Transient
	private String alarmTypeName;

	// 处理方式
	@Transient
	private String fixTypeName;

	//报警类型名称
	public String getAlarmTypeName() {
		if (alarmType == null) return null;
		return SystemDictBiz.getDDDesc("ALARM_TYPE", alarmType.toString());
	}

	//处理方式名称
	public String getFixTypeName() {
		if (fixType == null) return null;
		return SystemDictBiz.getDDDesc("FIX_TYPE", fixType.toString());
	}

	public String getTotilName() {
		return totilName;
	}

	public void setTotilName(String totilName) {
		this.totilName = totilName;
	}

	public String getTotilId() {
		return totilId;
	}

	public void setTotilId(String totilId) {
		this.totilId = totilId;
	}

	/**
	 * 设置：报警id
	 */
	public void setAlarmId(Long alarmId) {
		this.alarmId = alarmId;
	}
	/**
	 * 获取：报警id
	 */
	public Long getAlarmId() {
		return alarmId;
	}
	/**
	 * 设置：子站(公厕)id
	 */
	public void setDtuId(Long dtuId) {
		this.dtuId = dtuId;
	}
	/**
	 * 获取：子站(公厕)id
	 */
	public Long getDtuId() {
		return dtuId;
	}
	/**
	 * 设置：报警类型
	 */
	public void setAlarmType(Integer alarmType) {
		this.alarmType = alarmType;
	}
	/**
	 * 获取：报警类型
	 */
	public Integer getAlarmType() {
		return alarmType;
	}
	/**
	 * 设置：用于发生邮件等的报警内容
	 */
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	/**
	 * 获取：用于发生邮件等的报警内容
	 */
	public String getAlarmContent() {
		return alarmContent;
	}
	/**
	 * 设置：报警时间
	 */
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
	/**
	 * 获取：报警时间
	 */
	public Date getAlarmTime() {
		return alarmTime;
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
	 * 设置：详细信息
	 */
	public void setDescn(String descn) {
		this.descn = descn;
	}
	/**
	 * 获取：详细信息
	 */
	public String getDescn() {
		return descn;
	}
	/**
	 * 设置：处理方式
	 */
	public void setFixType(Integer fixType) {
		this.fixType = fixType;
	}
	/**
	 * 获取：处理方式
	 */
	public Integer getFixType() {
		return fixType;
	}
	/**
	 * 设置：处理时间
	 */
	public void setFixTime(Date fixTime) {
		this.fixTime = fixTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getFixTime() {
		return fixTime;
	}
	/**
	 * 设置：描述信息
	 */
	public void setFixDescn(String fixDescn) {
		this.fixDescn = fixDescn;
	}
	/**
	 * 获取：描述信息
	 */
	public String getFixDescn() {
		return fixDescn;
	}
	/**
	 * 设置：处理人id
	 */
	public void setFixUserId(Long fixUserId) {
		this.fixUserId = fixUserId;
	}
	/**
	 * 获取：处理人id
	 */
	public Long getFixUserId() {
		return fixUserId;
	}
	/**
	 * 设置：处理人姓名
	 */
	public void setFixUserName(String fixUserName) {
		this.fixUserName = fixUserName;
	}
	/**
	 * 获取：处理人姓名
	 */
	public String getFixUserName() {
		return fixUserName;
	}
	/**
	 * 设置：
	 */
	public void setSmsCount(Integer smsCount) {
		this.smsCount = smsCount;
	}
	/**
	 * 获取：
	 */
	public Integer getSmsCount() {
		return smsCount;
	}
	/**
	 * 设置：短信通知标识
	 */
	public void setSms(Integer sms) {
		this.sms = sms;
	}
	/**
	 * 获取：短信通知标识
	 */
	public Integer getSms() {
		return sms;
	}
	/**
	 * 设置：手机号
	 */
	public void setSmsPhone(String smsPhone) {
		this.smsPhone = smsPhone;
	}
	/**
	 * 获取：手机号
	 */
	public String getSmsPhone() {
		return smsPhone;
	}
	/**
	 * 设置：邮件通知标识
	 */
	public void setEmail(Integer email) {
		this.email = email;
	}
	/**
	 * 获取：邮件通知标识
	 */
	public Integer getEmail() {
		return email;
	}
	/**
	 * 设置：邮件地址
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * 获取：邮件地址
	 */
	public String getEmailAddress() {
		return emailAddress;
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
	 * 设置：状态[1竣工0未竣工]
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态[1竣工0未竣工]
	 */
	public Integer getStatus() {
		return status;
	}
}
