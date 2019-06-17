package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.JobTypeInfoBiz;
import com.github.wxiaoqi.security.things.entity.JobTypeInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jobTypeInfo")
public class JobTypeInfoController extends BaseController<JobTypeInfoBiz,JobTypeInfo> {

}