package com.github.wxiaoqi.security.things.rest;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.things.biz.JsonServiceBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;

/**
 * Json导入导出服务。
 * 
 * </p>
 *
 * @author Lwt
 * @since 2018-11-21
 */
@RestController
@RequestMapping("/json")
@Api(value = "Json导入导出服务", tags = "Json导入导出服务")
public class JsonController {

    @Autowired
    private JsonServiceBiz JsonServiceBiz;


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
     * @param file			数据规则Json文件
     * @param req
     * @return
     * @throws Exception
     */
    @ApiOperation(value="Json导入", notes="上传Json表格插入数据库")
    @RequestMapping(value = "/importDataRule",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Object> importDataRule
    (@RequestParam("file") MultipartFile file, HttpServletRequest req) throws Exception {
        ObjectRestResponse<Object> result = JsonServiceBiz.importDataRule(file);
        return result;
    }

}
