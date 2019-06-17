package com.github.wxiaoqi.security.things.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.things.entity.Toilet;
import com.github.wxiaoqi.security.things.mapper.ToiletMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-19 20:11:33
 */
@Service
public class ToiletBiz extends BaseBiz<ToiletMapper,Toilet> {

    /**
     * 批量更新便器信息
     * @param pumpStationDataList
     * @return
     */
    public ObjectRestResponse<Toilet> updateList(List<Toilet> pumpStationDataList) {
        for (Toilet toilet : pumpStationDataList){
            mapper.updateByPrimaryKeySelective(toilet);
        }
        return new ObjectRestResponse<Toilet>();
    }

}