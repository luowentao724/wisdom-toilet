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
 * @date 2019-05-02 18:27:02
 */
@Table(name = "station_type")
public class StationType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //子站类型id(公厕类型编号)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //公厕类型名称
    @Column(name = "station_type_name")
    private String stationTypeName;
	

	/**
	 * 设置：子站类型id(公厕类型编号)
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：子站类型id(公厕类型编号)
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：公厕类型名称
	 */
	public void setStationTypeName(String stationTypeName) {
		this.stationTypeName = stationTypeName;
	}
	/**
	 * 获取：公厕类型名称
	 */
	public String getStationTypeName() {
		return stationTypeName;
	}
}
