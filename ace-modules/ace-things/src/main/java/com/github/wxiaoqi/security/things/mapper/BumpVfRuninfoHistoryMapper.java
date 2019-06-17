package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.BumpVfRuninfoHistory;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 变频器历史数据信息表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-22 09:26:29
 */
public interface BumpVfRuninfoHistoryMapper extends Mapper<BumpVfRuninfoHistory> {

    /**
     * 获取变频器历史曲线数据
     * @param params
     * @return
     */
    List<BumpVfRuninfoHistory> searchBumpVfRuninfoHistoryCurve(@Param("cm") Map<String, Object> params);

}
