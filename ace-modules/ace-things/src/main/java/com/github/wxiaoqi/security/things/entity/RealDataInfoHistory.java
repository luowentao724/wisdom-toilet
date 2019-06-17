package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-19 09:33:00
 */
@Table(name = "real_data_info_history")
public class RealDataInfoHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //子站编号
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "dtu_id")
    private Long dtuId;
	
	    //实时数据类型
    @Column(name = "realtime_data_type")
    private Long realtimeDataType;
	
	    //实时数据名称
    @Column(name = "realtime_data_name")
    private String realtimeDataName;
	
	    //实时数据值
    @Column(name = "real_data_value")
    private BigDecimal realDataValue;
	
	    //单位
    @Column(name = "data_unit")
    private String dataUnit;
	
	    //采集时间
    @Column(name = "gather_time")
    private Date gatherTime;
	
	    //创建日期(yyyymmdd)
    @Column(name = "create_date")
    private Date createDate;
	

	/**
	 * 设置：主键id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：子站编号
	 */
	public void setDtuId(Long dtuId) {
		this.dtuId = dtuId;
	}
	/**
	 * 获取：子站编号
	 */
	public Long getDtuId() {
		return dtuId;
	}
	/**
	 * 设置：实时数据类型
	 */
	public void setRealtimeDataType(Long realtimeDataType) {
		this.realtimeDataType = realtimeDataType;
	}
	/**
	 * 获取：实时数据类型
	 */
	public Long getRealtimeDataType() {
		return realtimeDataType;
	}
	/**
	 * 设置：实时数据名称
	 */
	public void setRealtimeDataName(String realtimeDataName) {
		this.realtimeDataName = realtimeDataName;
	}
	/**
	 * 获取：实时数据名称
	 */
	public String getRealtimeDataName() {
		return realtimeDataName;
	}
	/**
	 * 设置：实时数据值
	 */
	public void setRealDataValue(BigDecimal realDataValue) {
		this.realDataValue = realDataValue;
	}
	/**
	 * 获取：实时数据值
	 */
	public BigDecimal getRealDataValue() {
		return realDataValue;
	}
	/**
	 * 设置：单位
	 */
	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}
	/**
	 * 获取：单位
	 */
	public String getDataUnit() {
		return dataUnit;
	}
	/**
	 * 设置：采集时间
	 */
	public void setGatherTime(Date gatherTime) {
		this.gatherTime = gatherTime;
	}
	/**
	 * 获取：采集时间
	 */
	public Date getGatherTime() {
		return gatherTime;
	}
	/**
	 * 设置：创建日期(yyyymmdd)
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期(yyyymmdd)
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
