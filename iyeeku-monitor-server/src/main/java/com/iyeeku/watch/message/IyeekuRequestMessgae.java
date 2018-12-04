package com.iyeeku.watch.message;

import java.io.Serializable;

public class IyeekuRequestMessgae implements Serializable {

    private static final long serialVersionUID = 1L;

    public String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
