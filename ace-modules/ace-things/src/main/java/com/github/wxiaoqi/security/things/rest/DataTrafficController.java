package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.DataTrafficBiz;
import com.github.wxiaoqi.security.things.entity.DataTraffic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("dataTraffic")
public class DataTrafficController extends BaseController<DataTrafficBiz,DataTraffic> {

    @Autowired
    DataTrafficBiz dataTrafficBiz;

    /**
     * 带分页的流量信息列表查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/trafficPage",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<DataTraffic> trafficPage(@RequestParam Map<String, Object> params){
        //查询列表数据
        TableResultResponse<DataTraffic> resultResponse = dataTrafficBiz.selectPage(params);
        return resultResponse;
    }

}