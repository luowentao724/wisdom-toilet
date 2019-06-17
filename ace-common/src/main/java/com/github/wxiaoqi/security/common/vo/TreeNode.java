package com.github.wxiaoqi.security.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ace on 2017/6/12.
 */
public class TreeNode {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentId;

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    List<TreeNode> children = new ArrayList<TreeNode>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void add(TreeNode node){
        children.add(node);
    }
}
