package com.github.wxiaoqi.security.things.vo;

import com.github.wxiaoqi.security.common.vo.TreeNode;

/**
 * Created by Ace on 2017/6/12.
 * 区域地址Tree实体类
 */
public class AreaTree extends TreeNode {

    String areaName; // 区域地址名称
    Integer areaType; // 区域地址类型包括国家、省级、市、县、镇5个级别，分别用10，11，12，13，14来表示
    String remark; // 备注

    public AreaTree() {
    }

//    public AreaTree(Long id, String areaName, Long parentId,Integer areaType,String remark) {
//        this.id = id;
//        this.parentId = parentId;
//        this.areaName = areaName;
//        this.areaType = areaType;
//        this.remark = remark;
//    }

//    public AreaTree(Long id, String areaName, AreaTree parent) {
//        this.id = id;
//        this.parentId = parent.getId();
//        this.areaName = areaName;
//    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
