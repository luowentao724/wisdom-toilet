package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.things.biz.PumpStationDataBiz;
import com.github.wxiaoqi.security.things.entity.PumpStationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("pumpStationData")
public class PumpStationDataController extends BaseController<PumpStationDataBiz,PumpStationData> {

    @Autowired
    PumpStationDataBiz pumpStationDataBiz;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<PumpStationData> list(@RequestParam Long dtuId){
        //查询列表数据
        PumpStationData pumpStationData = new PumpStationData();
        pumpStationData.setDtuId(dtuId);
        return pumpStationDataBiz.selectList(pumpStationData);
    }

    @RequestMapping(value = "/updateList", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<PumpStationData> updateList(@RequestBody List<PumpStationData> pumpStationDataList) {
        return pumpStationDataBiz.updateList(pumpStationDataList);
    }

}