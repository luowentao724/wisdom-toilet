package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.CustomerBiz;
import com.github.wxiaoqi.security.things.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController<CustomerBiz,Customer> {

}