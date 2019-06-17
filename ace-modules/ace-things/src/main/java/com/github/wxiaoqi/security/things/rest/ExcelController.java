package com.github.wxiaoqi.security.things.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.util.IdWorker;
import com.github.wxiaoqi.security.things.biz.ExcelServiceBiz;
import com.github.wxiaoqi.security.things.vo.DownloadStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Excel导入导出服务。
 * 
 * </p>
 *
 * @author Lwt
 * @since 2018-11-21
 */
@RestController
@RequestMapping("/excel")
@Api(value = "Excel导入导出服务", tags = "Excel导入导出服务")
public class ExcelController {

    @Autowired
    private ExcelServiceBiz excelServiceBiz;


    @RequestMapping(value = "/export",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<DownloadStatus> exportFromJson(@RequestBody(required = true) String jsonData,
            HttpServletResponse response
            ) throws Exception{
        ObjectRestResponse<DownloadStatus> result = new ObjectRestResponse();
        DownloadStatus downloadStatus = null;
        long batchId = new IdWorker().nextId();
        JSONArray sheetDataArray = JSON.parseArray(jsonData);
        if (sheetDataArray == null || sheetDataArray.size() == 0) {
            result.setStatus(500);
            result.setMessage("JSON数据为空");
            return result;
        }
        excelServiceBiz.exportFromJson( batchId, sheetDataArray,response);
        return result;
    }

    /**
     * 配置上传文件时的临时路径
     * @return
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(System.getProperty("java.io.tmpdir"));
        return factory.createMultipartConfig();
    }


    /**
     * @param file			Excel文件
     * @param isUpdate 是否更新源实时数据 0 否 1是
     * @param req
     * @return
     * @throws Exception
     */
    @ApiOperation(value="Excel导入", notes="上传Excel表格插入数据库")
    @RequestMapping(value = "/importDataRuleRealtime",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Object> importDataRuleRealtime
    (@RequestParam("file") MultipartFile file,
     @RequestHeader String isUpdate,
     @RequestHeader String dataRuleId, HttpServletRequest req) throws Exception {
        ObjectRestResponse<Object> result = excelServiceBiz.importDataRuleRealtime(file,isUpdate,dataRuleId);
        return result;
    }

    /**
     * @param file			Excel文件
     * @param isUpdate 是否更新源读写数据 0 否 1是
     * @param req
     * @return
     * @throws Exception
     */
    @ApiOperation(value="Excel导入", notes="上传Excel表格插入数据库")
    @RequestMapping(value = "/importDataRuleRead",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Object> importDataRuleRead
    (@RequestParam("file") MultipartFile file,
     @RequestHeader String isUpdate,
     @RequestHeader String dataRuleId, HttpServletRequest req) throws Exception {
        ObjectRestResponse<Object> result = excelServiceBiz.importDataRuleRead(file,isUpdate,dataRuleId);
        return result;
    }

}
