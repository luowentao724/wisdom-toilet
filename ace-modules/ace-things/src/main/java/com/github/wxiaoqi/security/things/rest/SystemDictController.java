package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.SystemDictBiz;
import com.github.wxiaoqi.security.things.entity.SystemDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("systemDict")
public class SystemDictController extends BaseController<SystemDictBiz,SystemDict> {

    @Autowired
    SystemDictBiz systemDictBiz;

    /**
     * 获取数据字典dictName
     * @param typeName
     * @return
     */
    @RequestMapping(value = "/getSystemDictType",method = RequestMethod.GET)
    @ResponseBody
    public List<SystemDict> getSystemDictType(String typeName) {
        return systemDictBiz.getDDDescriptionType(typeName);
    }

}