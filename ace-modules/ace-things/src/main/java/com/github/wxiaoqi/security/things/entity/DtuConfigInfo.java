package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-04 08:40:07
 */
@Table(name = "dtu_config_info")
public class DtuConfigInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //设备参数配置表id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //参数编码
    @Column(name = "code")
    private String code;
	
	    //参数名称
    @Column(name = "name")
    private String name;
	
	    //参数值
    @Column(name = "value")
    private String value;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	

	/**
	 * 设置：设备参数配置表id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：设备参数配置表id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：参数编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：参数编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：参数名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：参数名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：参数值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：参数值
	 */
	public String getValue() {
		return value;
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
