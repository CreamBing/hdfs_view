package com.bing;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 通过url读取hadoop中hdfs的指定文件内容，类似cat命令
 * Created by zhaobing on 2016/12/9.
 */
public class URLCat {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws IOException {
        InputStream in = null;
        try {
            in = new URL(args[0]).openStream();
            IOUtils.copyBytes(in,System.out,4096,false);
        }finally {
            IOUtils.closeStream(in);
        }
    }
}
