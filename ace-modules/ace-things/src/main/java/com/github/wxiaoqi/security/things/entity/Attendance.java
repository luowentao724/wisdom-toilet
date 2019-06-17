package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * 考勤表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-02 09:05:08
 */
@Table(name = "attendance")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Id
    private Long id;
	
	    //员工工号
	@Column(name = "nember_id")
    private String nemberId;
	
	    //员工姓名
    @Column(name = "nem_name")
    private String nemName;
	
	    //子站编号
    @Column(name = "station_id")
    private String stationId;
	
	    //子站名称
    @Column(name = "station_name")
    private String stationName;
	
	    //子站位置
    @Column(name = "station_place")
    private String stationPlace;
	
	    //考勤时间
    @Column(name = "create_time")
    private Date createTime;
	

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
	 * 设置：员工工号
	 */
	public void setNemberId(String nemberId) {
		this.nemberId = nemberId;
	}
	/**
	 * 获取：员工工号
	 */
	public String getNemberId() {
		return nemberId;
	}
	/**
	 * 设置：员工姓名
	 */
	public void setNemName(String nemName) {
		this.nemName = nemName;
	}
	/**
	 * 获取：员工姓名
	 */
	public String getNemName() {
		return nemName;
	}
	/**
	 * 设置：子站编号
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	/**
	 * 获取：子站编号
	 */
	public String getStationId() {
		return stationId;
	}
	/**
	 * 设置：子站名称
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	/**
	 * 获取：子站名称
	 */
	public String getStationName() {
		return stationName;
	}
	/**
	 * 设置：子站位置
	 */
	public void setStationPlace(String stationPlace) {
		this.stationPlace = stationPlace;
	}
	/**
	 * 获取：子站位置
	 */
	public String getStationPlace() {
		return stationPlace;
	}
	/**
	 * 设置：考勤时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：考勤时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
