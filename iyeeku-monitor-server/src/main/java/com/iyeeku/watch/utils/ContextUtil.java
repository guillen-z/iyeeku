package com.iyeeku.watch.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class ContextUtil {

    private static Logger logger = LoggerFactory.getLogger(ContextUtil.class);
    private static ApplicationContext APPLICATION_CONTEXT;

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static Object getBean(String beanId){
        if (beanId == null){
            return null;
        }

        if("null".equalsIgnoreCase(beanId)){
            return null;
        }

        return APPLICATION_CONTEXT.getBean(beanId);
    }

    public static Object getBean(Class targetClass){
        if (targetClass == null){
            return null;
        }
        return APPLICATION_CONTEXT.getBean(targetClass);
    }
    
}
