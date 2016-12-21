package com.bing.hdfsV.web;

import com.bing.hdfsV.formbean.SearchFormBean;
import com.bing.hdfsV.service.DataService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * 通过dataService中的getRootData方法从hdfs文件系统中获取搜索目录下的文件和目录
     * @return result
     */
    @RequestMapping(value = "search",method= RequestMethod.POST)
    public Map<String,Object> getRootData(@RequestBody SearchFormBean searchCont){
        return dataService.getSearchData(searchCont.getSearchCont());
    }

    @RequestMapping(value = "searchTips")
    public Map<String,Object> searchTipsByPath(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<10;i++){
            Map<String,Object> result = new HashMap<String, Object>();
            result.put("mac",i);
            list.add(result);
        }
        Map<String,Object> test = new HashMap<String, Object>();
        test.put("mac",list);
        return test;
    }

    @RequestMapping(value = "searchTips1")
    public Map<String,Object> searchTipsByPath1(){
        Map<String,Object> result = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++){
            list.add(String.valueOf(i));
        }
        result.put("mac",list);
        return result;
    }

    @RequestMapping(value = "searchTips2")
    public JSONObject searchTipsByPath2(){
        JSONObject jsonObject = new JSONObject("{id:1,text:'text'},{id:2,text:'text'}");
        return jsonObject;
    }


}
