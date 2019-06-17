package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.EntityUtils;
import com.github.wxiaoqi.security.common.util.IdWorker;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.DataRule;
import com.github.wxiaoqi.security.things.entity.DataRuleRead;
import com.github.wxiaoqi.security.things.entity.DataRuleRealtime;
import com.github.wxiaoqi.security.things.entity.Stations;
import com.github.wxiaoqi.security.things.mapper.DataRuleMapper;
import com.github.wxiaoqi.security.things.mapper.DataRuleReadMapper;
import com.github.wxiaoqi.security.things.mapper.DataRuleRealtimeMapper;
import com.github.wxiaoqi.security.things.mapper.StationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 数据规则
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-28 11:04:17
 */
@Service
public class DataRuleBiz extends BaseBiz<DataRuleMapper,DataRule> {

    @Autowired
    StationsMapper stationsMapper;

    @Autowired
    DataRuleRealtimeMapper dataRuleRealtimeMapper;

    @Autowired
    DataRuleReadMapper dataRuleReadMapper;


    public TableResultResponse<DataRule> selectByQuery(Query query) {
        Example example = new Example(DataRule.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        example.orderBy("createTime").desc();
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<DataRule> list = mapper.selectByExample(example);
        DataRuleRealtime dataRuleRealtime = new DataRuleRealtime();
        DataRuleRead dataRuleRead = new DataRuleRead();
        for(DataRule dataRule : list){
            dataRuleRead.setDataRuleId(dataRule.getId());
            dataRuleRealtime.setDataRuleId(dataRule.getId());
            dataRule.setDataRuleRealtimeList(dataRuleRealtimeMapper.select(dataRuleRealtime));
            dataRule.setDataRuleReadList(dataRuleReadMapper.select(dataRuleRead));
        }
        return new TableResultResponse<>(result.getTotal(), list);
    }
    
    /**
     * 新增数据规则
     * @param entity
     */
    public void insertSelectiveDataRule(DataRule entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insertSelective(entity);
    }

    /**
     * 根据id 删除多个数据规则
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional
    public ObjectRestResponse<DataRule> deleteByIds(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRule> result = new ObjectRestResponse<>();
        if(ids == null || ids.size() == 0){
            result.setStatus(500);
            result.setMessage("请选择删除项!");
            return result;
        }
        Stations stations = new Stations();
        for (Long dataRuleId : ids){
            //查找当前数据规则是否有关联子站
            stations.setDataRuleId(dataRuleId);
            Stations one = stationsMapper.selectOne(stations);
            if(one != null){
                result.setStatus(500);
                result.setMessage("已有子站绑定该数据规则,子站编号是:("+one.getTotilId()+")!");
                return result;
            }
            mapper.deleteByPrimaryKey(dataRuleId);
            // 删除实时数据
            DataRuleRealtime dataRuleRealtime = new DataRuleRealtime();
            dataRuleRealtime.setDataRuleId(dataRuleId);
            dataRuleRealtimeMapper.delete(dataRuleRealtime);

            // 删除读写数据
            DataRuleRead dataRuleRead = new DataRuleRead();
            dataRuleRead.setDataRuleId(dataRuleId);
            dataRuleReadMapper.delete(dataRuleRead);
        }
        return result;
    }

    /**
     * 根据id复制多个数据规则
     * @param ids
     * @return
     * @throws Exception
     */
    public ObjectRestResponse<DataRule> cloneDataRuleIds(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRule> result = new ObjectRestResponse<>();
        IdWorker idWorker = new IdWorker();
        for (Long dataRuleId : ids){
            long insertDataRuleId = idWorker.nextId();
            DataRule dataRule = mapper.selectByPrimaryKey(dataRuleId);
            dataRule.setId(insertDataRuleId);
            dataRule.setRuleName(dataRule.getRuleName()+"-副本");
            dataRule.setCreateTime(new Date());
            mapper.insertSelective(dataRule);

            // 查找实时数据
            DataRuleRealtime dataRuleRealtime = new DataRuleRealtime();
            dataRuleRealtime.setDataRuleId(dataRuleId);
            List<DataRuleRealtime> dataRuleRealtimeList = dataRuleRealtimeMapper.select(dataRuleRealtime);
            for(DataRuleRealtime insertDataRuleRealtime : dataRuleRealtimeList){
                long dataRuleRealtimeId = idWorker.nextId();
                insertDataRuleRealtime.setId(dataRuleRealtimeId);
                insertDataRuleRealtime.setDataRuleId(insertDataRuleId);
                insertDataRuleRealtime.setDataOrderby(dataRuleRealtimeId);
                insertDataRuleRealtime.setCreateTime(new Date());
                dataRuleRealtimeMapper.insertSelective(insertDataRuleRealtime);
            }
            // 查找读写数据
            DataRuleRead dataRuleRead = new DataRuleRead();
            dataRuleRead.setDataRuleId(dataRuleId);
            List<DataRuleRead> dataRuleReadList = dataRuleReadMapper.select(dataRuleRead);
            for(DataRuleRead insertDataRuleRead : dataRuleReadList){
                long dataRuleReadId = idWorker.nextId();
                insertDataRuleRead.setId(dataRuleReadId);
                insertDataRuleRead.setDataRuleId(insertDataRuleId);
                insertDataRuleRead.setDataOrderby(dataRuleReadId);
                insertDataRuleRead.setCreateTime(new Date());
                dataRuleReadMapper.insertSelective(insertDataRuleRead);
            }
        }
        return result;
    }


}