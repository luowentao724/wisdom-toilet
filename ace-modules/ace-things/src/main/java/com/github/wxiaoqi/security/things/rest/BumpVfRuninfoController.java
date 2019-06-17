package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.BumpVfRuninfoBiz;
import com.github.wxiaoqi.security.things.entity.BumpVfRuninfo;
import com.github.wxiaoqi.security.things.entity.Stations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("bumpVfRuninfo")
public class BumpVfRuninfoController extends BaseController<BumpVfRuninfoBiz,BumpVfRuninfo> {




}