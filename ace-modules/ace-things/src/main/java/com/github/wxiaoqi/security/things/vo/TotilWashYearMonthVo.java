package com.github.wxiaoqi.security.things.vo;

import java.util.Objects;

/**
 * 能耗分析报表 ,数据接收实体类
 */
public class TotilWashYearMonthVo{

    Integer gatherTime; // 统计时间
    Integer totalNum; // 冲洗次数
    Long totilId; // 便器id
    Long customerId; //客户id
    String customerName;// 客户名称
    String systemName; // 客户平台名称
    Long totilNums; // 便器数量
    Long bumpNums; // 泵器数量
    Long nums; // 子站数量

    String timeMinute; // 统计时间时:分
    Integer num;// 公用字段

    public String getTimeMinute() {
        return timeMinute;
    }

    public void setTimeMinute(String timeMinute) {
        this.timeMinute = timeMinute;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public TotilWashYearMonthVo() {
    }

    public Long getTotilId() {
        return totilId;
    }

    public void setTotilId(Long totilId) {
        this.totilId = totilId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Long getTotilNums() {
        return totilNums;
    }

    public void setTotilNums(Long totilNums) {
        this.totilNums = totilNums;
    }

    public Long getBumpNums() {
        return bumpNums;
    }

    public void setBumpNums(Long bumpNums) {
        this.bumpNums = bumpNums;
    }

    public Long getNums() {
        return nums;
    }

    public void setNums(Long nums) {
        this.nums = nums;
    }

    public Integer getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Integer gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotilWashYearMonthVo that = (TotilWashYearMonthVo) o;
        return Objects.equals(gatherTime, that.gatherTime) &&
                Objects.equals(totalNum, that.totalNum) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(systemName, that.systemName) &&
                Objects.equals(totilNums, that.totilNums) &&
                Objects.equals(bumpNums, that.bumpNums) &&
                Objects.equals(nums, that.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gatherTime, totalNum, customerId, customerName, systemName, totilNums, bumpNums, nums);
    }

    @Override
    public String toString() {
        return "TotilWashYearMonthVo{" +
                "gatherTime='" + gatherTime + '\'' +
                ", totalNum=" + totalNum +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", systemName='" + systemName + '\'' +
                ", totilNums=" + totilNums +
                ", bumpNums=" + bumpNums +
                ", nums=" + nums +
                '}';
    }
}
