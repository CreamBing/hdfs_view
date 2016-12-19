package com.bing.hdfsV.constant;

import com.bing.hdfsV.conf.CustomConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 配置常量
 * Created by zhaobing on 2016/12/19.
 */
@Component
public class ConfigConstant {

    @Autowired
    private CustomConfiguration customConfiguration;

    public static String ROOT_PATH = "";

    public void init(){
        ROOT_PATH = customConfiguration.getHdfsRoot();
    }
}