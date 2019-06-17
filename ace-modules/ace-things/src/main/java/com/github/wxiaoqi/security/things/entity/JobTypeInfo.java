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
 * @date 2019-05-02 16:09:27
 */
@Table(name = "job_type_info")
public class JobTypeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //员工岗位类型id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //员工岗位类型名称
    @Column(name = "job_type_name")
    private String jobTypeName;
	

	/**
	 * 设置：员工岗位类型id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：员工岗位类型id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：员工岗位类型名称
	 */
	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
	/**
	 * 获取：员工岗位类型名称
	 */
	public String getJobTypeName() {
		return jobTypeName;
	}
}
