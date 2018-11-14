package com.iyeeku.monitor.util;

public class MessageVO{

    private String msgCode;
    private Object msgText;

    public MessageVO(){}

    public MessageVO(String msgCode){
        this.msgCode = msgCode;
    }

    public MessageVO(String msgCode , String msgText){
        this.msgCode = msgCode;
        this.msgText = msgText;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public Object getMsgText() {
        return msgText;
    }

    public void setMsgText(Object msgText) {
        this.msgText = msgText;
    }

}
