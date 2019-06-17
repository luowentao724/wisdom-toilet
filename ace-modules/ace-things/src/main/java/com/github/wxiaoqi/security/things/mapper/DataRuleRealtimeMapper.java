package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.DataRuleRealtime;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 数据规则实时数据
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-29 15:41:05
 */
public interface DataRuleRealtimeMapper extends Mapper<DataRuleRealtime> {

    // 查找向上移动所需要更新的实时数据
    @Select("SELECT \n" +
            "  id,\n" +
            "  data_rule_id AS dataRuleId,\n" +
            "  data_orderby AS dataOrderby \n" +
            "FROM\n" +
            "  data_rule_realtime \n" +
            "WHERE\n" +
            "data_rule_id = #{dataRuleId}\n" +
            "AND data_orderby > #{dataOrderby}\n" +
            "ORDER BY data_orderby ASC LIMIT 1")
    public DataRuleRealtime selectUpMove(@Param("dataRuleId") Long dataRuleId, @Param("dataOrderby") Long dataOrderby);

    // 查找向上移动所需要更新的实时数据
    @Select("SELECT \n" +
            "  id,\n" +
            "  data_rule_id AS dataRuleId,\n" +
            "  data_orderby AS dataOrderby \n" +
            "FROM\n" +
            "  data_rule_realtime \n" +
            "WHERE\n" +
            "data_rule_id = #{dataRuleId}\n" +
            "AND data_orderby < #{dataOrderby}\n" +
            "ORDER BY data_orderby DESC LIMIT 1")
    public DataRuleRealtime selectDownMove(@Param("dataRuleId") Long dataRuleId, @Param("dataOrderby") Long dataOrderby);


}
