package com.iyeeku.watch.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class C3P0DatasourcePropertiesFactory {

    private static final String PRODUCTION_MODE = "0";
    private static final String PROP_USERNAME = "user";
    private static final String PROP_PASSWORD = "password";
    private final static Logger LOGGER = LoggerFactory.getLogger(C3P0DatasourcePropertiesFactory.class);

    public static Properties getProperties(String user , String pwd , String production) throws Exception{
        System.out.println("\n========  C3P0DatasourcePropertiesFactory getProperties  ==========\n");
        System.out.println("user ==>> " + user);
        System.out.println("pwd ==>> " + pwd);
        System.out.println("");
        Properties p = new Properties();
        if(PRODUCTION_MODE.equals(production)){
            try{
                String uKey = System.getProperty("ukey");
                String pKey = System.getProperty("key");
                String dec_pwd = SecurityUtil.decrypt(pwd , pKey);
                String dec_user = SecurityUtil.decrypt(user , uKey);
                p.setProperty(PROP_PASSWORD , dec_pwd);
                p.setProperty(PROP_USERNAME , dec_user);
            }catch (Exception e){
                LOGGER.error("C3P0DatasourcePropertiesFactory getProperties is error!" , e);
            }
        }else{
            p.setProperty(PROP_PASSWORD , pwd);
        }
        return p;
    }

}
