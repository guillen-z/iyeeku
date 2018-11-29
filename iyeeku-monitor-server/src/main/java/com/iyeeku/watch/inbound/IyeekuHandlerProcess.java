package com.iyeeku.watch.inbound;

import java.io.Serializable;

public abstract interface IyeekuHandlerProcess {

    public abstract Serializable doExecute(Serializable request);



}
