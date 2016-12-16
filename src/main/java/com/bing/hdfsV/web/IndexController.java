package com.bing.hdfsV.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 首页controller，利用rest api返回数据
 * Created by zhaobing on 2016/12/15.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * @return 首页视图
     */
    @RequestMapping
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/root")
    public String getRoot(Map<String,Object> model){
        model.put("msg","hello");
        return  "nav";
    }
}
