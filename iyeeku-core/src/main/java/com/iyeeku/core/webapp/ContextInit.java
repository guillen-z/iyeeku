package com.iyeeku.core.webapp;

import com.iyeeku.core.startup.BaseInit;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

public class ContextInit extends ContextLoaderListener {

    private static ApplicationContext CONTEXT;

    public static ApplicationContext getContext(){
        return CONTEXT;
    }

    public static void setContext(ApplicationContext ctx) {
        CONTEXT = ctx;
    }

    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent context) {
        super.contextInitialized(context);
        System.out.println("服务器启动开始!!!!!");

        //1.加载基础环境
        BaseInit.init(context);

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
        try{

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
