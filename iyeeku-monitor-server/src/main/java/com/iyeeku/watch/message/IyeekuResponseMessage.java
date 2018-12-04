package com.iyeeku.watch.message;

import java.io.Serializable;

public class IyeekuResponseMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String respCode;
    private String respMsg;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

}
