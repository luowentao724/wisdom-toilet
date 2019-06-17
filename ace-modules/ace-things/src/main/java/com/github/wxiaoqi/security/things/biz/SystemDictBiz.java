package com.github.wxiaoqi.security.things.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.things.SpringUtil;
import com.github.wxiaoqi.security.things.entity.SystemDict;
import com.github.wxiaoqi.security.things.mapper.SystemDictMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关联描述获取服务。
 * @author Lwt
 *         <p>
 *         2018-01-23，静态方法访问改为使用SpringUtil获取Bean的方式，优于之前的
 */
@Service
@CacheConfig
public class SystemDictBiz extends BaseBiz<SystemDictMapper,SystemDict> {


    /**
     * 获取数据字典dictName
     * @param typeName
     * @param code
     * @return
     */
    public static String getDDDesc(String typeName, String code) {
        SystemDictBiz service = SpringUtil.getBean(SystemDictBiz.class);
        return service._getDDDesc(typeName, code);
    }

    public static String getDictNameKey(Long id) {
        SystemDictBiz service = SpringUtil.getBean(SystemDictBiz.class);
        return service._getDictNameKey(id);
    }

    public String _getDDDesc(String typeName, String code) {
        return mapper.getDDDescription(typeName, code);
    }

    public String _getDictNameKey(Long id) {
        return mapper.getDictNameKey(id);
    }

    /**
     * 根据type字段查找 数据字典
     * @param typeName
     * @return
     */
    public List<SystemDict> getDDDescriptionType(String typeName){
        return mapper.getDDDescriptionType(typeName);
    }

}