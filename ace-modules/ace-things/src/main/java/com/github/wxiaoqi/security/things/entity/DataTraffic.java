package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 流量数据明细表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-13 15:13:48
 */
@Table(name = "data_traffic")
public class DataTraffic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //系统参数编号
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "dtu_id")
    private Long dtuId;
	
	    //开始时间
    @Column(name = "open_time")
    private Date openTime;
	
	    //解释时间
    @Column(name = "close_time")
    private Date closeTime;
	
	    //上行流量
    @Column(name = "read_bytes")
    private Long readBytes;
	
	    //下行流量
    @Column(name = "written_bytes")
    private Long writtenBytes;
	
	    //上行数据包
    @Column(name = "read_messages")
    private Long readMessages;
	
	    //下行数据包
    @Column(name = "written_messages")
    private Long writtenMessages;

	// DTU名称
	@Transient
	private String totilName;

	// 设备标识码
	@Transient
	private String totilId;

	// SIM卡号
	@Transient
	private String simCard;

	// 本月在线时长
	@Transient
	private BigDecimal onlineTimeMonth;

	// 本月累积流量
	@Transient
	private BigDecimal cumulativeTrafficMonth;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getTotilName() {
		return totilName;
	}

	public void setTotilName(String totilName) {
		this.totilName = totilName;
	}

	public String getTotilId() {
		return totilId;
	}

	public void setTotilId(String totilId) {
		this.totilId = totilId;
	}

	public String getSimCard() {
		return simCard;
	}

	public void setSimCard(String simCard) {
		this.simCard = simCard;
	}

	public BigDecimal getOnlineTimeMonth() {
		return onlineTimeMonth;
	}

	public void setOnlineTimeMonth(BigDecimal onlineTimeMonth) {
		this.onlineTimeMonth = onlineTimeMonth;
	}

	public BigDecimal getCumulativeTrafficMonth() {
		return cumulativeTrafficMonth;
	}

	public void setCumulativeTrafficMonth(BigDecimal cumulativeTrafficMonth) {
		this.cumulativeTrafficMonth = cumulativeTrafficMonth;
	}

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：系统参数编号
	 */
	public void setDtuId(Long dtuId) {
		this.dtuId = dtuId;
	}
	/**
	 * 获取：系统参数编号
	 */
	public Long getDtuId() {
		return dtuId;
	}
	/**
	 * 设置：开始时间
	 */
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getOpenTime() {
		return openTime;
	}
	/**
	 * 设置：解释时间
	 */
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	/**
	 * 获取：解释时间
	 */
	public Date getCloseTime() {
		return closeTime;
	}
	/**
	 * 设置：上行流量
	 */
	public void setReadBytes(Long readBytes) {
		this.readBytes = readBytes;
	}
	/**
	 * 获取：上行流量
	 */
	public Long getReadBytes() {
		return readBytes;
	}
	/**
	 * 设置：下行流量
	 */
	public void setWrittenBytes(Long writtenBytes) {
		this.writtenBytes = writtenBytes;
	}
	/**
	 * 获取：下行流量
	 */
	public Long getWrittenBytes() {
		return writtenBytes;
	}
	/**
	 * 设置：上行数据包
	 */
	public void setReadMessages(Long readMessages) {
		this.readMessages = readMessages;
	}
	/**
	 * 获取：上行数据包
	 */
	public Long getReadMessages() {
		return readMessages;
	}
	/**
	 * 设置：下行数据包
	 */
	public void setWrittenMessages(Long writtenMessages) {
		this.writtenMessages = writtenMessages;
	}
	/**
	 * 获取：下行数据包
	 */
	public Long getWrittenMessages() {
		return writtenMessages;
	}
}
