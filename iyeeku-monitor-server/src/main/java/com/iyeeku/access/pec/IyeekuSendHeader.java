package com.iyeeku.access.pec;

import java.io.Serializable;

public class IyeekuSendHeader implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jydh;

    public String getJydh() {
        return jydh;
    }

    public void setJydh(String jydh) {
        this.jydh = jydh;
    }

}
