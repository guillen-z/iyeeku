package com.iyeeku.watch.utils;

public enum SystemResponseCode {

    ResponseCode("ResponseCode","响应码"),
    SuccessCode("00000","交易成功"),
    SystemException("19999","系统异常"),
    ServiceClose("10002","服务未启用"),
    SystemBusy("10003","系统繁忙"),
    RequiredFieldNull("10004","必填项不能为空"),
    DataFormatWrong("10005","数据格式错误"),
    SystemForbit("10006","该时间段系统禁止访问"),
    RequireFormatWrong("10007","请求报文格式不正常");

    private String codeInfo;
    private String desc;
    private SystemResponseCode(String codeInfo , String desc){
        this.codeInfo = codeInfo;
        this.desc = desc;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
