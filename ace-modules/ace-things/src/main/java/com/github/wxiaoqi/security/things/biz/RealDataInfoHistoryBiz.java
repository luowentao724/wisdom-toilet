package com.github.wxiaoqi.security.things.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.things.entity.RealDataInfoHistory;
import com.github.wxiaoqi.security.things.mapper.RealDataInfoHistoryMapper;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-19 09:33:00
 */
@Service
public class RealDataInfoHistoryBiz extends BaseBiz<RealDataInfoHistoryMapper,RealDataInfoHistory> {

    /**
     * 数据报表,查询子站泵器真空度等数据
     * @param params
     * @return
     */
    public Map<String,Object> getStationsRealDataInfo(Map<String,Object> params){
        List<TotilWashYearMonthVo> totilList =  mapper.getStationsRealDataInfo(params);
        List<String> dateList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for(TotilWashYearMonthVo totilWashYearMonthVo : totilList){
            dateList.add(totilWashYearMonthVo.getTimeMinute());
            numList.add(totilWashYearMonthVo.getNum());
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("dateList",dateList);
        resultMap.put("numList",numList);
        return resultMap;
    }
}