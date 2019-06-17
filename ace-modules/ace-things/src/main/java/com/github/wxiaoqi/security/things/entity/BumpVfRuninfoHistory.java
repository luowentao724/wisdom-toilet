package com.github.wxiaoqi.security.things.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 变频器历史数据信息表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-22 09:26:29
 */
@Table(name = "bump_vf_runinfo_history")
public class BumpVfRuninfoHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //变频器id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    private Long id;
	
	    //子站id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "dtu_id")
    private Long dtuId;
	
	    //vf变频的缩写
    @Column(name = "vf_device_code")
    private Integer vfDeviceCode;
	
	    //运行速度
    @Column(name = "run_speed")
    private String runSpeed;
	
	    //设定速度
    @Column(name = "setting_speed")
    private String settingSpeed;
	
	    //母线电压
    @Column(name = "bus_voltage")
    private BigDecimal busVoltage;
	
	    //输出电压
    @Column(name = "output_voltage")
    private BigDecimal outputVoltage;
	
	    //运行转速
    @Column(name = "run_rev")
    private BigDecimal runRev;
	
	    //输出功率
    @Column(name = "output_power")
    private BigDecimal outputPower;
	
	    //输出电流
    @Column(name = "output_electric")
    private BigDecimal outputElectric;
	
	    //输出转矩
    @Column(name = "output_torque")
    private BigDecimal outputTorque;
	
	    //逆变器温度
    @Column(name = "vf_temperature")
    private BigDecimal vfTemperature;
	
	    //整流器温度
    @Column(name = "vf_humidity")
    private BigDecimal vfHumidity;
	
	    //当天运行时间
    @Column(name = "today_runtime")
    private Integer todayRuntime;
	
	    //累积运行时间
    @Column(name = "accu_runtime")
    private Integer accuRuntime;
	
	    //采集时间
    @Column(name = "gather_time")
    private Date gatherTime;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	

	/**
	 * 设置：变频器id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：变频器id
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
	 * 设置：vf变频的缩写
	 */
	public void setVfDeviceCode(Integer vfDeviceCode) {
		this.vfDeviceCode = vfDeviceCode;
	}
	/**
	 * 获取：vf变频的缩写
	 */
	public Integer getVfDeviceCode() {
		return vfDeviceCode;
	}
	/**
	 * 设置：运行速度
	 */
	public void setRunSpeed(String runSpeed) {
		this.runSpeed = runSpeed;
	}
	/**
	 * 获取：运行速度
	 */
	public String getRunSpeed() {
		return runSpeed;
	}
	/**
	 * 设置：设定速度
	 */
	public void setSettingSpeed(String settingSpeed) {
		this.settingSpeed = settingSpeed;
	}
	/**
	 * 获取：设定速度
	 */
	public String getSettingSpeed() {
		return settingSpeed;
	}
	/**
	 * 设置：母线电压
	 */
	public void setBusVoltage(BigDecimal busVoltage) {
		this.busVoltage = busVoltage;
	}
	/**
	 * 获取：母线电压
	 */
	public BigDecimal getBusVoltage() {
		return busVoltage;
	}
	/**
	 * 设置：输出电压
	 */
	public void setOutputVoltage(BigDecimal outputVoltage) {
		this.outputVoltage = outputVoltage;
	}
	/**
	 * 获取：输出电压
	 */
	public BigDecimal getOutputVoltage() {
		return outputVoltage;
	}
	/**
	 * 设置：运行转速
	 */
	public void setRunRev(BigDecimal runRev) {
		this.runRev = runRev;
	}
	/**
	 * 获取：运行转速
	 */
	public BigDecimal getRunRev() {
		return runRev;
	}
	/**
	 * 设置：输出功率
	 */
	public void setOutputPower(BigDecimal outputPower) {
		this.outputPower = outputPower;
	}
	/**
	 * 获取：输出功率
	 */
	public BigDecimal getOutputPower() {
		return outputPower;
	}
	/**
	 * 设置：输出电流
	 */
	public void setOutputElectric(BigDecimal outputElectric) {
		this.outputElectric = outputElectric;
	}
	/**
	 * 获取：输出电流
	 */
	public BigDecimal getOutputElectric() {
		return outputElectric;
	}
	/**
	 * 设置：输出转矩
	 */
	public void setOutputTorque(BigDecimal outputTorque) {
		this.outputTorque = outputTorque;
	}
	/**
	 * 获取：输出转矩
	 */
	public BigDecimal getOutputTorque() {
		return outputTorque;
	}
	/**
	 * 设置：逆变器温度
	 */
	public void setVfTemperature(BigDecimal vfTemperature) {
		this.vfTemperature = vfTemperature;
	}
	/**
	 * 获取：逆变器温度
	 */
	public BigDecimal getVfTemperature() {
		return vfTemperature;
	}
	/**
	 * 设置：整流器温度
	 */
	public void setVfHumidity(BigDecimal vfHumidity) {
		this.vfHumidity = vfHumidity;
	}
	/**
	 * 获取：整流器温度
	 */
	public BigDecimal getVfHumidity() {
		return vfHumidity;
	}
	/**
	 * 设置：当天运行时间
	 */
	public void setTodayRuntime(Integer todayRuntime) {
		this.todayRuntime = todayRuntime;
	}
	/**
	 * 获取：当天运行时间
	 */
	public Integer getTodayRuntime() {
		return todayRuntime;
	}
	/**
	 * 设置：累积运行时间
	 */
	public void setAccuRuntime(Integer accuRuntime) {
		this.accuRuntime = accuRuntime;
	}
	/**
	 * 获取：累积运行时间
	 */
	public Integer getAccuRuntime() {
		return accuRuntime;
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
