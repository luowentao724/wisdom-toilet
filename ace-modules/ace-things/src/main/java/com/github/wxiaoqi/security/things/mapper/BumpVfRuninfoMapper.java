package com.github.wxiaoqi.security.things.mapper;

import com.github.wxiaoqi.security.things.entity.BumpVfRuninfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 变频器数据信息表
 * 
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-18 20:44:59
 */
public interface BumpVfRuninfoMapper extends Mapper<BumpVfRuninfo> {

    /**
     * 获取变频器历史曲线数据
     * @param params
     * @return
     */
    List<BumpVfRuninfo> searchBumpVfRuninfoHistoryCurve(@Param("cm") Map<String, Object> params);

    /**
     * 获取变频器历史曲线数据
     * @param params
     * @return
     */
    List<BumpVfRuninfo> getBumpVfRuninfo(@Param("cm") Map<String, Object> params);

    @Select("SELECT \n" +
            "  `id`,\n" +
            "  `dtu_id` AS dtuId,\n" +
            "  `vf_device_code` AS vfDeviceCode,\n" +
            "  `run_speed`  AS runSpeed,\n" +
            "  `setting_speed` AS settingSpeed,\n" +
            "  `bus_voltage` AS busVoltage,\n" +
            "  `output_voltage` AS outputVoltage,\n" +
            "  `run_rev` AS runRev,\n" +
            "  `output_power` AS outputPower,\n" +
            "  `output_electric` AS outputElectric,\n" +
            "  `output_torque` AS outputTorque,\n" +
            "  `vf_temperature` AS vfTemperature,\n" +
            "  `vf_humidity` AS vfHumidity,\n" +
            "  `today_runtime` AS todayRuntime,\n" +
            "  `accu_runtime` AS accuRuntime,\n" +
            "  `gather_time` AS gatherTime,\n" +
            "  `create_time` AS createTime\n" +
            "FROM\n" +
            "  `ag_things`.`bump_vf_runinfo`\n" +
            "  WHERE \n" +
            "  dtu_id = #{dtuId}\n" +
            "  AND DATE_FORMAT(gather_time,'%Y-%m-%d') = DATE_FORMAT(#{gatherTime},'%Y-%m-%d')")
    List<BumpVfRuninfo> getBumpVfRuninfo(@Param("dtuId")Long dtuId,@Param("gatherTime")String gatherTime);



}
