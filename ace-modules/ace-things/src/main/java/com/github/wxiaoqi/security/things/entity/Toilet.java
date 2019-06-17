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
 * @date 2019-05-19 20:11:33
 */
@Table(name = "toilet")
public class Toilet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //便器冲洗次数
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //子站id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "dtu_id")
    private Long dtuId;
	
	    //总冲洗次数
    @Column(name = "total_num")
    private Integer totalNum;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	

	/**
	 * 设置：便器冲洗次数
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：便器冲洗次数
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
	 * 设置：总冲洗次数
	 */
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	/**
	 * 获取：总冲洗次数
	 */
	public Integer getTotalNum() {
		return totalNum;
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
