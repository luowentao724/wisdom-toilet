package com.github.wxiaoqi.security.things.biz;

import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.things.entity.Attendance;
import com.github.wxiaoqi.security.things.mapper.AttendanceMapper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;

/**
 * 考勤表
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-05-02 09:05:08
 */
@Service
public class AttendanceBiz extends BaseBiz<AttendanceMapper,Attendance> {
}