package com.iyeeku.watch.excel;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class GenerateExcelTableUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(GenerateExcelTableUtil.class);

    public static void main(String[] args) {
        String xmlPath = GenerateExcelTableUtil.class.getClassLoader().getResource("com/iyeeku/watch/excel/conf.xml").getPath();

        SAXReader reader = new SAXReader();

        try {
            Document document = reader.read(new File(xmlPath));
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (Element element : elements){
                System.out.println(element.getName());

                if ("jdbcConnection".equals(element.getName())){
                    String driverClass = element.attributeValue("driverClass");
                    String connectionURL = element.attributeValue("connectionURL");
                    String userId = element.attributeValue("userId");
                    String password = element.attributeValue("password");

                    System.out.println(driverClass + " , " + connectionURL + " , " + userId + " , " + password);
                }

                if ("out-file".equals(element.getName())){
                    List<Element> elements1 = element.elements();
                    for (Element element1 : elements1){

                    }
                }

            }


        }catch (DocumentException e){
            e.printStackTrace();
        }
    }


    public static void main1(String[] args) {

        String xmlPath = GenerateExcelTableUtil.class.getClassLoader().getResource("com/iyeeku/watch/excel/conf.xml").getPath();

        SAXReader reader = new SAXReader();

        try {
            Document document = reader.read(new File(xmlPath));
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (Element element : elements){
                System.out.println(element.getText());

            }


/*            elements.forEach(element -> {
                String code = element.attributeValue("code");
                String targetClass = element.attributeValue("class");

                if (code != null && !"".equals(code) && targetClass != null && !"".equals(targetClass)){
                    TransConfig.inboundMap.put(code , targetClass);
                }else {
                    LOGGER.error("解析inbound.xml文件出现错误，存在code，class为空的情况，请检查文件!!");
                    return;
                }
            });*/

        }catch (DocumentException e){
            e.printStackTrace();
        }



        String[] tables = new String[]{"IYEEKU_MACHINE_INFO","IYEEKU_MACHINE_ACCESS_MONITOR","PF_ACCESS_MONITOR","PF_ACCESS_MONITOR_SUM",
            "PF_ARCPWDHIST","PF_ARCSECURITY_STRATEGY","PF_ARCUSERAUTH","PF_AUDITLOG","PF_ONLINE","PF_RESURL","PF_SCHEDULE_TASK","PF_SCHEDULETASK_MONITOR",
            "PF_ROLE_STAFF","PF_ARCGRANT","PF_CODETYPE","PF_ROLE","PF_CODEINFO","PF_RESMENU","PF_STAFF","PF_RESRELATION"};

        long beginTime = System.currentTimeMillis();
        List<Map<String,Object>> data = DBUtil.getTablesConstructionData(tables);

        try {
            OutputStream out = new FileOutputStream("E:\\桌面文件\\IYEEKU系统表结构设计.xlsx");
            ExcelProcessUtil.exportTablesExcel(out,data);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("创建excel成功，耗时：" + df.format ((float)(endTime-beginTime)/1000) + "s");

    }

}