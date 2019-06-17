package com.github.wxiaoqi.security.things.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.common.util.TreeUtil;
import com.github.wxiaoqi.security.things.biz.AreaBiz;
import com.github.wxiaoqi.security.things.constant.ThingsCommonConstant;
import com.github.wxiaoqi.security.things.entity.Area;
import com.github.wxiaoqi.security.things.vo.AreaTree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("area")
public class AreaController extends BaseController<AreaBiz,Area> {

    @Autowired
    AreaBiz areaBiz;

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    @ResponseBody
    public List<AreaTree> getTree(String areaName) {
        Example example = new Example(Area.class);
        if (StringUtils.isNotBlank(areaName)) {
            example.createCriteria().andLike("areaName", "%" + areaName + "%");
        }
        return getAreaTree(baseBiz.selectByExample(example), ThingsCommonConstant.AREAROOT);
    }

    private List<AreaTree> getAreaTree(List<Area> areas, Long root) {
        List<AreaTree> trees = new ArrayList<AreaTree>();
        AreaTree node = null;
        for (Area area : areas) {
            node = new AreaTree();
            BeanUtils.copyProperties(area, node);
            node.setAreaName(area.getAreaName());
            node.setAreaType(area.getAreaType());
            trees.add(node);
        }
        return TreeUtil.bulid(trees,root) ;
    }

    /**
     * 批量删除area数据方法
     * @param id
     */
    @RequestMapping(value = "/removeArea/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse<Area> removeArea(@PathVariable String id){
        areaBiz.delete(id);
        return new ObjectRestResponse<Area>();
    }

}