package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.Stations;
import com.github.wxiaoqi.security.things.vo.TotilWashYearMonthVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-02 18:27:02
 */
public interface StationsMapper extends Mapper<Stations> {

    /**
     * 资产分析报表统计
     * @return
     */
    List<TotilWashYearMonthVo> getAssetsReport ();
}
