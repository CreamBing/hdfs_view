package com.bing.hdfsV.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * springboot 扫描配置
 * Created by zhaobing on 2016/12/15.
 */
@Configuration
@ComponentScan(basePackages={"com.bing.hdfsV.web","com.bing.hdfsV.service","com.bing.hdfsV.constant"})
public class ApplicationConfiguration {
}
