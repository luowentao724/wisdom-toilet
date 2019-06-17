package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.AttendanceBiz;
import com.github.wxiaoqi.security.things.entity.Attendance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("attendance")
public class AttendanceController extends BaseController<AttendanceBiz,Attendance> {

}