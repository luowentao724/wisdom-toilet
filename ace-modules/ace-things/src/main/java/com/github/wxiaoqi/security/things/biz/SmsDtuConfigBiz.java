package com.github.wxiaoqi.security.things.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.things.entity.SmsDtuConfig;
import com.github.wxiaoqi.security.things.mapper.SmsDtuConfigMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-24 14:08:17
 */
@Service
public class SmsDtuConfigBiz extends BaseBiz<SmsDtuConfigMapper,SmsDtuConfig> {

    public List<SmsDtuConfig> getList(Long dtuId){
        SmsDtuConfig smsDtuConfig = new SmsDtuConfig();
        smsDtuConfig.setDtuId(dtuId);
        List<SmsDtuConfig> list = mapper.select(smsDtuConfig);
        return list;
    }


}