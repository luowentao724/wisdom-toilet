package com.github.wxiaoqi.security.things.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.things.entity.PumpStationData;
import com.github.wxiaoqi.security.things.mapper.PumpStationDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 泵站数据信息表
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-18 20:44:59
 */
@Transactional
@Service
public class PumpStationDataBiz extends BaseBiz<PumpStationDataMapper,PumpStationData> {

    /**
     * 批量更新泵站信息
     * @param pumpStationDataList
     * @return
     */
    public ObjectRestResponse<PumpStationData> updateList(List<PumpStationData> pumpStationDataList) {
        for (PumpStationData pumpStationData : pumpStationDataList){
            mapper.updateByPrimaryKeySelective(pumpStationData);
        }
        return new ObjectRestResponse<PumpStationData>();
    }

}