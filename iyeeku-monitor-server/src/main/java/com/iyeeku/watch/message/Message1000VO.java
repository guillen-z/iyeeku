package com.iyeeku.watch.message;

import java.io.Serializable;

public class Message1000VO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Req_Message1000 req_message1000;
    private Resp_Message1000 resp_message1000;
    private Exp_Message1000 exp_message1000;

    public Req_Message1000 getReq_message1000() {
        return req_message1000;
    }

    public void setReq_message1000(Req_Message1000 req_message1000) {
        this.req_message1000 = req_message1000;
    }

    public Resp_Message1000 getResp_message1000() {
        return resp_message1000;
    }

    public void setResp_message1000(Resp_Message1000 resp_message1000) {
        this.resp_message1000 = resp_message1000;
    }

    public Exp_Message1000 getExp_message1000() {
        return exp_message1000;
    }

    public void setExp_message1000(Exp_Message1000 exp_message1000) {
        this.exp_message1000 = exp_message1000;
    }

    public static class Req_Message1000 implements Serializable{
        private static final long serialVersionUID = 1L;

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class Resp_Message1000 implements Serializable{
        private static final long serialVersionUID = 1L;
    }

    public static class Exp_Message1000 implements Serializable{
        private static final long serialVersionUID = 1L;

    }

}
