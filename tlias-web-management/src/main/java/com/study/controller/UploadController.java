package com.study.controller;

import com.study.pojo.Result;
import com.study.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 类名称：UploadController
 * 描述：上传控制器
 *
 * @author: KM
 * 创建时间: 2025/03/12
 */

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    /**
     * 上传到本地--不推荐
     * @param name 名字
     * @param age 年龄
     * @param file 文件
     * @return {@link Result }
     * @author KM
     * @date 2025/03/13
     */
    /*
    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("上传文件：{}, {}, {}", name, age, file);
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //新文件名
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));//文件名截取后缀
        String newFileName = UUID.randomUUID().toString() + substring;

        if(!file.isEmpty()){
            file.transferTo(new File("F:\\DevelopmentProject\\JavaProject\\JavaWebCode\\" + newFileName));
        }
        return Result.success();
    }*/

    /**
     * 上传到阿里云
     *
     * @param file 文件
     * @return {@link Result }
     * @author KM
     * @date 2025/03/13
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件：{}", file);
        if (!file.isEmpty()){
            String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
            log.info("上传文件地址：{}", url);
            return Result.success(url);
        }
        return Result.error("上传失败");
    }

}
