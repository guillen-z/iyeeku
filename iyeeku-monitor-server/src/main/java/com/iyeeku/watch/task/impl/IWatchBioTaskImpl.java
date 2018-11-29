package com.iyeeku.watch.task.impl;

import com.iyeeku.watch.message.Message1000VO.Req_Message1000;
import com.iyeeku.watch.task.IWatchBioTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;

public class IWatchBioTaskImpl implements IWatchBioTask {

    public static Logger LOGGER = LoggerFactory.getLogger(IWatchBioTaskImpl.class);

    private Socket socket;

    public IWatchBioTaskImpl(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        LOGGER.info("开启新的线程...");
        try {
            InputStream in = this.socket.getInputStream();

            ObjectInputStream objectInputStream = new ObjectInputStream(in);

            try {

                Serializable response = (Serializable) objectInputStream.readObject();

                if (response instanceof Req_Message1000){
                    String code = ((Req_Message1000) response).getCode();
                    if (code == null || "".equals(code)){

                    }
                }

            }catch (ClassNotFoundException e){
                LOGGER.error("err 收到的客户端请求不能发序列化...");
                e.printStackTrace();
            }

        }catch (IOException e){
            LOGGER.error("err 获取输入流失败...");
            e.printStackTrace();
        }

    }

}
