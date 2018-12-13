package com.iyeeku.core.security;

import com.iyeeku.core.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ActiveMqConnectPropertiesFactory {

    private static final String PRODUCTION_MODE = "0";
    private static final String PROP_USERNAME = "userName";
    private static final String PROP_PASSWORD = "password";
    private final static Logger logger = LoggerFactory.getLogger(ActiveMqConnectPropertiesFactory.class);

    public static Properties getProperties(String user , String pwd , String production) throws Exception{
        Properties p = new Properties();
        if(PRODUCTION_MODE.equals(production)){
            try{
                String key = System.getProperty("key");
                String ukey = System.getProperty("ukey");

                String dec_user = SecurityUtil.decrypt(user , ukey);
                String dec_pwd = SecurityUtil.decrypt(pwd,key);

                p.setProperty(PROP_USERNAME , dec_user);
                p.setProperty(PROP_PASSWORD , dec_pwd);
            }catch (Exception e){
                logger.error("C3P0DatasourcePropertiesFactory getProperties is error!" , e);
            }
        }else{
            p.setProperty(PROP_PASSWORD , pwd);
        }
        return p;
    }



}
