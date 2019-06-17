package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.TotilWashInfoBiz;
import com.github.wxiaoqi.security.things.entity.TotilWashInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("totilWashInfo")
public class TotilWashInfoController extends BaseController<TotilWashInfoBiz,TotilWashInfo> {

    @Autowired
    TotilWashInfoBiz totilWashInfoBiz;

    /**
     * 数据报表,查询子站便器每日冲洗数据
     * @return
     */
    @RequestMapping(value = "/getStationsTotilWashDay", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getStationsTotilWashDay(@RequestParam Map<String,Object> params) {
        Map<String, Object> totilWashYearMonth = totilWashInfoBiz.getStationsTotilWashDay(params);
        return totilWashYearMonth;
    }


    /**
     * 能耗分析报表,查询当月每日数据
     * @return
     */
    @RequestMapping(value = "/getTotilWashYearMonthDay", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTotilWashYearMonthDay(@RequestParam Map<String,Object> params) {
        Map<String, Object> totilWashYearMonth = totilWashInfoBiz.getTotilWashYearMonthDay(params);
        return totilWashYearMonth;
    }

    /**
     * 子站冲洗次数监控数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/dtuWashMonitorData",method = RequestMethod.GET)
    @ResponseBody
    public List<TotilWashInfo> dtuWashMonitorData(@RequestParam Map<String, Object> params){
        //查询列表数据
        List<TotilWashInfo> resultResponse = totilWashInfoBiz.dtuWashMonitorData(params);
        return resultResponse;
    }


}