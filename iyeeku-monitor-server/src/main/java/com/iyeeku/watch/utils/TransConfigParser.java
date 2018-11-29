package com.iyeeku.watch.utils;

import com.iyeeku.watch.inbound.IyeekuHandlerProcess;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class TransConfigParser {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
        ContextUtil.setApplicationContext(applicationContext);

        String confName = TransConfigParser.class.getClassLoader().getResource("config/service/inbound.xml").getPath();

        InputStream in;

        try{
            in = new FileInputStream(new File(confName));
        }catch (FileNotFoundException e){
            return;
        }

        SAXReader reader = new SAXReader();

        try {
            Document document = reader.read(in);
            Element rootElement = document.getRootElement();

            List<Element> elements = rootElement.elements();

            elements.forEach(element -> {
                String code = element.attributeValue("code");
                String classPath = element.attributeValue("class");

                try {
                    Class c = Class.forName(classPath);

                    IyeekuHandlerProcess process = (IyeekuHandlerProcess)ContextUtil.getBean(c);
                    process.doExecute(null);

                }catch (ClassNotFoundException e1){

                }
            });

        }catch (DocumentException e){

        }


    }

}
