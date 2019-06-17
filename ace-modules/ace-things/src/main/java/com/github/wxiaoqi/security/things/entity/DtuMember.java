package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * 员工表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-03 17:19:09
 */
@Table(name = "dtu_member")
public class DtuMember implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //姓名
    @Column(name = "nem_name")
    private String nemName;
	
	    //性别[1男0女]
    @Column(name = "sex")
    private Integer sex;
	
	    //岗位
    @Column(name = "job_type_id")
    private Long jobTypeId;
	
	    //工号
    @Column(name = "nember_id")
    private String nemberId;
	
	    //联系电话
    @Column(name = "mobile")
    private String mobile;
	
	    //状态[1启用0禁用]
    @Column(name = "state")
    private Integer state;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	
	    //备注
    @Column(name = "remark")
    private String remark;
	
	    //子站
    @Column(name = "station_id")
    private String stationId;
	

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
	 * 设置：姓名
	 */
	public void setNemName(String nemName) {
		this.nemName = nemName;
	}
	/**
	 * 获取：姓名
	 */
	public String getNemName() {
		return nemName;
	}
	/**
	 * 设置：性别[1男0女]
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别[1男0女]
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：岗位
	 */
	public void setJobTypeId(Long jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	/**
	 * 获取：岗位
	 */
	public Long getJobTypeId() {
		return jobTypeId;
	}
	/**
	 * 设置：工号
	 */
	public void setNemberId(String nemberId) {
		this.nemberId = nemberId;
	}
	/**
	 * 获取：工号
	 */
	public String getNemberId() {
		return nemberId;
	}
	/**
	 * 设置：联系电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：联系电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：状态[1启用0禁用]
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态[1启用0禁用]
	 */
	public Integer getState() {
		return state;
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
	 * 设置：子站
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	/**
	 * 获取：子站
	 */
	public String getStationId() {
		return stationId;
	}
}
