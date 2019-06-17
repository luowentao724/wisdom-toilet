package com.github.wxiaoqi.security.things.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.EntityUtils;
import com.github.wxiaoqi.security.common.util.IdWorker;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.things.entity.*;
import com.github.wxiaoqi.security.things.mapper.*;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * 
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-05 13:52:59
 */
@Transactional
@Service
public class StationsBiz extends BaseBiz<StationsMapper,Stations> {

    //客户信息表mapper
    @Autowired
    CustomerMapper customerMapper;

    //报警信息表mapper
    @Autowired
    ConcentAlarmMapper concentAlarmMapper;

    //变频器数据表mapper
    @Autowired
    BumpVfRuninfoMapper bumpVfRuninfoMapper;

    //变频器历史数据表mapper
    @Autowired
    BumpVfRuninfoHistoryMapper bumpVfRuninfoHistoryMapper;

    //泵站数据信息表mapper
    @Autowired
    PumpStationDataMapper pumpStationDataMapper;

    //子站公厕便器冲洗明细mapper
    @Autowired
    TotilWashInfoMapper totilWashInfoMapper;

    //子站公厕便器冲洗明细mapper
    @Autowired
    TotilWashInfoBiz totilWashInfoBiz;

    //实时数据mapper
    @Autowired
    RealDataInfoMapper realDataInfoMapper;

    //实时历史数据mapper
    @Autowired
    RealDataInfoHistoryMapper realDataInfoHistoryMapper;

    /**
     * 便器mapper
     */
    @Autowired
    ToiletMapper toiletMapper;

    /**
     * 流量表mapper
     */
    @Autowired
    DataTrafficMapper dataTrafficMapper;

    /**
     * 消息配置表mapper
     */
    @Autowired
    SmsDtuConfigMapper smsDtuConfigMapper;

    /**
     * 消息配置表mapper
     */
    @Autowired
    DataRuleMapper dataRuleMapper;

    public TableResultResponse<Stations> selectByQuery(Query query) {
        Example example = new Example(Stations.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        example.orderBy("createTime").desc();
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Stations> list = mapper.selectByExample(example);
        for (Stations s  : list){
            DataRule dataRule = dataRuleMapper.selectByPrimaryKey(s.getDataRuleId());
            if(dataRule != null){
                s.setDataRuleName(dataRule.getRuleName());
            }
        }
        return new TableResultResponse<>(result.getTotal(), list);
    }

    /**
     * 删除子站及相关数据
     * @param id
     */
    public void deleteById(Long id) {
        // 删除子站
        mapper.deleteByPrimaryKey(id);
        // 删除子站所属员工

        // 删除子站所属变频器表数据
        BumpVfRuninfo bumpVfRuninfo = new BumpVfRuninfo();
        bumpVfRuninfo.setDtuId(id);
        bumpVfRuninfoMapper.delete(bumpVfRuninfo);
        //删除子站所属变频器表历史数据
        BumpVfRuninfoHistory bumpVfRuninfoHistory = new BumpVfRuninfoHistory();
        bumpVfRuninfoHistory.setDtuId(id);
        bumpVfRuninfoHistoryMapper.delete(bumpVfRuninfoHistory);
        //删除子站报警信息表concent_alarm
        ConcentAlarm concentAlarm = new ConcentAlarm();
        concentAlarm.setDtuId(id);
        concentAlarmMapper.delete(concentAlarm);
        // 删除子站流量表数据data_traffic
        DataTraffic dataTraffic = new DataTraffic();
        dataTraffic.setDtuId(id);
        dataTrafficMapper.delete(dataTraffic);
        // 删除子站上传来的数据meter_data @TODO

        // 删除子站泵站表数据pump_station_data
        PumpStationData pumpStationData = new PumpStationData();
        pumpStationData.setDtuId(id);
        pumpStationDataMapper.delete(pumpStationData);
        // 删除子站实时数据表real_data_info
        RealDataInfo realDataInfo = new RealDataInfo();
        realDataInfo.setDtuId(id);
        realDataInfoMapper.delete(realDataInfo);
        // 删除子站实时数据历史表real_data_info_history
        RealDataInfoHistory realDataInfoHistory = new RealDataInfoHistory();
        realDataInfoHistory.setDtuId(id);
        realDataInfoHistoryMapper.delete(realDataInfoHistory);
        // 删除子站消息配置表数据sms_dtu_config
        SmsDtuConfig smsDtuConfig = new SmsDtuConfig();
        smsDtuConfig.setDtuId(id);
        smsDtuConfigMapper.delete(smsDtuConfig);
        // 删除子站便器表数据toilet
        Toilet toilet = new Toilet();
        toilet.setDtuId(id);
        toiletMapper.delete(toilet);

        // 删除子站便器冲洗次数表数据totil_wash_info
        TotilWashInfo totilWashInfo = new TotilWashInfo();
        totilWashInfo.setDtuId(id);
        totilWashInfoMapper.delete(totilWashInfo);

    }

    /**
     * 新增子站方法
     * @param entity
     */
    public void addStations(Stations entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insertSelective(entity);
        Integer totilNums = entity.getTotilNums();
        // 新增便器
        Toilet toilet = new Toilet();
        IdWorker idwork = new IdWorker();
        for(int i=0;i<totilNums;i++){
            toilet.setId(idwork.nextId());
            toilet.setDtuId(entity.getId());
            toilet.setCreateTime(new Date());
            toiletMapper.insertSelective(toilet);
        }
        // 新增泵站
        Integer bumpNums = entity.getBumpNums();
        PumpStationData pumpStationData = new PumpStationData();
        for(int i=0;i<bumpNums;i++){
            pumpStationData.setId(idwork.nextId());
            pumpStationData.setDtuId(entity.getId());
            pumpStationData.setCreatetime(new Date());
            pumpStationDataMapper.insertSelective(pumpStationData);
        }

    }


    /**
     * 资产分析报表
     * @return
     */
    public Map<String,Object> getAssetsReport (){
        List<TotilWashYearMonthVo> totilList =  mapper.getAssetsReport();
        List<String> customerNameList = new ArrayList<>(); // 客户名称数组
        List<Long> totilNumsList = new ArrayList<>(); // 便器数量
        List<Long> bumpNumsList = new ArrayList<>(); // 泵器数量
        List<Long> numsList = new ArrayList<>(); //子站数量
        for(TotilWashYearMonthVo totilWashYearMonthVo : totilList){
            customerNameList.add(totilWashYearMonthVo.getCustomerName());
            totilNumsList.add(totilWashYearMonthVo.getTotilNums());
            bumpNumsList.add(totilWashYearMonthVo.getBumpNums());
            numsList.add(totilWashYearMonthVo.getNums());
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("customerNameList",customerNameList);
        resultMap.put("totilNumsList",totilNumsList);
        resultMap.put("bumpNumsList",bumpNumsList);
        resultMap.put("numsList",numsList);
        return resultMap;
    }

    /**
     * 条件查询设备状态监控列表
     * @param params
     * @return
     */
    public TableResultResponse<Stations> statusMonitorPage(Map<String, Object> params) {
        Query query = new Query(params);
        Example example = new Example(Stations.class);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Stations> list = mapper.selectByExample(example);
        // 设置 客户信息
        for(Stations s : list){
            Customer customer = customerMapper.selectByPrimaryKey(s.getCustomerId());
            if(customer != null){
                s.setCustomerName(customer.getCustomerName());
            }
            // 设置累积冲洗次数
            Example example1 = new Example(TotilWashInfo.class);
            Example.Criteria criteria = example1.createCriteria();
            criteria.andEqualTo("dtuId",s.getId());
            List<TotilWashInfo> totillist = totilWashInfoMapper.selectByExample(example1);
            String str = new String();
            for(TotilWashInfo t : totillist){
                str += t.getAccumulateTimes() + "/";
            }
            s.setAccumulateTimes(str);
        }
        return new TableResultResponse<>(result.getTotal(), list);
    }

    /**
     * 请求数据监控页面数据
     * @param params
     * @return
     */
    public Map<String, Object> getDataMonitor(Map<String, Object> params){
        Map<String,Object> resultMap = new HashMap<>();
        Long dtuId = new Long(params.get("dtuId").toString()); // 获取子站id
        String gatherTime = params.get("gatherTime").toString(); // 获取查询时间
        Stations stations = mapper.selectByPrimaryKey(dtuId);
        // 获取子站未处理的报警数量
        ConcentAlarm concentAlarm = new ConcentAlarm();
        concentAlarm.setDtuId(dtuId);
        concentAlarm.setStatus(0); // 查询未处理的报警数量
        List<ConcentAlarm> concentAlarmList = concentAlarmMapper.select(concentAlarm);
        // 获取子站所属客户信息
        Customer customer = customerMapper.selectByPrimaryKey(stations.getCustomerId());
        // 运行状态
        //泵1运行状态：100024（1#真空泵运行状态）
        concentAlarm.setAlarmType(100024);
        ConcentAlarm alarm100024 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100024" ,alarm100024 == null ? 1 : 0); //1 正常  0 异常
//        泵2运行状态：100025（2#真空泵运行状态
        concentAlarm.setAlarmType(100025);
        ConcentAlarm alarm100025 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100025" ,alarm100025 == null ? 1 : 0); //1 正常  0 异常
//      传感器状态：100090
        concentAlarm.setAlarmType(100090);
        ConcentAlarm alarm100090 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100090" ,alarm100090 == null ? 1 : 0); //1 正常  0 异常
//        系统状态：100041
        concentAlarm.setAlarmType(100041);
        ConcentAlarm alarm100041 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100041" ,alarm100041 == null ? 1 : 0); //1 正常  0 异常
//        水箱低液位：100100
        concentAlarm.setAlarmType(100100);
        ConcentAlarm alarm100100 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100100" ,alarm100100 == null ? 1 : 0); //1 正常  0 异常
//        水箱高液位：100101
        concentAlarm.setAlarmType(100101);
        ConcentAlarm alarm100101 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100101" ,alarm100101 == null ? 1 : 0); //1 正常  0 异常
//        污箱低液位：100029
        concentAlarm.setAlarmType(100029);
        ConcentAlarm alarm100029 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100029" ,alarm100029 == null ? 1 : 0); //1 正常  0 异常
//        污箱高液位：100028
        concentAlarm.setAlarmType(100028);
        ConcentAlarm alarm100028 = concentAlarmMapper.selectOne(concentAlarm);
        resultMap.put("alarm100028" ,alarm100028 == null ? 1 : 0); //1 正常  0 异常

        //泵站监控
        // 真空度历史数据
        RealDataInfoHistory realDataInfoHistory = new RealDataInfoHistory();
        realDataInfoHistory.setDtuId(dtuId);
        realDataInfoHistory.setRealtimeDataType(100001L);
        List<RealDataInfoHistory> realDataInfoHistoryList = realDataInfoHistoryMapper.select(realDataInfoHistory);
        resultMap.put("realDataInfoHistoryList" ,realDataInfoHistoryList); //1 正常  0 异常

        //运行时间
        PumpStationData pumpStationData = new PumpStationData();
        pumpStationData.setDtuId(dtuId);
        List<PumpStationData> pumpStationDataList = pumpStationDataMapper.select(pumpStationData);
        resultMap.put("pumpStationDataList" ,pumpStationDataList); //1 正常  0 异常
        // 变频器信息表
        List<BumpVfRuninfo> bumpVfRuninfoList = bumpVfRuninfoMapper.getBumpVfRuninfo(dtuId,gatherTime);
        resultMap.put("bumpVfRuninfoList" ,bumpVfRuninfoList); //1 正常  0 异常

        //获取冲洗次数监控数据
        List<TotilWashInfo> totilWashInfoList = totilWashInfoBiz.dtuWashMonitorData(params);

        // 今日冲洗次数数据
        List<String> toiletNameList = new ArrayList<>();
        List<Integer> toiletWashNumList = new ArrayList<>();
        for(TotilWashInfo totilWashInfo : totilWashInfoList){
            toiletNameList.add(totilWashInfo.getTotilId().toString());
            toiletWashNumList.add(totilWashInfo.getTodayWashTimes());
        }
        resultMap.put("totilWashInfoList",totilWashInfoList);
        resultMap.put("toiletNameList",toiletNameList);
        resultMap.put("toiletWashNumList",toiletWashNumList);
        resultMap.put("stations",stations);
        resultMap.put("concentAlarmList",concentAlarmList);
        resultMap.put("customer",customer);
        return resultMap;
    }

    /**
     * 获取泵站实时真空度数据
     * @param realtimeDataType 100001
     * @return
     */
    public RealDataInfo getPumpStationVacuum(Long dtuId,String realtimeDataType) {
        RealDataInfo readDataInfo = new RealDataInfo();
        readDataInfo.setDtuId(dtuId);
        readDataInfo.setRealtimeDataType(realtimeDataType);
        RealDataInfo realDataInfoOne = realDataInfoMapper.selectOne(readDataInfo);
        return realDataInfoOne;
    }

}