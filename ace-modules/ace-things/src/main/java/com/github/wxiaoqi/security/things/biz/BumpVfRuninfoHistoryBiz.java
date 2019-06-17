package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.BumpVfRuninfoHistory;
import com.github.wxiaoqi.security.things.mapper.BumpVfRuninfoHistoryMapper;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 变频器历史数据信息表
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-22 09:26:29
 */
@Service
public class BumpVfRuninfoHistoryBiz extends BaseBiz<BumpVfRuninfoHistoryMapper,BumpVfRuninfoHistory> {


    /**
     * 获取变频器历史数据
     * @return
     */
    public TableResultResponse<BumpVfRuninfoHistory> getHistoryData(Map<String , Object> params) {
        Query query = new Query(params);
        Example example = new Example(BumpVfRuninfoHistory.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                //按时间日期查询变频器历史数据
                if ("gatherTime".equals(entry.getKey())) {
                    criteria.andCondition("DATE_FORMAT(gather_time,'%Y-%m-%d') =", entry.getValue().toString());
                } else {
                    criteria.andEqualTo(entry.getKey(), entry.getValue());
                }
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<BumpVfRuninfoHistory> list = mapper.selectByExample(example);
        return new TableResultResponse<>(result.getTotal(), list);
    }

    /**
     * 获取变频器历史曲线数据
     * @return
     */
    public Map<String,Object> getHistoryCurveData(Map<String , Object> params) {
        Map<String,Object> result = new HashMap<>();
        List<BumpVfRuninfoHistory> bumpVfRuninfoList = mapper.searchBumpVfRuninfoHistoryCurve(params);
        // 时间节点
        List<String> timeList = new ArrayList<>();
        // 母线电压
        List<BigDecimal> busVoltageList = new ArrayList<>();
        // 输出电压
        List<BigDecimal> outputVoltageList = new ArrayList<>();
        // 输出电流
        List<BigDecimal> outputElectricList = new ArrayList<>();
        // 逆变器温度
        List<BigDecimal> vfTemperatureList = new ArrayList<>();
        // 整流器温度
        List<BigDecimal> vfHumidityList = new ArrayList<>();
        // 输出功率
        List<BigDecimal> outputPowerList = new ArrayList<>();
        for (BumpVfRuninfoHistory bumpVfRuninfoHistory : bumpVfRuninfoList ){
            timeList.add(new DateTime(bumpVfRuninfoHistory.getGatherTime()).toString("HH:mm:ss"));
            busVoltageList.add(bumpVfRuninfoHistory.getBusVoltage());
            outputVoltageList.add(bumpVfRuninfoHistory.getOutputVoltage());
            outputElectricList.add(bumpVfRuninfoHistory.getOutputElectric());
            vfTemperatureList.add(bumpVfRuninfoHistory.getVfTemperature());
            vfHumidityList.add(bumpVfRuninfoHistory.getVfHumidity());
            outputPowerList.add(bumpVfRuninfoHistory.getOutputPower());
        }
        result.put("timeList",timeList);
        result.put("busVoltageList",busVoltageList);
        result.put("outputVoltageList",outputVoltageList);
        result.put("outputElectricList",outputElectricList);
        result.put("vfTemperatureList",vfTemperatureList);
        result.put("vfHumidityList",vfHumidityList);
        result.put("outputPowerList",outputPowerList);
        return result;
    }

}