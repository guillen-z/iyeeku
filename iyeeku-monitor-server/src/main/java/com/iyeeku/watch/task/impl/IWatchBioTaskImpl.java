package com.iyeeku.watch.task.impl;

import com.iyeeku.watch.message.Message1000VO;
import com.iyeeku.watch.service.MachineInfoService;
import com.iyeeku.watch.task.IWatchBioTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class IWatchBioTaskImpl implements IWatchBioTask {

    public static Logger logger = LoggerFactory.getLogger(IWatchBioTaskImpl.class);

    private Socket socket;
    private MachineInfoService machineInfoService;

    public IWatchBioTaskImpl(Socket socket,MachineInfoService machineInfoService){
        this.socket = socket;
        this.machineInfoService = machineInfoService;
    }

    @Override
    public void run() {
        logger.info("开启新的线程...");
        try {
            InputStream in = this.socket.getInputStream();

            ObjectInputStream objectInputStream = new ObjectInputStream(in);

            try {
                Message1000VO message = (Message1000VO)objectInputStream.readObject();

                System.out.println(message.getReq_message1000().getCode());

            }catch (ClassNotFoundException e){
                logger.error("err 收到的客户端请求不能发序列化...");
            }
        }catch (IOException e){
            logger.error("err 获取输入流失败...");
            e.printStackTrace();
        }

    }

}
