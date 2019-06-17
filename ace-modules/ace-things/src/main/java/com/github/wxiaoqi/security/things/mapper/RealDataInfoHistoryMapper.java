package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.RealDataInfoHistory;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-19 09:33:00
 */
public interface RealDataInfoHistoryMapper extends Mapper<RealDataInfoHistory> {
    /**
     * 数据报表,查询子站泵器真空度等数据
     * @param params
     * @return
     */
    List<TotilWashYearMonthVo> getStationsRealDataInfo(@Param("cm") Map<String,Object> params);
}
