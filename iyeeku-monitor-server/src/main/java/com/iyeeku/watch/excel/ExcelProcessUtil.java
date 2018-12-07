package com.iyeeku.watch.excel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExcelProcessUtil {

    public static final String TABLENAME = "tableName";
    public static final String TABLECOMMENTS = "tableComments";

    public static final String SERNO = "serno";
    public static final String COLUMNCOMMENTS = "columnComments";
    public static final String COLUMNNAME = "columnName";
    public static final String DATATYPE = "dataType";
    public static final String DATALENGTH = "dataLength";
    public static final String ISKEY = "isKey";
    public static final String NULLABLE = "nullAble";
    public static final String CODEINFO = "codeinfo";
    public static final String REMARKS = "remarks";

    public static final String[] MODEL_TITLES = new String[]{"序号","字段中文名称","字段英文名称","数据类型","数据长度","主键","非空","数据字典","备注"};
    public static final String[] MODEL_COLUMNLENGTHS =  new String[]{"4","18","13","14","10","7","7","9","14"};
    public static final String[] MODEL_KEYS = new String[]{SERNO,COLUMNCOMMENTS,COLUMNNAME,DATATYPE,DATALENGTH,ISKEY,NULLABLE,CODEINFO,REMARKS};
    public static final HorizontalAlignment[] MODEL_ALIGMENT = new HorizontalAlignment[]{HorizontalAlignment.CENTER,HorizontalAlignment.LEFT,HorizontalAlignment.LEFT,
            HorizontalAlignment.LEFT,HorizontalAlignment.RIGHT,HorizontalAlignment.CENTER,HorizontalAlignment.CENTER,HorizontalAlignment.LEFT,HorizontalAlignment.LEFT};
    public static final CellType[] MODEL_CELLTYPE = new CellType[]{CellType.NUMERIC,CellType.STRING,CellType.STRING,CellType.STRING,CellType.NUMERIC,
            CellType.STRING,CellType.STRING,CellType.STRING,CellType.STRING};

    public static XSSFCellStyle getSimpleCellStyle(XSSFWorkbook wb , HorizontalAlignment alignment){
        return getCellStyle(wb , alignment , false , false , false , -1 , -1);
    }

    /**
     *
     * @param wb
     * @param alignment   水平对齐方式
     * @param bold          字体是否粗体
     * @param italic        字体是否斜体
     * @param underline     字体是否加下滑线
     * @param fontColor     字体颜色
     * @param fillForegroundColor   单元格填充色
     * @return
     */
    public static XSSFCellStyle getCellStyle(XSSFWorkbook wb , HorizontalAlignment alignment , boolean bold , boolean italic ,
            boolean underline , int fontColor , int fillForegroundColor){
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(alignment); //对齐方式
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  //垂直居中
        cellStyle.setBorderBottom(BorderStyle.THIN);  //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        if (fillForegroundColor != -1) {
            cellStyle.setFillForegroundColor((short) fillForegroundColor); //设置单元格填充色
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        //数据域单元格字体设置
        XSSFFont dataFont = wb.createFont();
        dataFont.setFontName("宋体");
        dataFont.setFontHeightInPoints((short) 10);
        if (bold == true) dataFont.setBold(true);
        if (italic == true) dataFont.setItalic(true);
        if (underline == true) dataFont.setUnderline(FontUnderline.valueOf(1));
        if (fontColor != -1) dataFont.setColor((short) fontColor);
        cellStyle.setFont(dataFont);
        return cellStyle;
    }

    public static void createCatalogueSheet(XSSFWorkbook wb,List<Map<String,Object>> data){
        int rowIndex = 0;
        int columnIndex = 0;
        XSSFSheet sheet = wb.createSheet("目录");

        //设置列宽
        sheet.setColumnWidth(0 , getColumnWidth(5));
        sheet.setColumnWidth(1 , getColumnWidth(27));
        sheet.setColumnWidth(2 , getColumnWidth(37));
        sheet.setColumnWidth(3 , getColumnWidth(40));

        XSSFRow titleRow = sheet.createRow(rowIndex++);
        String[] title = new String[]{"序号","表名","描述","备注"};
        for (String t : title){
            XSSFCell cell = titleRow.createCell(columnIndex++);
            XSSFCellStyle cellStyle = getCellStyle(wb , HorizontalAlignment.LEFT , true , false , false , -1 , 70);
            cell.setCellStyle(cellStyle);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(t);
        }
        for (int i = 0 , l = data.size() ; i < l ; i++){

            Map<String,Object> dataMap = data.get(i);

            if (dataMap == null || dataMap.get("tableData") == null || ((Map<String,String>)dataMap.get("tableData")).get(TABLENAME) == null){
                continue;
            }

            Map<String,String> tableMap = (Map<String,String>)dataMap.get("tableData");

            XSSFRow row = sheet.createRow(rowIndex++);
            XSSFCellStyle cellStyle0 = getSimpleCellStyle(wb , HorizontalAlignment.CENTER);
            XSSFCell cell0 = row.createCell(0);
            cell0.setCellType(CellType.NUMERIC);
            cell0.setCellStyle(cellStyle0);
            cell0.setCellValue(i+1);

            XSSFCellStyle linkStyle = getCellStyle(wb , HorizontalAlignment.LEFT , false , false , true , IndexedColors.BLUE.index , -1);

            CreationHelper creationHelper = wb.getCreationHelper();
            XSSFHyperlink hyperlink = (XSSFHyperlink) creationHelper.createHyperlink(HyperlinkType.URL);
            hyperlink.setAddress("#"+tableMap.get(TABLENAME)+"!A1");

            XSSFCell cell1 = row.createCell(1);
            cell1.setCellType(CellType.STRING);
            cell1.setCellStyle(linkStyle);
            cell1.setCellValue(tableMap.get(TABLENAME));
            cell1.setHyperlink(hyperlink);

            XSSFCellStyle cellStyle = getSimpleCellStyle(wb , HorizontalAlignment.LEFT);

            XSSFCell cell2 = row.createCell(2);
            cell2.setCellType(CellType.STRING);
            cell2.setCellStyle(cellStyle);
            cell2.setCellValue(tableMap.get(TABLECOMMENTS));

            XSSFCell cell3 = row.createCell(3);
            cell3.setCellType(CellType.STRING);
            cell3.setCellStyle(cellStyle);
            cell3.setCellValue("");

        }

    }

    public static void exportTablesExcel(OutputStream out , List<Map<String,Object>> data){

        XSSFWorkbook wb = new XSSFWorkbook();

        //创建封面页
        XSSFSheet sheet0 = wb.createSheet("封面");

        //创建目录页
        createCatalogueSheet(wb,data);

        // 创建每页数据库表结构展示的具体页面
        for (Map<String,Object> dataMap : data){

            if (dataMap.get("tableData")  == null || ((Map)dataMap.get("tableData")).get(TABLENAME) == null){
                continue;
            }

            Map<String,String> tableMap = (Map<String,String>)dataMap.get("tableData");
            //创建sheet页面
            XSSFSheet sheet = wb.createSheet(tableMap.get(TABLENAME));
            //设置列宽
            for (int columnIndex  = 0 , l = MODEL_COLUMNLENGTHS.length ; columnIndex < l ; columnIndex++ ){
                sheet.setColumnWidth(columnIndex , getColumnWidth(Integer.valueOf(MODEL_COLUMNLENGTHS[columnIndex])));
            }

            if (dataMap.get("columnData") == null || ((List)dataMap.get("columnData")).size() == 0){
                continue;
            }

            int rowIndex = 0;
            XSSFRow headRow = sheet.createRow(rowIndex++);//创建头行

            XSSFCellStyle headStyle = getCellStyle(wb , HorizontalAlignment.CENTER , true , false , false , IndexedColors.WHITE.index , 70);

            XSSFCell headCell = headRow.createCell(0);
            headCell.setCellValue(tableMap.get(TABLECOMMENTS) + "（"+ tableMap.get(TABLENAME) +"）");
            headCell.setCellStyle(headStyle);
            CellRangeAddress region = new CellRangeAddress(0,0,0,8);
            sheet.addMergedRegion(region);

            CreationHelper creationHelper = wb.getCreationHelper();
            XSSFHyperlink hyperlink = (XSSFHyperlink) creationHelper.createHyperlink(HyperlinkType.URL);
            hyperlink.setAddress("#目录!A1");

            XSSFCellStyle linkStyle = getCellStyle(wb , HorizontalAlignment.CENTER , true , false , false ,IndexedColors.WHITE.index ,53);
            linkStyle.setBorderBottom(BorderStyle.NONE);//去掉边框
            //linkStyle.setBorderLeft(BorderStyle.NONE);
            linkStyle.setBorderRight(BorderStyle.NONE);
            linkStyle.setBorderTop(BorderStyle.NONE);
            linkStyle.getFont().setFontHeightInPoints((short) 12);

            XSSFCell returnCell = headRow.createCell(9);
            returnCell.setCellStyle(linkStyle);
            returnCell.setCellValue("返回");
            returnCell.setHyperlink(hyperlink);
            CellRangeAddress ReturnRegion = new CellRangeAddress(0,1,9,9);
            sheet.addMergedRegion(ReturnRegion);

            XSSFRow titleRow = sheet.createRow(rowIndex++);//创建标题行
            XSSFCellStyle titleStyle = getCellStyle(wb , HorizontalAlignment.LEFT , true , false , false , -1 ,70);
            for (int titleIndex = 0 , l = MODEL_TITLES.length ; titleIndex < l ; titleIndex++){
                XSSFCell cell = titleRow.createCell(titleIndex);
                cell.setCellType(CellType.STRING);
                cell.setCellStyle(titleStyle);
                cell.setCellValue(MODEL_TITLES[titleIndex]);
            }

            List<Map<String,String>> columnList = (List<Map<String, String>>) dataMap.get("columnData");

            for (int i = 0 , l = columnList.size() ; i < l ; i ++){

                Map<String,String> columnMap = columnList.get(i);
                XSSFRow row = sheet.createRow(rowIndex++);

                int columnIndex = 0;
                for (String key : MODEL_KEYS){
                    XSSFCell cell = row.createCell(columnIndex++);
                    XSSFCellStyle cellStyle = getSimpleCellStyle(wb , MODEL_ALIGMENT[columnIndex-1]);
                    cell.setCellType(MODEL_CELLTYPE[columnIndex-1]);
                    cell.setCellStyle(cellStyle);
                    if (columnIndex == 1 || columnIndex == 5){
                        cell.setCellValue(Integer.valueOf(columnMap.get(key)));
                    }else {
                        cell.setCellValue(columnMap.get(key));
                    }
                }
            }
        }

        try {
            //把构建好的Workbook输出到本地
            wb.write(out);
            wb.close();
        }catch (Exception e){
            System.err.println("输出excel文件出错...");
            e.printStackTrace();
        }
    }

    /**
     * 计算列宽
     * @param num
     * @return
     */
    private static int getColumnWidth(int num){
        return 256 * num + 184;
    }


}
