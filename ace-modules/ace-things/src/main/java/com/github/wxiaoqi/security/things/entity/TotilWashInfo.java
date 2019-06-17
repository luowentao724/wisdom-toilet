package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * 子站（公厕）便器冲洗明细表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-09 16:46:06
 */
@Table(name = "totil_wash_info")
public class TotilWashInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //子站(公厕)id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;

	//子站id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "dtu_id")
	private Long dtuId;
	
	    //便器编号
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "totil_id")
    private Long totilId;

	    //当日冲洗次数
    @Column(name = "today_wash_times")
    private Integer todayWashTimes;
	
	    //累积冲洗次数
    @Column(name = "accumulate_times")
    private Integer accumulateTimes;
	
	    //今日之前冲洗次数
    @Column(name = "yesterday_cash_times")
    private Integer yesterdayCashTimes;
	
	    //采集时间
    @Column(name = "gather_time")
    private Date gatherTime;
	
	    //数据日期
    @Column(name = "create_time")
    private Date createTime;

    //总冲洗次数
    @Transient
    private Integer totalNum;

	//剩余冲洗次数
	@Transient
	private Integer lastNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	/**
	 * 设置：子站(公厕)id
	 */
	public void setDtuId(Long dtuId) {
		this.dtuId = dtuId;
	}
	/**
	 * 获取：子站(公厕)id
	 */
	public Long getDtuId() {
		return dtuId;
	}
	/**
	 * 设置：便器编号
	 */
	public void setTotilId(Long totilId) {
		this.totilId = totilId;
	}
	/**
	 * 获取：便器编号
	 */
	public Long getTotilId() {
		return totilId;
	}
	/**
	 * 设置：当日冲洗次数
	 */
	public void setTodayWashTimes(Integer todayWashTimes) {
		this.todayWashTimes = todayWashTimes;
	}
	/**
	 * 获取：当日冲洗次数
	 */
	public Integer getTodayWashTimes() {
		return todayWashTimes;
	}
	/**
	 * 设置：累积冲洗次数
	 */
	public void setAccumulateTimes(Integer accumulateTimes) {
		this.accumulateTimes = accumulateTimes;
	}
	/**
	 * 获取：累积冲洗次数
	 */
	public Integer getAccumulateTimes() {
		return accumulateTimes;
	}
	/**
	 * 设置：今日之前冲洗次数
	 */
	public void setYesterdayCashTimes(Integer yesterdayCashTimes) {
		this.yesterdayCashTimes = yesterdayCashTimes;
	}
	/**
	 * 获取：今日之前冲洗次数
	 */
	public Integer getYesterdayCashTimes() {
		return yesterdayCashTimes;
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
	 * 设置：数据日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：数据日期
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
