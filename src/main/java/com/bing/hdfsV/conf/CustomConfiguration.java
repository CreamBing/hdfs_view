package com.bing.hdfsV.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置类
 * Created by zhaobing on 2016/12/16.
 */
@Configuration
@ConfigurationProperties(prefix = "custom",locations = "classpath:conf/custom.properties")
public class CustomConfiguration {

    public static String hdfsRoot;

    public String getHdfsRoot() {
        return hdfsRoot;
    }

    public void setHdfsRoot(String hdfsRoot) {
        CustomConfiguration.hdfsRoot = hdfsRoot;
    }
}
