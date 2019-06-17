package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-04-25 17:37:45
 */
@Table(name = "area")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Id
    private Long id;
	
	    //
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "parent_id")
    private Long parentId;
	
	    //
    @Column(name = "area_name")
    private String areaName;
	
	    //
    @Column(name = "area_type")
    private Integer areaType;
	
	    //
    @Column(name = "remark")
    private String remark;


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
	 * 设置：
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 获取：
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 设置：
	 */
	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
	/**
	 * 获取：
	 */
	public Integer getAreaType() {
		return areaType;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
}
