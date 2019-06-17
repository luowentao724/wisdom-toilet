package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.github.wxiaoqi.security.common.util.Query;
import com.github.wxiaoqi.security.common.util.StringUtil;
import com.github.wxiaoqi.security.things.biz.DataRuleRealtimeBiz;
import com.github.wxiaoqi.security.things.entity.DataRuleRealtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dataRuleRealtime")
public class DataRuleRealtimeController extends BaseController<DataRuleRealtimeBiz,DataRuleRealtime> {

    @Autowired
    DataRuleRealtimeBiz dataRuleRealtimeBiz;

    /**
     * 分页查询实时数据列表
     * @param params
     * @return
     */
    @Override
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<DataRuleRealtime> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return dataRuleRealtimeBiz.searchByQuery(query);
    }

    /**
     * 根据id 删除多个数据规则
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse<DataRuleRealtime> deleteIds(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRuleRealtime> result = dataRuleRealtimeBiz.deleteByIds(StringUtil.handleIds(ids));
        return result;
    }

    /**
     * 数据规则实时数据向上移动
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/handleUpMove", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<DataRuleRealtime> handleUpMove(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRuleRealtime> result = dataRuleRealtimeBiz.handleUpMove(StringUtil.handleIds(ids));
        return result;
    }

    /**
     * 数据规则实时数据向上移动
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/handleDownMove", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<DataRuleRealtime> handleDownMove(@RequestParam String ids) throws Exception {
        ObjectRestResponse<DataRuleRealtime> result = dataRuleRealtimeBiz.handleDownMove(StringUtil.handleIds(ids));
        return result;
    }

    /**
     * 根据子站id查询实时数据
     * @param dtuId
     * @return
     */
    @RequestMapping(value = "/queryDtuIdDataRuleRealtime",method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<DataRuleRealtime>> queryDtuIdDataRuleRealtime(@RequestParam Long dtuId){
        //查询列表数据
        return dataRuleRealtimeBiz.queryDtuIdDataRuleRealtime(dtuId);
    }


}