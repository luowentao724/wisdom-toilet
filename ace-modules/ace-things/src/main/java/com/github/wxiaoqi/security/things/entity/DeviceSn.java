package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * sn码表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-05 17:46:04
 */
@Table(name = "device_sn")
public class DeviceSn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //sn码
    @Column(name = "sn")
    private String sn;
	
	    //备注
    @Column(name = "remark")
    private String remark;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	
	    //创建账户
    @Column(name = "creater")
    private String creater;
	
	    //更新时间
    @Column(name = "update_time")
    private Date updateTime;
	
	    //关联子站
    @Column(name = "station")
    private String station;

    // 关联子站名称
	@Transient
    private String stationName;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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
	 * 设置：sn码
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	/**
	 * 获取：sn码
	 */
	public String getSn() {
		return sn;
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
	 * 设置：创建账户
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	/**
	 * 获取：创建账户
	 */
	public String getCreater() {
		return creater;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：关联子站
	 */
	public void setStation(String station) {
		this.station = station;
	}
	/**
	 * 获取：关联子站
	 */
	public String getStation() {
		return station;
	}
}
