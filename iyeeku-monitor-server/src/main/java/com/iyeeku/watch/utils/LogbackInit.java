package com.iyeeku.watch.utils;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

import java.io.File;

public class LogbackInit {

    /**
     * 设置logicback.xml配置文件并加载
     * @param configFilepathName
     */
    public static void initLogback(String configFilepathName){
        File file = new File(configFilepathName);
        LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.setContext(loggerContext);
        loggerContext.reset();
        try {
            joranConfigurator.doConfigure(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
    }

}
