package com.github.wxiaoqi.security.things.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.things.entity.TotilWashInfo;
import com.github.wxiaoqi.security.things.mapper.ToiletMapper;
import com.github.wxiaoqi.security.things.mapper.TotilWashInfoMapper;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 子站（公厕）便器冲洗明细表
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-09 16:46:06
 */
@Service
public class TotilWashInfoBiz extends BaseBiz<TotilWashInfoMapper,TotilWashInfo> {

    /**
     * 便器mapper
     */
    @Autowired
    ToiletMapper toiletMapper;


    /**
     * 数据报表,查询子站便器每日冲洗数据
     * @return
     */
    public Map<String,Object> getStationsTotilWashDay (Map<String,Object> params){
        List<TotilWashYearMonthVo> totilList =  mapper.getStationsTotilWashDay(params);
        List<Long> totilIdList = new ArrayList<>();
        List<Integer> totilNumList = new ArrayList<>();
        for(TotilWashYearMonthVo totilWashYearMonthVo : totilList){
            totilIdList.add(totilWashYearMonthVo.getTotilId());
            totilNumList.add(totilWashYearMonthVo.getTotalNum());
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totilIdList",totilIdList);
        resultMap.put("totilNumList",totilNumList);
        return resultMap;
    }

    /**
     * 能耗分析报表,查询当月每日数据
     * @return
     */
    public Map<String,Object> getTotilWashYearMonthDay (Map<String,Object> params){
        List<TotilWashYearMonthVo> totilList =  mapper.getTotilWashYearMonthDay(params);
        List<Integer> dateList = new ArrayList<>();
        List<Integer> totilNumList = new ArrayList<>();
        for(TotilWashYearMonthVo totilWashYearMonthVo : totilList){
            dateList.add(totilWashYearMonthVo.getGatherTime());
            totilNumList.add(totilWashYearMonthVo.getTotalNum());
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("dateList",dateList);
        resultMap.put("totilNumList",totilNumList);
        return resultMap;
    }

    /**
     * 子站冲洗次数监控数据
     * @param params
     * @return
     */
    public List<TotilWashInfo> dtuWashMonitorData(Map<String, Object> params){
        List<TotilWashInfo> totilWashInfoList = mapper.searchWashData(params);
        return totilWashInfoList;
    }


}