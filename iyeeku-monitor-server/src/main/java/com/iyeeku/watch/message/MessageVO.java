package com.iyeeku.watch.message;

import java.io.Serializable;

/**
 * 通讯消息模板定义
 */
public class MessageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Req_Message req_message;      //请求消息
    private Resp_Message resp_message;    //响应消息
    private Exp_Message exp_message;      //异常消息

    public Req_Message getReq_message() {
        return req_message;
    }

    public void setReq_message(Req_Message req_message) {
        this.req_message = req_message;
    }

    public Resp_Message getResp_message() {
        return resp_message;
    }

    public void setResp_message(Resp_Message resp_message) {
        this.resp_message = resp_message;
    }

    public Exp_Message getExp_message() {
        return exp_message;
    }

    public void setExp_message(Exp_Message exp_message) {
        this.exp_message = exp_message;
    }

    /**   =========请求消息，响应消息，异常消息定义========   **/
    public static class Req_Message extends IyeekuRequestMessgae {

        private static final long serialVersionUID = 1L;

    }

    public static class Resp_Message extends IyeekuResponseMessage {

        private static final long serialVersionUID = 1L;

        //这里注意，集合返回使用类数组,eg：  Student[]

    }

    public static class Exp_Message extends IyeekuExceptionMessage {

        private static final long serialVersionUID = 1L;
        private String errCode; //错误代号
        private String errMsg;  //错误信息

        public String getErrCode() {
            return errCode;
        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

    }

}