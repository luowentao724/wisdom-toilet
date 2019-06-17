package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.DataTraffic;
import com.github.wxiaoqi.security.things.entity.Stations;
import com.github.wxiaoqi.security.things.mapper.DataTrafficMapper;
import com.github.wxiaoqi.security.things.mapper.StationsMapper;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 流量数据明细表
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-13 15:13:48
 */
@Service
public class DataTrafficBiz extends BaseBiz<DataTrafficMapper,DataTraffic> {

    @Autowired
    StationsMapper stationsMapper;

    /**
     * 条件查询流量信息
     * @param params
     * @return
     */
    public TableResultResponse<DataTraffic> selectPage(Map<String, Object> params) {
        Query query = new Query(params);
        Example example = new Example(DataTraffic.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                //按时间单位年查询 报警信息
                if("openTime".equals(entry.getKey())){
                    criteria.andCondition("DATE_FORMAT(open_time, '%Y-%m') =",entry.getValue().toString());
                }
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<DataTraffic> list = mapper.selectByExample(example);
        for (DataTraffic dataTraffic : list){
            Stations s = stationsMapper.selectByPrimaryKey(dataTraffic.getDtuId());
            dataTraffic.setTotilName(s.getTotilName());
            dataTraffic.setTotilId(s.getTotilId());
            dataTraffic.setSimCard(s.getSim());
            // 设置本月在线时长
            DateTime openTime = new DateTime(dataTraffic.getOpenTime());
            DateTime closeTime = new DateTime(dataTraffic.getCloseTime());
            //计算两个日期间隔的小时数
            LocalDateTime start=new LocalDateTime(openTime);
            LocalDateTime end=new LocalDateTime(closeTime);
            Period p = new Period(start,end,PeriodType.hours());
            dataTraffic.setOnlineTimeMonth(new BigDecimal(p.getHours()));
            //设置本月累积流量
            BigDecimal readBytes = new BigDecimal(dataTraffic.getReadBytes());
            BigDecimal writtenBytes = new BigDecimal(dataTraffic.getWrittenBytes());
            dataTraffic.setCumulativeTrafficMonth(readBytes.add(writtenBytes));
        }
        return new TableResultResponse<>(result.getTotal(), list);
    }

}