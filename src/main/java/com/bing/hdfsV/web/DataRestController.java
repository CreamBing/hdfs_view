package com.bing.hdfsV.web;

import com.bing.hdfsV.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 为前台提供数 * Created by zhaobing on 2016/12/16.
 */
@RestController
@RequestMapping("/data")
public class DataRestController {

    @Autowired
    private DataService dataService;

    /**
     * 通过dataService中的getRootData方法从hdfs文件系统中获取/目录下的文件和目录
     * @return result
     */
    @RequestMapping("root")
    public Map<String,Object> getRootData(){
        return dataService.getRootData();
    }
}
