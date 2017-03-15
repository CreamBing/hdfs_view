package com.bing.hdfsV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * main主程序
 * Created by zhaobing on 2016/12/15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.bing.hdfsV.conf"})
@ServletComponentScan
public class HdfsViewApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(HdfsViewApp.class);
        application.run(args);

    }
}
