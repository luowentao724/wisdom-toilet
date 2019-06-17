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
 * @date 2019-05-10 17:41:26
 */
@Table(name = "system_dict")
public class SystemDict implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //字典id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //系统字典编码
    @Column(name = "dict_id")
    private String dictId;
	
	    //名称
    @Column(name = "dict_name")
    private String dictName;
	
	    //数据单位
    @Column(name = "dict_unit")
    private String dictUnit;
	
	    //类型
    @Column(name = "type")
    private String type;
	
	    //关联表名
    @Column(name = "rel_table")
    private String relTable;
	

	/**
	 * 设置：字典id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：字典id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：系统字典编码
	 */
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	/**
	 * 获取：系统字典编码
	 */
	public String getDictId() {
		return dictId;
	}
	/**
	 * 设置：名称
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**
	 * 获取：名称
	 */
	public String getDictName() {
		return dictName;
	}
	/**
	 * 设置：数据单位
	 */
	public void setDictUnit(String dictUnit) {
		this.dictUnit = dictUnit;
	}
	/**
	 * 获取：数据单位
	 */
	public String getDictUnit() {
		return dictUnit;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：关联表名
	 */
	public void setRelTable(String relTable) {
		this.relTable = relTable;
	}
	/**
	 * 获取：关联表名
	 */
	public String getRelTable() {
		return relTable;
	}
}
