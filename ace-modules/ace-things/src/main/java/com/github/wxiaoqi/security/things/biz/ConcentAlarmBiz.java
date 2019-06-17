package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.ConcentAlarm;
import com.github.wxiaoqi.security.things.entity.Stations;
import com.github.wxiaoqi.security.things.mapper.ConcentAlarmMapper;
import com.github.wxiaoqi.security.things.mapper.StationsMapper;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报警信息表
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-09 21:39:13
 */
@Service
public class ConcentAlarmBiz extends BaseBiz<ConcentAlarmMapper,ConcentAlarm> {

    @Autowired
    StationsMapper stationsMapper;

    /**
     * 故障分析报表,查询当年每月数据
     * @return
     */
    public Map<String,Object> getAlarmYearMonth (Map<String, Object> params){
        List<TotilWashYearMonthVo> totilList =  mapper.getAlarmYearMonth(params);
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
     * 条件查询报警信息
     * @param params
     * @return
     */
    public TableResultResponse<ConcentAlarm> selectPage(Map<String, Object> params) {
        Query query = new Query(params);
        Example example = new Example(ConcentAlarm.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                //按时间单位年查询 报警信息
                if("dateYear".equals(entry.getKey())){
                    criteria.andCondition("DATE_FORMAT(alarm_time, '%Y') =",entry.getValue().toString());
                }else{
                    criteria.andEqualTo(entry.getKey(),entry.getValue());
                }
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<ConcentAlarm> list = mapper.selectByExample(example);
        // 设置 dtu 名称和dtu标识码
        for(ConcentAlarm concentAlarm : list){
            Stations stations = stationsMapper.selectByPrimaryKey(concentAlarm.getDtuId());
            if(stations != null){
                concentAlarm.setTotilName(stations.getTotilName());
                concentAlarm.setTotilId(stations.getTotilId());
            }
        }
        return new TableResultResponse<>(result.getTotal(), list);
    }

    /**
     * 分页查收查询设备报警信息
     * @return
     */
    public TableResultResponse<ConcentAlarm> searchPage(Map<String, Object> params){
        Query query = new Query(params);
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<ConcentAlarm> list =  mapper.searchPage(params);
        return new TableResultResponse<>(result.getTotal(), list);
    }


}