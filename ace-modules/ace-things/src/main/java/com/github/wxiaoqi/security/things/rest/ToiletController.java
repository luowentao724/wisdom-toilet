package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.ToiletBiz;
import com.github.wxiaoqi.security.things.entity.Toilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("toilet")
public class ToiletController extends BaseController<ToiletBiz,Toilet> {

    @Autowired
    ToiletBiz toiletBiz;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Toilet> list(@RequestParam Long dtuId){
        //查询列表数据
        Toilet toilet = new Toilet();
        toilet.setDtuId(dtuId);
        return toiletBiz.selectList(toilet);
    }

    /**
     * 批量更新便器总冲洗次数
     * @param toiletList
     * @return
     */
    @RequestMapping(value = "/updateList", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Toilet> updateList(@RequestBody List<Toilet> toiletList) {
        return toiletBiz.updateList(toiletList);
    }

}