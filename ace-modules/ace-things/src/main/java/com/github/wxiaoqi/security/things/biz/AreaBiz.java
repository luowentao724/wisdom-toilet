package com.github.wxiaoqi.security.things.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.things.entity.Area;
import com.github.wxiaoqi.security.things.mapper.AreaMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 *
 * @author Mr.LWT
 * @email 463540703@qq.com
 * @date 2019-04-25 17:37:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AreaBiz extends BaseBiz<AreaMapper,Area> {
    private Logger logger = LoggerFactory.getLogger(AreaBiz.class);

    /**
     * 批量删除area数据方法
     * @param ids
     */
    public void delete(String ids) {
        try {
            if (StringUtils.isNotBlank(ids)) {
                String[] idArr = ids.split(",");
                for (int i=0;i<idArr.length;i++){
                    super.deleteById(new Long(idArr[i]));
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }


}