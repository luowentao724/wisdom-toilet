package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.DtuConfigInfoBiz;
import com.github.wxiaoqi.security.things.entity.DtuConfigInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dtuConfigInfo")
public class DtuConfigInfoController extends BaseController<DtuConfigInfoBiz,DtuConfigInfo> {

}