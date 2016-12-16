package com.bing.hdfsV.service;

import com.bing.hdfsV.conf.CustomConfiguration;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取数据的service方法
 * Created by zhaobing on 2016/12/16.
 */
@Service
public class DataService {

    /**
     * 利用hdfs的FileSystem实现类获取/目录下的文件和目录
     * @return relust
     */
    public Map<String,Object> getRootData(){
        Map<String,Object> result = new HashMap<String, Object>();
        String rootPath = CustomConfiguration.hdfsRoot;
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(rootPath),conf);
            Path path = new Path(rootPath);
            FileStatus[] status = fs.listStatus(path);
            Path[] listedPaths = FileUtil.stat2Paths(status);
            List<String> tmpList = new ArrayList<String>();
            for (Path p : listedPaths){
                Map<String,Object> tmpMap = new HashMap<String, Object>();
                tmpList.add(p.toString());
            }
            result.put("content",tmpList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将根路径添加到返回的map中
        result.put("path",rootPath);
        return result;
    }

    /**
     * 利用hdfs的FileSystem实现类获取搜索目录下的文件和目录
     * @return relust
     */
    public Map<String,Object> getSearchData(String searchCont){
        System.out.println(searchCont);
        return null;
    }
}
