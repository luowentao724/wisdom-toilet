package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.DeviceSnBiz;
import com.github.wxiaoqi.security.things.entity.DeviceSn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("deviceSn")
public class DeviceSnController extends BaseController<DeviceSnBiz,DeviceSn> {

    @Autowired
    DeviceSnBiz deviceSnBiz;

    @Override
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<DeviceSn> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        TableResultResponse<DeviceSn> resultResponse = deviceSnBiz.selectPage(params);
        return resultResponse;
    }

}