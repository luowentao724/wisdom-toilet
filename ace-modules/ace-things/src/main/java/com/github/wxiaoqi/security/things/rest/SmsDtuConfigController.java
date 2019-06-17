package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.SmsDtuConfigBiz;
import com.github.wxiaoqi.security.things.entity.SmsDtuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("smsDtuConfig")
public class SmsDtuConfigController extends BaseController<SmsDtuConfigBiz,SmsDtuConfig> {


    @Autowired
    SmsDtuConfigBiz smsDtuConfigBiz;

    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<SmsDtuConfig>> getList(@RequestParam Long dtuId){
        ObjectRestResponse<List<SmsDtuConfig>> entityObjectRestResponse = new ObjectRestResponse<>();
        List<SmsDtuConfig> result = smsDtuConfigBiz.getList(dtuId);
        entityObjectRestResponse.data(result);
        return entityObjectRestResponse;
    }



}