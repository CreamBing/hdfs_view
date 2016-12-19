package com.bing.hdfsV.service;

import com.bing.hdfsV.constant.ConfigConstant;
import org.apache.commons.lang.StringUtils;
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

    //通过静态配置文件类获取到配置文件中的hdfs根路径
    private final String rootPath = ConfigConstant.ROOT_PATH;

    /**
     * 利用hdfs的FileSystem实现类获取/目录下的文件和目录
     * @return relust
     */
    public Map<String,Object> getRootData(){
        Map<String,Object> result = new HashMap<String, Object>();
        //如果路径为空，直接返回
        if(StringUtils.isBlank(rootPath)){
            //TODO 日志
            return null;
        }
        List<String> tmpList = getDetailByPath(rootPath);
        result.put("content",tmpList);
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


    private List<String> getDetailByPath(String pathStr){
        List<String> tmpList = new ArrayList<String>();
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(pathStr),conf);
            Path path = new Path(pathStr);
            FileStatus[] status = fs.listStatus(path);
            Path[] listedPaths = FileUtil.stat2Paths(status);
            for (Path p : listedPaths){
                tmpList.add(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpList;

    }
}
