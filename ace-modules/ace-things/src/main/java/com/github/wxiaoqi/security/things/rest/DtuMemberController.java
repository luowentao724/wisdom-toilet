package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.DtuMemberBiz;
import com.github.wxiaoqi.security.things.entity.DtuMember;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dtuMember")
public class DtuMemberController extends BaseController<DtuMemberBiz,DtuMember> {

}