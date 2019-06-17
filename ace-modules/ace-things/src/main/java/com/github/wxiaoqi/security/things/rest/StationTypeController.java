package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.StationTypeBiz;
import com.github.wxiaoqi.security.things.entity.StationType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("stationType")
public class StationTypeController extends BaseController<StationTypeBiz,StationType> {

}