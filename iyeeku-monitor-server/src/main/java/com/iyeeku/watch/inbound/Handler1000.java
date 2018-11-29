package com.iyeeku.watch.inbound;

import com.iyeeku.watch.service.MachineInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Handler1000 implements IyeekuHandlerProcess {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler1000.class);

    @Autowired
    private MachineInfoService machineInfoService;

    @Override
    public Serializable doExecute(Serializable request) {
        LOGGER.info("Handler1000 doExecute");

        int count = machineInfoService.findMachineInfosCount(null);
        System.out.println(count);

        return null;



    }


}
