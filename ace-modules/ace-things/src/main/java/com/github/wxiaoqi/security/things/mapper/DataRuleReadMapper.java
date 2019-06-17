package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.DataRuleRead;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 数据规则读写数据
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-29 15:41:05
 */
public interface DataRuleReadMapper extends Mapper<DataRuleRead> {

    // 查找向上移动所需要更新的读写数据
    @Select("SELECT \n" +
            "  id,\n" +
            "  data_rule_id AS dataRuleId,\n" +
            "  data_orderby AS dataOrderby \n" +
            "FROM\n" +
            "  data_rule_read \n" +
            "WHERE\n" +
            "data_rule_id = #{dataRuleId}\n" +
            "AND data_orderby > #{dataOrderby}\n" +
            "ORDER BY data_orderby ASC LIMIT 1")
    public DataRuleRead selectUpMove(@Param("dataRuleId") Long dataRuleId, @Param("dataOrderby") Long dataOrderby);

    // 查找向上移动所需要更新的读写数据
    @Select("SELECT \n" +
            "  id,\n" +
            "  data_rule_id AS dataRuleId,\n" +
            "  data_orderby AS dataOrderby \n" +
            "FROM\n" +
            "  data_rule_read \n" +
            "WHERE\n" +
            "data_rule_id = #{dataRuleId}\n" +
            "AND data_orderby < #{dataOrderby}\n" +
            "ORDER BY data_orderby DESC LIMIT 1")
    public DataRuleRead selectDownMove(@Param("dataRuleId") Long dataRuleId, @Param("dataOrderby") Long dataOrderby);


}
