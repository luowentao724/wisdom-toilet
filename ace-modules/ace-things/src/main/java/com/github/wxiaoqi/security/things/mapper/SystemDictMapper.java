package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.SystemDict;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-10 17:41:26
 */
public interface SystemDictMapper extends Mapper<SystemDict> {

    @Select("SELECT dict_name FROM system_dict WHERE type=#{typeName} and dict_id = #{code} limit 1")
    public String getDDDescription(@Param("typeName") String typeName, @Param("code") String code);

    @Select("SELECT dict_name FROM system_dict WHERE id = #{id} limit 1")
    public String getDictNameKey(@Param("id") Long id);

    @Select("SELECT id,dict_id as dictId,dict_name as dictName,type FROM system_dict WHERE type=#{typeName}")
    public List<SystemDict> getDDDescriptionType(@Param("typeName") String typeName);

}
