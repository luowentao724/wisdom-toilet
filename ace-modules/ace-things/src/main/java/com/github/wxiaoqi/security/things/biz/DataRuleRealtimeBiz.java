package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.DataRuleRealtime;
import com.github.wxiaoqi.security.things.entity.RealDataInfo;
import com.github.wxiaoqi.security.things.entity.Stations;
import com.github.wxiaoqi.security.things.entity.SystemDict;
import com.github.wxiaoqi.security.things.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * 数据规则实时数据
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-29 15:41:05
 */
@Service
public class DataRuleRealtimeBiz extends BaseBiz<DataRuleRealtimeMapper,DataRuleRealtime> {

    @Autowired
    StationsMapper stationsMapper;

    @Autowired
    DataRuleRealtimeMapper dataRuleRealtimeMapper;

    @Autowired
    DataRuleReadMapper dataRuleReadMapper;

    @Autowired
    RealDataInfoMapper realDataInfoMapper;

    @Autowired
    SystemDictMapper systemDictMapper;




    /**
     * 分页查找数据规则实时数据
     * @param query
     * @return
     */
    public TableResultResponse<DataRuleRealtime> searchByQuery(Query query) {
        Example example = new Example(DataRuleRealtime.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if(StringUtils.isNotBlank(entry.getValue().toString())){
                    criteria.andEqualTo(entry.getKey(),  entry.getValue());
                }
            }
        }
        example.orderBy("dataOrderby").desc();
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<DataRuleRealtime> list = mapper.selectByExample(example);
        return new TableResultResponse<>(result.getTotal(), list);
    }

    /**
     * 根据id 删除多个数据规则
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional
    public ObjectRestResponse<DataRuleRealtime> deleteByIds(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRuleRealtime> result = new ObjectRestResponse<>();
        if(ids == null || ids.size() == 0){
            result.setStatus(500);
            result.setMessage("请选择删除项!");
            return result;
        }
        for (Long DataRuleRealtimeId : ids){
            mapper.deleteByPrimaryKey(DataRuleRealtimeId);
        }
        return result;
    }


    /**
     * 数据规则实时数据向上移动
     * @return
     * @throws Exception
     */
    @Transactional
    public ObjectRestResponse<DataRuleRealtime> handleUpMove(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRuleRealtime> result = new ObjectRestResponse();
        for (Long dataRuleRealtimeId : ids){
            DataRuleRealtime dataRuleRealtime = mapper.selectByPrimaryKey(dataRuleRealtimeId);
            Long dataOrderby = dataRuleRealtime.getDataOrderby();
            DataRuleRealtime upDataRuleRealtime = mapper.selectUpMove(dataRuleRealtime.getDataRuleId(),dataRuleRealtime.getDataOrderby());
            if(upDataRuleRealtime == null){
                result.setStatus(500);
                result.setMessage("已经是第一条数据,无法继续向上移动");
                return result;
            }
            dataRuleRealtime.setDataOrderby(upDataRuleRealtime.getDataOrderby());
            upDataRuleRealtime.setDataOrderby(dataOrderby);
            mapper.updateByPrimaryKeySelective(dataRuleRealtime);
            mapper.updateByPrimaryKeySelective(upDataRuleRealtime);
        }
        return result;
    }

    /**
     * 数据规则实时数据向下移动
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional
    public ObjectRestResponse<DataRuleRealtime> handleDownMove(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRuleRealtime> result = new ObjectRestResponse();
        for (Long dataRuleRealtimeId : ids){
            DataRuleRealtime dataRuleRealtime = mapper.selectByPrimaryKey(dataRuleRealtimeId);
            Long dataOrderby = dataRuleRealtime.getDataOrderby();
            DataRuleRealtime upDataRuleRealtime = mapper.selectDownMove(dataRuleRealtime.getDataRuleId(),dataRuleRealtime.getDataOrderby());
            if(upDataRuleRealtime == null){
                result.setStatus(500);
                result.setMessage("已经是最后一条数据,无法继续向下移动");
                return result;
            }
            dataRuleRealtime.setDataOrderby(upDataRuleRealtime.getDataOrderby());
            upDataRuleRealtime.setDataOrderby(dataOrderby);
            mapper.updateByPrimaryKeySelective(dataRuleRealtime);
            mapper.updateByPrimaryKeySelective(upDataRuleRealtime);
        }
        return result;
    }


    /**
     * 根据子站id查询实时数据
     * @param dtuId
     * @return
     */
    public ObjectRestResponse<List<DataRuleRealtime>> queryDtuIdDataRuleRealtime(@RequestParam Long dtuId){
       // 查询当前子站信息,获取数据规则id
        Stations stations = stationsMapper.selectByPrimaryKey(dtuId);

        //根据数据规则id 查询实时数据list
        DataRuleRealtime dataRuleRealtime = new DataRuleRealtime();
        dataRuleRealtime.setDataRuleId(stations.getDataRuleId());
        List<DataRuleRealtime> dataRuleRealtimeList = dataRuleRealtimeMapper.select(dataRuleRealtime);

        for (DataRuleRealtime data : dataRuleRealtimeList){
            SystemDict systemDict = systemDictMapper.selectByPrimaryKey(data.getSystemDictId());
            RealDataInfo dataInfo = new RealDataInfo();
            dataInfo.setDtuId(dtuId);
            dataInfo.setRealtimeDataType(systemDict.getDictId());
            RealDataInfo realDataInfo = realDataInfoMapper.selectOne(dataInfo);
            data.setRealDataInfo(realDataInfo);
        }
        ObjectRestResponse<List<DataRuleRealtime>> result = new ObjectRestResponse<>();
        result.setData(dataRuleRealtimeList);
        return result;
    }


}