package com.github.wxiaoqi.security.things.rest;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 下载静态资源请求
 */
@Controller
@RequestMapping("download")
public class DownloadController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Value("${jdbc.exportPath}")
//    private String srcPath;

    @RequestMapping(value = "/databaseFile", method = RequestMethod.GET)
	@ApiOperation(value="下载附件文件", notes="下载附件文件")
    public void doPost(@RequestParam("filePath")String filePath, HttpServletResponse response)
            throws ServletException, IOException {
        File file = new File(filePath);

        // 获取文件名
        String fileName = null;
        if(filePath.contains("/")) {
            fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        }else if(filePath.contains("\\")){
            fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        }else {
            fileName = filePath;
        }

        // 设置以流的形式下载文件，这样可以实现任意格式的文件下载
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", " attachment;filename=" + fileName);
        response.setContentLength((int) file.length());

        FileInputStream fis = null;
        try {
            while (true){
                if (file.exists()) {
                    break;
                }
            }
            fis = new FileInputStream(file);
            byte[] buffer = new byte[128];
            int count = 0;
            while ((count = fis.read(buffer)) > 0) {
                response.getOutputStream().write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.getOutputStream().flush();
            response.getOutputStream().close();
            fis.close();
        }

    }

}