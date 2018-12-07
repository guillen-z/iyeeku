package com.iyeeku.watch.excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DBUtil {

    private static String driverClass = "oracle.jdbc.driver.OracleDriver";
    private static String jdbcUrl = "jdbc:oracle:thin:@139.224.119.226:1521:ORCL";
    private static String user = "c##iyeekudev";
    private static String password = "iyeekudev";

    private static final String tableSql = "select * from user_tab_comments where table_name = ?";
    private static final String columnsSql = "select  c.COMMENTS,t.COLUMN_NAME,t.DATA_TYPE,t.DATA_LENGTH,t.NULLABLE\n" +
            "from user_tab_columns  t,user_col_comments c\n" +
            "where t.table_name = c.table_name and t.column_name = c.column_name and t.table_name = ?\n" +
            "order by t.COLUMN_ID";

    static {
        try{
            Properties properties = new Properties();
            String dbPath = DBUtil.class.getClassLoader().getResource("com/iyeeku/watch/excel/db.properties").getPath();
            InputStream inputStream = new FileInputStream(dbPath);
            properties.load(inputStream);
            driverClass = properties.getProperty("driverClass");
            jdbcUrl = properties.getProperty("jdbcUrl");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        }catch (Exception e){
            System.err.println("读取链接数据库配置文件失败，请检查路径是否正确！！！");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(driverClass);

            Properties props = new Properties();
            props.put("user" , user);
            props.put("password" , password);
            props.put("remarksReporting" , "true"); //Oracle在通过jdbc连接的时候需要添加一个参数来设置是否获取注释
            //conn = DriverManager.getConnection(jdbcUrl , user , password);
            conn = DriverManager.getConnection(jdbcUrl ,props);
        }catch (ClassNotFoundException e){
            System.err.println("未找到链接数据的驱动");
            e.printStackTrace();
        }catch (SQLException e1){
            System.err.println("获取数据库链接Connection失败!!");
            e1.printStackTrace();
        }
        return conn;
    }

    public static List<Map<String,Object>> getTablesConstructionData(String... tables){
        List<Map<String,Object>> rtnList = new ArrayList<>();
        Map<String,String> tableMap = null;
        Map<String,String> columnMap = null;
        List<Map<String,String>> columnList = null;
        Map<String,Object> rtnMap = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        try {
            for (String table : tables){
                rtnMap = new HashMap<>();
                pstm = conn.prepareStatement(tableSql);
                pstm.setString(1, table);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    tableMap = new HashMap<>();
                    tableMap.put(ExcelProcessUtil.TABLENAME , rs.getString("TABLE_NAME"));
                    tableMap.put(ExcelProcessUtil.TABLECOMMENTS , rs.getString("COMMENTS"));
                    break;
                }

                columnList = new ArrayList<>();
                int serinoIndex = 0;
                pstm = conn.prepareStatement(columnsSql);
                pstm.setString(1, table);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    columnMap = new HashMap<>();
                    columnMap.put(ExcelProcessUtil.SERNO , String.valueOf(++serinoIndex));
                    columnMap.put(ExcelProcessUtil.COLUMNCOMMENTS , rs.getString("COMMENTS"));
                    columnMap.put(ExcelProcessUtil.COLUMNNAME , rs.getString("COLUMN_NAME") == null ? "" : rs.getString("COLUMN_NAME").toLowerCase());
                    columnMap.put(ExcelProcessUtil.DATATYPE , rs.getString("DATA_TYPE"));
                    columnMap.put(ExcelProcessUtil.DATALENGTH , rs.getString("DATA_LENGTH"));
                    columnMap.put(ExcelProcessUtil.ISKEY , "");
                    columnMap.put(ExcelProcessUtil.NULLABLE , rs.getString("NULLABLE"));
                    columnMap.put(ExcelProcessUtil.CODEINFO , "");
                    columnMap.put(ExcelProcessUtil.REMARKS , "");
                    columnList.add(columnMap);
                }
                rtnMap.put("tableData" , tableMap);
                rtnMap.put("columnData" , columnList);
                rtnList.add(rtnMap);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rtnList;
    }

}
