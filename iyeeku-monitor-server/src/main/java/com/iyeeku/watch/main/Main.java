package com.iyeeku.watch.main;

import com.iyeeku.watch.server.IyeekuWatchBIOServer;
import com.iyeeku.watch.utils.ContextUtil;
import com.iyeeku.watch.utils.LogbackInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        if (!isExistEncryptKey()){
            logger.info("密钥不存在...");
            return;
        }
        //加载logback日志系统  ** 注意这里idea启动参数中 Working directory的设置 %MODULE_DIR%
        String logConf =  Main.class.getClassLoader().getResource("config/log/logback.xml").getPath();
        //LogbackInit.initLogback(System.getProperty("user.dir")+"/config/log/logback.xml");
        LogbackInit.initLogback(logConf);
        logger.info("启动spring容器...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
        logger.info("spring容器启动成功...");
        //设置全局的applicationContext对象
        ContextUtil.setApplicationContext(applicationContext);
        try {
            //启动服务器
            logger.info("开始启动服务...");
            new IyeekuWatchBIOServer().start();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * 校验密钥
     * @return
     */
    public static boolean isExistEncryptKey(){
        String key = System.getProperty("key");
        String ukey = System.getProperty("ukey");
        String ikey = System.getProperty("ikey");
        if (null == key || null == ukey || null == ikey || "".equals(key) || "".equals(ukey) || "".equals(ikey)){
            return false;
        }else {
            return true;
        }
    }

}
