package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 数据规则
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-28 11:04:17
 */
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@Table(name = "data_rule")
public class DataRule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //规则名称
    @Column(name = "rule_name")
    private String ruleName;
	
	    //数据展示[list列表group组态]
    @Column(name = "type")
    private String type;
	
	    //规则说明
    @Column(name = "remark")
    private String remark;
	
	    //实时数据[show显示hide隐藏]
    @Column(name = "realtime")
    private String realtime;
	
	    //数据读写[show显示hide隐藏]
    @Column(name = "read_btn")
    private String readBtn;
	
	    //历史数据[show显示hide隐藏]
    @Column(name = "history")
    private String history;
	
	    //报警记录[show显示hide隐藏]
    @Column(name = "alarm")
    private String alarm;
	
	    //消息推送管理账号(0:不推送 1推送)
    @Column(name = "manage_push")
    private Integer managePush;
	
	    //消息推送普通账号(0:不推送 1推送)
    @Column(name = "ordinary_push")
    private Integer ordinaryPush;
	
	    //通讯故障检测[close关闭open开启]
    @Column(name = "fault")
    private String fault;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	
	    //通讯故障滤波(次)
    @Column(name = "times")
    private Integer times;
	
	    //实时数据普通账号 (0隐藏数据 1显示数据)
    @Column(name = "ordinary_realtime")
    private Integer ordinaryRealtime;
	
	    //数据读写普通账号 (0隐藏数据 1显示数据)
    @Column(name = "ordinary_read_btn")
    private Integer ordinaryReadBtn;
	
	    //历史数据普通账号 (0隐藏数据 1显示数据)
    @Column(name = "ordinary_history")
    private Integer ordinaryHistory;
	
	    //报警记录普通账号 (0隐藏数据 1显示数据)
    @Column(name = "ordinary_alarm")
    private Integer ordinaryAlarm;

    @Transient
    private List<DataRuleRealtime> dataRuleRealtimeList;

	@Transient
    private  List<DataRuleRead> dataRuleReadList;


	public List<DataRuleRealtime> getDataRuleRealtimeList() {
		return dataRuleRealtimeList;
	}

	public void setDataRuleRealtimeList(List<DataRuleRealtime> dataRuleRealtimeList) {
		this.dataRuleRealtimeList = dataRuleRealtimeList;
	}

	public List<DataRuleRead> getDataRuleReadList() {
		return dataRuleReadList;
	}

	public void setDataRuleReadList(List<DataRuleRead> dataRuleReadList) {
		this.dataRuleReadList = dataRuleReadList;
	}

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：规则名称
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	/**
	 * 获取：规则名称
	 */
	public String getRuleName() {
		return ruleName;
	}
	/**
	 * 设置：数据展示[list列表group组态]
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：数据展示[list列表group组态]
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：规则说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：规则说明
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：实时数据[show显示hide隐藏]
	 */
	public void setRealtime(String realtime) {
		this.realtime = realtime;
	}
	/**
	 * 获取：实时数据[show显示hide隐藏]
	 */
	public String getRealtime() {
		return realtime;
	}
	/**
	 * 设置：数据读写[show显示hide隐藏]
	 */
	public void setReadBtn(String readBtn) {
		this.readBtn = readBtn;
	}
	/**
	 * 获取：数据读写[show显示hide隐藏]
	 */
	public String getReadBtn() {
		return readBtn;
	}
	/**
	 * 设置：历史数据[show显示hide隐藏]
	 */
	public void setHistory(String history) {
		this.history = history;
	}
	/**
	 * 获取：历史数据[show显示hide隐藏]
	 */
	public String getHistory() {
		return history;
	}
	/**
	 * 设置：报警记录[show显示hide隐藏]
	 */
	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}
	/**
	 * 获取：报警记录[show显示hide隐藏]
	 */
	public String getAlarm() {
		return alarm;
	}
	/**
	 * 设置：消息推送管理账号(0:不推送 1推送)
	 */
	public void setManagePush(Integer managePush) {
		this.managePush = managePush;
	}
	/**
	 * 获取：消息推送管理账号(0:不推送 1推送)
	 */
	public Integer getManagePush() {
		return managePush;
	}
	/**
	 * 设置：消息推送普通账号(0:不推送 1推送)
	 */
	public void setOrdinaryPush(Integer ordinaryPush) {
		this.ordinaryPush = ordinaryPush;
	}
	/**
	 * 获取：消息推送普通账号(0:不推送 1推送)
	 */
	public Integer getOrdinaryPush() {
		return ordinaryPush;
	}

	/**
	 * 设置：通讯故障检测[close关闭open开启]
	 */
	public void setFault(String fault) {
		this.fault = fault;
	}
	/**
	 * 获取：通讯故障检测[close关闭open开启]
	 */
	public String getFault() {
		return fault;
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
	 * 设置：通讯故障滤波(次)
	 */
	public void setTimes(Integer times) {
		this.times = times;
	}
	/**
	 * 获取：通讯故障滤波(次)
	 */
	public Integer getTimes() {
		return times;
	}
	/**
	 * 设置：实时数据普通账号 (0隐藏数据 1显示数据)
	 */
	public void setOrdinaryRealtime(Integer ordinaryRealtime) {
		this.ordinaryRealtime = ordinaryRealtime;
	}
	/**
	 * 获取：实时数据普通账号 (0隐藏数据 1显示数据)
	 */
	public Integer getOrdinaryRealtime() {
		return ordinaryRealtime;
	}
	/**
	 * 设置：数据读写普通账号 (0隐藏数据 1显示数据)
	 */
	public void setOrdinaryReadBtn(Integer ordinaryReadBtn) {
		this.ordinaryReadBtn = ordinaryReadBtn;
	}
	/**
	 * 获取：数据读写普通账号 (0隐藏数据 1显示数据)
	 */
	public Integer getOrdinaryReadBtn() {
		return ordinaryReadBtn;
	}
	/**
	 * 设置：历史数据普通账号 (0隐藏数据 1显示数据)
	 */
	public void setOrdinaryHistory(Integer ordinaryHistory) {
		this.ordinaryHistory = ordinaryHistory;
	}
	/**
	 * 获取：历史数据普通账号 (0隐藏数据 1显示数据)
	 */
	public Integer getOrdinaryHistory() {
		return ordinaryHistory;
	}
	/**
	 * 设置：报警记录普通账号 (0隐藏数据 1显示数据)
	 */
	public void setOrdinaryAlarm(Integer ordinaryAlarm) {
		this.ordinaryAlarm = ordinaryAlarm;
	}
	/**
	 * 获取：报警记录普通账号 (0隐藏数据 1显示数据)
	 */
	public Integer getOrdinaryAlarm() {
		return ordinaryAlarm;
	}

	@Override
	public String toString() {
		return "DataRule{" +
				"id=" + id +
				", ruleName='" + ruleName + '\'' +
				", type='" + type + '\'' +
				", remark='" + remark + '\'' +
				", realtime='" + realtime + '\'' +
				", readBtn='" + readBtn + '\'' +
				", history='" + history + '\'' +
				", alarm='" + alarm + '\'' +
				", managePush=" + managePush +
				", ordinaryPush=" + ordinaryPush +
				", fault='" + fault + '\'' +
				", createTime=" + createTime +
				", times=" + times +
				", ordinaryRealtime=" + ordinaryRealtime +
				", ordinaryReadBtn=" + ordinaryReadBtn +
				", ordinaryHistory=" + ordinaryHistory +
				", ordinaryAlarm=" + ordinaryAlarm +
				", dataRuleRealtimeList=" + dataRuleRealtimeList +
				", dataRuleReadList=" + dataRuleReadList +
				'}';
	}
}
