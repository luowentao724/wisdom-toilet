package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.RealDataInfoBiz;
import com.github.wxiaoqi.security.things.entity.RealDataInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("realDataInfo")
public class RealDataInfoController extends BaseController<RealDataInfoBiz,RealDataInfo> {

}