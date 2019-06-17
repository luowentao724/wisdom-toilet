/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StringUtil
 * Author:   罗文陶的电脑
 * Date:     2019/5/28 19:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.wxiaoqi.security.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 罗文陶的电脑
 * @create 2019/5/28
 * @since 1.0.0
 */
public class StringUtil {

    /**
     * 批量删除ids处理
     *
     * @param ids
     * @return
     */
    public static List<Long> handleIds(String ids) {
        List<Long> idLongs = new ArrayList<Long>();
        try{
            String[] str1 = ids.split(",");
            for(String list : str1){
                Long listlong = Long.parseLong(list);
                idLongs.add(listlong);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return idLongs;
    }

}
