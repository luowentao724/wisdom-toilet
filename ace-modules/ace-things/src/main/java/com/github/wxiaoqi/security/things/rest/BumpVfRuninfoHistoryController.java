package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.BumpVfRuninfoHistoryBiz;
import com.github.wxiaoqi.security.things.entity.BumpVfRuninfoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("bumpVfRuninfoHistory")
public class BumpVfRuninfoHistoryController extends BaseController<BumpVfRuninfoHistoryBiz,BumpVfRuninfoHistory> {

    @Autowired
    BumpVfRuninfoHistoryBiz bumpVfRuninfoHistoryBiz;

    /**
     * 获取变频器历史数据
     * @return
     */
    @RequestMapping(value = "/getHistoryData", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<BumpVfRuninfoHistory> getHistoryData(@RequestParam Map<String , Object> params) {
        TableResultResponse<BumpVfRuninfoHistory> result = bumpVfRuninfoHistoryBiz.getHistoryData(params);
        return result;
    }

    /**
     * 获取变频器历史曲线数据
     * @return
     */
    @RequestMapping(value = "/getHistoryCurveData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getHistoryCurveData(@RequestParam Map<String , Object> params) {
        Map<String,Object> result = bumpVfRuninfoHistoryBiz.getHistoryCurveData(params);
        return result;
    }


}