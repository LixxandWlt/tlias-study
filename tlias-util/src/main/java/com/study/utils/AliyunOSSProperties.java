package com.study.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 类名称：AliyunOSSProperties
 * 描述：Aliyun OSS属性实体类
 *
 * @author: KM
 * 创建时间: 2025/03/13
 */

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}
