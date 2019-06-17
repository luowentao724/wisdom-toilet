package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.biz.StationsBiz;
import com.github.wxiaoqi.security.things.entity.RealDataInfo;
import com.github.wxiaoqi.security.things.entity.Stations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("stations")
public class StationsController extends BaseController<StationsBiz,Stations> {

    @Autowired
    StationsBiz stationsBiz;


    /**
     * 分页查询子站列表
     * @param params
     * @return
     */
    @Override
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<Stations> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return stationsBiz.selectByQuery(query);
    }

    @Override
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse<Stations> remove(@PathVariable Long id){
        stationsBiz.deleteById(id);
        return new ObjectRestResponse<Stations>();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Stations> add(@RequestBody Stations entity){
        stationsBiz.addStations(entity);
        return new ObjectRestResponse<Stations>();
    }

    /**
     * 资产分析报表
     * @return
     */
    @RequestMapping(value = "/getAssetsReport", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAssetsReport() {
        Map<String, Object> totilWashYearMonth = stationsBiz.getAssetsReport();
        return totilWashYearMonth;
    }

    /**
     * 带分页的设备状态监控列表查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/statusMonitorPage",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<Stations> statusMonitorPage(@RequestParam Map<String, Object> params){
        //查询列表数据
        TableResultResponse<Stations> resultResponse = stationsBiz.statusMonitorPage(params);
        return resultResponse;
    }


    /**
     * 获取数据监控页面数据
     * @return
     */
    @RequestMapping(value = "/getDataMonitor", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDataMonitor(@RequestParam Map<String, Object> params) {
        Map<String, Object> dataMonitor = stationsBiz.getDataMonitor(params);
        return dataMonitor;
    }

    /**
     * 获取泵站实时真空度实时数据
     * @return
     */
    @RequestMapping(value = "/getPumpStationVacuum", method = RequestMethod.GET)
    @ResponseBody
    public RealDataInfo getPumpStationVacuum(@RequestParam Long dtuId,@RequestParam String realtimeDataType ) {
        RealDataInfo realDataInfo = stationsBiz.getPumpStationVacuum(dtuId,realtimeDataType);
        return realDataInfo;
    }


}