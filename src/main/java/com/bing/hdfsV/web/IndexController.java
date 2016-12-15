package com.bing.hdfsV.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页controller，利用rest api返回数据
 * Created by zhaobing on 2016/12/15.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/root")
    @ResponseBody
    public String getRoot(){
        return  "hello";
    }
}
