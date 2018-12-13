package com.iyeeku.watch.inbound;

import com.iyeeku.ext.dubboRemote.IDubboRemoteService;
import com.iyeeku.watch.message.Message1000VO;
import com.iyeeku.watch.service.MachineInfoService;
import com.iyeeku.watch.utils.SystemResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

@Component
public class Handler1000 implements IyeekuHandlerProcess {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler1000.class);

    @Autowired
    private MachineInfoService machineInfoService;

    @Resource(name = "demoService")
    private IDubboRemoteService iDubboRemoteService;

    @Override
    public Serializable doExecute(Serializable request) {
        LOGGER.info("Handler1000 doExecute");

        Message1000VO.Req_Message1000 reqMessage = (Message1000VO.Req_Message1000) request;

        System.out.println(reqMessage.getName());
        int count = 0;
        try {
            count = machineInfoService.findMachineInfosCount(null);
            System.out.println("count ==>> " + count);
            //int a = 1/

            iDubboRemoteService.sayHello();

        }catch (Exception e){
            e.printStackTrace();

            Message1000VO.Exp_Message1000 exception = new Message1000VO.Exp_Message1000();
            exception.setExpCode(SystemResponseCode.SystemException.getCodeInfo());
            exception.setExpMsg(e.getMessage());
            return exception;

        }

        Message1000VO.Resp_Message1000 response = new Message1000VO.Resp_Message1000();
        response.setRespCode(SystemResponseCode.SuccessCode.getCodeInfo());
        response.setRespMsg(SystemResponseCode.SuccessCode.getDesc());
        response.setCount(count);
        return response;


    }


}
