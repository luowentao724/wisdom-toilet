package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.ConcentAlarm;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 报警信息表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-09 21:39:13
 */
public interface ConcentAlarmMapper extends Mapper<ConcentAlarm> {

    /**
     * 故障分析报表,查询当年每月数据
     * @param date 当前月份 例如:2019
     * @return
     */
    List<TotilWashYearMonthVo> getAlarmYearMonth (@Param("cm") Map<String, Object> params);


    /**
     * 分页查收查询设备报警信息
     * @return
     */
    List<ConcentAlarm> searchPage(@Param("cm") Map<String, Object> params);
	
}
