package com.iyeeku.watch.message;

import java.io.Serializable;

public class IyeekuExceptionMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String expCode;
    private String expMsg;

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    public String getExpMsg() {
        return expMsg;
    }

    public void setExpMsg(String expMsg) {
        this.expMsg = expMsg;
    }

}
