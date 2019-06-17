package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.common.util.StringUtil;
import com.github.wxiaoqi.security.things.biz.DataRuleBiz;
import com.github.wxiaoqi.security.things.entity.DataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("dataRule")
public class DataRuleController extends BaseController<DataRuleBiz,DataRule> {

    @Autowired
    DataRuleBiz dataRuleBiz;



    /**
     * 分页查询子站列表
     * @param params
     * @return
     */
    @Override
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<DataRule> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return dataRuleBiz.selectByQuery(query);
    }

    @Override
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<DataRule> add(@RequestBody DataRule entity){
        dataRuleBiz.insertSelectiveDataRule(entity);
        return new ObjectRestResponse<DataRule>();
    }

    /**
     * 根据id 删除多个数据规则
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse<DataRule> deleteIds(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRule> result = dataRuleBiz.deleteByIds(StringUtil.handleIds(ids));
        return result;
    }

    /**
     * 根据id复制多个数据规则
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cloneDataRuleIds", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<DataRule> cloneDataRuleIds(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRule> result = dataRuleBiz.cloneDataRuleIds(StringUtil.handleIds(ids));
        return result;
    }


}