package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.RealDataInfoHistoryBiz;
import com.github.wxiaoqi.security.things.entity.RealDataInfoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("realDataInfoHistory")
public class RealDataInfoHistoryController extends BaseController<RealDataInfoHistoryBiz,RealDataInfoHistory> {

    @Autowired
    RealDataInfoHistoryBiz realDataInfoHistoryBiz;

    /**
     * 数据报表,查询子站泵器真空度等数据
     * @param params
     * @return
     */
    @RequestMapping(value = "getStationsRealDataInfo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getStationsRealDataInfo(@RequestParam Map<String,Object> params){
       return realDataInfoHistoryBiz.getStationsRealDataInfo(params);
    }

}