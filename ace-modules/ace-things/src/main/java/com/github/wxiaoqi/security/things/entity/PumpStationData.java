package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 泵站数据信息表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-20 15:04:30
 */
@Table(name = "pump_station_data")
public class PumpStationData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id主键
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
    //子站id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "dtu_id")
    private Long dtuId;
	
    //真空度
    @Column(name = "vacuum_degree")
    private BigDecimal vacuumDegree;
	
    //数据采集时间
    @Column(name = "acquisition_time")
    private Date acquisitionTime;
	
    //当天运行时间
    @Column(name = "today_run_time")
    private Integer todayRunTime;
	
	    //累积运行时间
    @Column(name = "cumulative_run_time")
    private Integer cumulativeRunTime;
	
    //总运行时间
    @Column(name = "total_run_time")
    private Integer totalRunTime;
	
    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	

	/**
	 * 设置：id主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id主键
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
	 * 设置：真空度
	 */
	public void setVacuumDegree(BigDecimal vacuumDegree) {
		this.vacuumDegree = vacuumDegree;
	}
	/**
	 * 获取：真空度
	 */
	public BigDecimal getVacuumDegree() {
		return vacuumDegree;
	}
	/**
	 * 设置：数据采集时间
	 */
	public void setAcquisitionTime(Date acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
	}
	/**
	 * 获取：数据采集时间
	 */
	public Date getAcquisitionTime() {
		return acquisitionTime;
	}
	/**
	 * 设置：当天运行时间
	 */
	public void setTodayRunTime(Integer todayRunTime) {
		this.todayRunTime = todayRunTime;
	}
	/**
	 * 获取：当天运行时间
	 */
	public Integer getTodayRunTime() {
		return todayRunTime;
	}
	/**
	 * 设置：累积运行时间
	 */
	public void setCumulativeRunTime(Integer cumulativeRunTime) {
		this.cumulativeRunTime = cumulativeRunTime;
	}
	/**
	 * 获取：累积运行时间
	 */
	public Integer getCumulativeRunTime() {
		return cumulativeRunTime;
	}
	/**
	 * 设置：总运行时间
	 */
	public void setTotalRunTime(Integer totalRunTime) {
		this.totalRunTime = totalRunTime;
	}
	/**
	 * 获取：总运行时间
	 */
	public Integer getTotalRunTime() {
		return totalRunTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createTime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createTime;
	}
}
