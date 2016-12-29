package com.bing.hdfsV.web;

import com.bing.hdfsV.formbean.SearchFormBean;
import com.bing.hdfsV.service.DataService;
import org.apache.commons.lang.StringUtils;
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
        if(StringUtils.isBlank(searchCont.getSearchCont())){
            return null;
        }
        return dataService.getSearchDataByPath(searchCont.getSearchCont());
    }

    /**
     * 首页搜索框下拉提示
     * @param q
     * @return
     */
    @RequestMapping(value = "searchTips")
    public Map<String,Object> searchTipsByPath(String q){
        if(!q.startsWith("/")){
            return null;
        }
        List<Map<String,Object>> items = dataService.getSearchData(q);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("items",items);
        return result;
    }


}
