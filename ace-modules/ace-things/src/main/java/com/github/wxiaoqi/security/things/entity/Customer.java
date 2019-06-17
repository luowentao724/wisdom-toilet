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
 * @date 2019-05-01 16:06:01
 */
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //
    @Column(name = "customer_name")
    private String customerName;
	
	    //
    @Column(name = "system_name")
    private String systemName;
	
	    //
    @Column(name = "system_logo")
    private String systemLogo;
	
	    //
    @Column(name = "contract_name")
    private String contractName;
	
	    //
    @Column(name = "contract_phone")
    private String contractPhone;
	
	    //
    @Column(name = "contract_email")
    private String contractEmail;
	
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
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	/**
	 * 获取：
	 */
	public String getSystemName() {
		return systemName;
	}
	/**
	 * 设置：
	 */
	public void setSystemLogo(String systemLogo) {
		this.systemLogo = systemLogo;
	}
	/**
	 * 获取：
	 */
	public String getSystemLogo() {
		return systemLogo;
	}
	/**
	 * 设置：
	 */
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	/**
	 * 获取：
	 */
	public String getContractName() {
		return contractName;
	}
	/**
	 * 设置：
	 */
	public void setContractPhone(String contractPhone) {
		this.contractPhone = contractPhone;
	}
	/**
	 * 获取：
	 */
	public String getContractPhone() {
		return contractPhone;
	}
	/**
	 * 设置：
	 */
	public void setContractEmail(String contractEmail) {
		this.contractEmail = contractEmail;
	}
	/**
	 * 获取：
	 */
	public String getContractEmail() {
		return contractEmail;
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
