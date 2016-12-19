package com.bing.hdfsV.listener;

import com.bing.hdfsV.constant.ConfigConstant;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 项目启动初始化配置常量
 * Created by zhaobing on 2016/12/19.
 */
@WebListener
public class ConfListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //TODO 集成日志
        System.out.println("初始化开始！！");
        ConfigConstant configConstant = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(ConfigConstant.class);
        configConstant.init();
        System.out.println("初始化完成！！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
