package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.DeviceSn;
import com.github.wxiaoqi.security.things.entity.Stations;
import com.github.wxiaoqi.security.things.mapper.DeviceSnMapper;
import com.github.wxiaoqi.security.things.mapper.StationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * sn码表
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-05 17:46:04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceSnBiz extends BaseBiz<DeviceSnMapper,DeviceSn> {

    @Autowired
    private DeviceSnMapper deviceSnMapper;

    @Autowired
    private StationsMapper stationsMapper;

    public TableResultResponse<DeviceSn> selectPage(Map<String, Object> params) {
        Query query = new Query(params);
        Example example = new Example(DeviceSn.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<DeviceSn> list = deviceSnMapper.selectByExample(example);
        for(DeviceSn deviceSn : list){
            Stations stations = stationsMapper.selectByPrimaryKey(new Long(deviceSn.getStation()));
            deviceSn.setStationName(stations.getTotilName());
        }
        return new TableResultResponse<>(result.getTotal(), list);
    }



}