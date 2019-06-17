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
 * @date 2019-05-24 14:08:17
 */
@Table(name = "sms_dtu_config")
public class SmsDtuConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //子站id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "dtu_id")
    private Long dtuId;
	
	    //用户表id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "user_id")
    private Long userId;
	
	    //短息消息推送标识(0:未配置 ,1已配置)
    @Column(name = "sim_flag")
    private Integer simFlag;
	
	    //邮箱消息推送标识(0:未配置 ,1已配置)
    @Column(name = "email_flag")
    private Integer emailFlag;
	
	    //备注
    @Column(name = "remark")
    private String remark;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;

	@Transient
	private String username;

	@Transient
	private String name;

	@Transient
	private String telPhone;

	@Transient
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	 * 设置：子站id
	 */
	public void setDtuId(Long dtuId) {
		this.dtuId = dtuId;
	}
	/**
	 * 获取：子站id
	 */
	public Long getDtuId() {
		return dtuId;
	}
	/**
	 * 设置：用户表id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户表id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：短息消息推送标识(0:未配置 ,1已配置)
	 */
	public void setSimFlag(Integer simFlag) {
		this.simFlag = simFlag;
	}
	/**
	 * 获取：短息消息推送标识(0:未配置 ,1已配置)
	 */
	public Integer getSimFlag() {
		return simFlag;
	}
	/**
	 * 设置：邮箱消息推送标识(0:未配置 ,1已配置)
	 */
	public void setEmailFlag(Integer emailFlag) {
		this.emailFlag = emailFlag;
	}
	/**
	 * 获取：邮箱消息推送标识(0:未配置 ,1已配置)
	 */
	public Integer getEmailFlag() {
		return emailFlag;
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
}
