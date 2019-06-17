package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.DataRuleRead;
import com.github.wxiaoqi.security.things.entity.RealDataInfo;
import com.github.wxiaoqi.security.things.entity.Stations;
import com.github.wxiaoqi.security.things.entity.SystemDict;
import com.github.wxiaoqi.security.things.mapper.DataRuleReadMapper;
import com.github.wxiaoqi.security.things.mapper.RealDataInfoMapper;
import com.github.wxiaoqi.security.things.mapper.StationsMapper;
import com.github.wxiaoqi.security.things.mapper.SystemDictMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * 数据规则读写数据
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-29 15:41:05
 */
@Service
public class DataRuleReadBiz extends BaseBiz<DataRuleReadMapper,DataRuleRead> {

    @Autowired
    StationsMapper stationsMapper;

    @Autowired
    SystemDictMapper systemDictMapper;

    @Autowired
    RealDataInfoMapper realDataInfoMapper;



    /**
     * 分页查找数据规则读写数据
     * @param query
     * @return
     */
    public TableResultResponse<DataRuleRead> searchByQuery(Query query) {
        Example example = new Example(DataRuleRead.class);
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
        List<DataRuleRead> list = mapper.selectByExample(example);
        return new TableResultResponse<>(result.getTotal(), list);
    }

    /**
     * 根据id 删除多个数据规则
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional
    public ObjectRestResponse<DataRuleRead> deleteByIds(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRuleRead> result = new ObjectRestResponse<>();
        if(ids == null || ids.size() == 0){
            result.setStatus(500);
            result.setMessage("请选择删除项!");
            return result;
        }
        for (Long DataRuleReadId : ids){
            mapper.deleteByPrimaryKey(DataRuleReadId);
        }
        return result;
    }


    /**
     * 数据规则读写数据向上移动
     * @return
     * @throws Exception
     */
    @Transactional
    public ObjectRestResponse<DataRuleRead> handleUpMove(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRuleRead> result = new ObjectRestResponse();
        for (Long dataRuleReadId : ids){
            DataRuleRead dataRuleRead = mapper.selectByPrimaryKey(dataRuleReadId);
            Long dataOrderby = dataRuleRead.getDataOrderby();
            DataRuleRead upDataRuleRead = mapper.selectUpMove(dataRuleRead.getDataRuleId(),dataRuleRead.getDataOrderby());
            if(upDataRuleRead == null){
                result.setStatus(500);
                result.setMessage("已经是第一条数据,无法继续向上移动");
                return result;
            }
            dataRuleRead.setDataOrderby(upDataRuleRead.getDataOrderby());
            upDataRuleRead.setDataOrderby(dataOrderby);
            mapper.updateByPrimaryKeySelective(dataRuleRead);
            mapper.updateByPrimaryKeySelective(upDataRuleRead);
        }
        return result;
    }

    /**
     * 数据规则读写数据向下移动
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional
    public ObjectRestResponse<DataRuleRead> handleDownMove(List<Long> ids) throws Exception {
        ObjectRestResponse<DataRuleRead> result = new ObjectRestResponse();
        for (Long DataRuleReadId : ids){
            DataRuleRead DataRuleRead = mapper.selectByPrimaryKey(DataRuleReadId);
            Long dataOrderby = DataRuleRead.getDataOrderby();
            DataRuleRead upDataRuleRead = mapper.selectDownMove(DataRuleRead.getDataRuleId(),DataRuleRead.getDataOrderby());
            if(upDataRuleRead == null){
                result.setStatus(500);
                result.setMessage("已经是最后一条数据,无法继续向下移动");
                return result;
            }
            DataRuleRead.setDataOrderby(upDataRuleRead.getDataOrderby());
            upDataRuleRead.setDataOrderby(dataOrderby);
            mapper.updateByPrimaryKeySelective(DataRuleRead);
            mapper.updateByPrimaryKeySelective(upDataRuleRead);
        }
        return result;
    }

    /**
     * 根据子站id查询读写数据
     * @param dtuId
     * @return
     */
    public ObjectRestResponse<List<DataRuleRead>> queryDtuIdDataRuleRead(@RequestParam Long dtuId){
        // 查询当前子站信息,获取数据规则id
        Stations stations = stationsMapper.selectByPrimaryKey(dtuId);

        //根据数据规则id 查询实时数据list
        DataRuleRead dataRuleRead = new DataRuleRead();
        dataRuleRead.setDataRuleId(stations.getDataRuleId());
        List<DataRuleRead> dataRuleReadList = mapper.select(dataRuleRead);

        for (DataRuleRead data : dataRuleReadList){
            SystemDict systemDict = systemDictMapper.selectByPrimaryKey(data.getSystemDictId());
            RealDataInfo dataInfo = new RealDataInfo();
            dataInfo.setDtuId(dtuId);
            dataInfo.setRealtimeDataType(systemDict.getDictId());
            RealDataInfo realDataInfo = realDataInfoMapper.selectOne(dataInfo);
            data.setRealDataInfo(realDataInfo);
        }
        ObjectRestResponse<List<DataRuleRead>> result = new ObjectRestResponse<>();
        result.setData(dataRuleReadList);
        return result;
    }


}