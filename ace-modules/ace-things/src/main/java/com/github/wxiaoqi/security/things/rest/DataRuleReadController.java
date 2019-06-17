package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.common.util.StringUtil;
import com.github.wxiaoqi.security.things.biz.DataRuleReadBiz;
import com.github.wxiaoqi.security.things.entity.DataRuleRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dataRuleRead")
public class DataRuleReadController extends BaseController<DataRuleReadBiz,DataRuleRead> {

    @Autowired
    DataRuleReadBiz dataRuleReadBiz;

    /**
     * 分页查询读写数据列表
     * @param params
     * @return
     */
    @Override
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<DataRuleRead> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return dataRuleReadBiz.searchByQuery(query);
    }

    /**
     * 根据id 删除多个读写数据
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse<DataRuleRead> deleteIds(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRuleRead> result = dataRuleReadBiz.deleteByIds(StringUtil.handleIds(ids));
        return result;
    }

    /**
     * 读写数据向上移动
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/handleUpMove", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<DataRuleRead> handleUpMove(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRuleRead> result = dataRuleReadBiz.handleUpMove(StringUtil.handleIds(ids));
        return result;
    }

    /**
     * 读写数据向上移动
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/handleDownMove", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<DataRuleRead> handleDownMove(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRuleRead> result = dataRuleReadBiz.handleDownMove(StringUtil.handleIds(ids));
        return result;
    }

    /**
     * 根据子站id查询读写数据
     * @param dtuId
     * @return
     */
    @RequestMapping(value = "/queryDtuIdDataRuleRead",method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<DataRuleRead>> queryDtuIdDataRuleRead(@RequestParam Long dtuId){
        //查询列表数据
        return dataRuleReadBiz.queryDtuIdDataRuleRead(dtuId);
    }

}