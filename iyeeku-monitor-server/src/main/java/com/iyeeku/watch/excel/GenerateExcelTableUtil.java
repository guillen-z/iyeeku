package com.iyeeku.watch.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class GenerateExcelTableUtil {

    public static void main(String[] args) {

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