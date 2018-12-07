package com.iyeeku.watch.excel;

import java.util.List;

public class TableSheetVO {

    private TableVO tableVO;
    private List<ColumnVO> columnVOs;

    public TableVO getTableVO() {
        return tableVO;
    }

    public void setTableVO(TableVO tableVO) {
        this.tableVO = tableVO;
    }

    public List<ColumnVO> getColumnVOs() {
        return columnVOs;
    }

    public void setColumnVOs(List<ColumnVO> columnVOs) {
        this.columnVOs = columnVOs;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("表英文名：" + tableVO.getTableName() + " , 表中文名：" + tableVO.getTableComments() +"\n");
        sb.append("字段中文名\t字段英文名\t数据类型\t数据长度\t主键\t非空\n");
        for (ColumnVO vo : columnVOs){
            sb.append(vo.getComments()+ " , ")
                    .append(vo.getColumnName()==null?"":vo.getColumnName().toLowerCase() + " , ")
                    .append(vo.getDataType() + " , ")
                    .append(vo.getDataLength() + " , ")
                    .append(vo.getIsKey() + " , ")
                    .append(vo.getNullAble()+"\n");
        }
        return sb.toString();
    }

}
