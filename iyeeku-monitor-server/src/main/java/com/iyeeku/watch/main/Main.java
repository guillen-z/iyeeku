package com.iyeeku.watch.main;

import com.iyeeku.watch.mapper.PfCodeinfoMapper;
import com.iyeeku.watch.utils.ContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
        ContextUtil.setApplicationContext(applicationContext);

        PfCodeinfoMapper pfCodeinfoMapper = (PfCodeinfoMapper)ContextUtil.getBean(PfCodeinfoMapper.BEANID);

/*        DBUtil db = new DBUtil();
        String key = System.getProperty("key");
        if (key == null || "".equals(key)){
            System.out.println("密钥不存在!");
            return;
        }

        try {

            IyeekuWatchServer.run();

        }catch (Exception ex){
            ex.printStackTrace();
        }*/

    }

}
