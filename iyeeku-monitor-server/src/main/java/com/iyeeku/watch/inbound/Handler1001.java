package com.iyeeku.watch.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Handler1001 implements IyeekuHandlerProcess {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler1001.class);

    @Override
    public Serializable doExecute(Serializable request) {
        LOGGER.info("Handler1001 doExecute");

        return null;
    }


}
