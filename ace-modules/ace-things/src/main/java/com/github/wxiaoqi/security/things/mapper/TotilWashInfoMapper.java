package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.TotilWashInfo;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 子站（公厕）便器冲洗明细表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-09 16:46:06
 */
public interface TotilWashInfoMapper extends Mapper<TotilWashInfo> {

    /**
     * 数据报表,查询子站便器每日冲洗数据
     * @return
     */
    List<TotilWashYearMonthVo> getStationsTotilWashDay (@Param("cm") Map<String,Object> params);

    /**
     * 能耗分析报表,条件查询统计数据
     * @return
     */
    List<TotilWashYearMonthVo> getTotilWashYearMonthDay (@Param("cm") Map<String,Object> params);

    /**
     * 获取便器剩余冲洗次数
     * @param params
     * @return
     */
    List<TotilWashInfo> searchWashData(@Param("cm") Map<String,Object> params);
	
}
