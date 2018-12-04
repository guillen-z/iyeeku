package com.iyeeku.watch.task.impl;

import com.iyeeku.watch.inbound.IyeekuHandlerProcess;
import com.iyeeku.watch.message.IyeekuExceptionMessage;
import com.iyeeku.watch.message.IyeekuRequestMessgae;
import com.iyeeku.watch.message.IyeekuResponseMessage;
import com.iyeeku.watch.task.IWatchBioTask;
import com.iyeeku.watch.utils.ContextUtil;
import com.iyeeku.watch.utils.SystemResponseCode;
import com.iyeeku.watch.utils.TransConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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

        InputStream in = null;
        OutputStream out = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {

            //获取输入输出流
            in = this.socket.getInputStream();
            objectInputStream = new ObjectInputStream(in);

/*            out = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(response);
            objectOutputStream.flush();*/

            out = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(out);

            try {

                Serializable requestMsg = (Serializable) objectInputStream.readObject();

                if (requestMsg instanceof IyeekuRequestMessgae){
                    IyeekuRequestMessgae request = (IyeekuRequestMessgae)requestMsg;
                    String code = request.getCode();
                    if (code == null || "".equals(code)){

                        IyeekuResponseMessage response = new IyeekuResponseMessage();
                        response.setRespCode(SystemResponseCode.RequiredFieldNull.getCodeInfo());
                        response.setRespMsg(SystemResponseCode.RequiredFieldNull.getDesc());
                        objectOutputStream.writeObject(response);
                        objectOutputStream.flush();

                    } else {

                        String transClass = TransConfig.inboundMap.get(code);
                        if (transClass != null && !"".equals(transClass)){

                            Class T = Class.forName(transClass);
                            IyeekuHandlerProcess handler = (IyeekuHandlerProcess) ContextUtil.getBean(T);
                            //这里根据code分发到具体的handler中去处理
                            Serializable response =  handler.doExecute(request);
                            objectOutputStream.writeObject(response);
                            objectOutputStream.flush();

                        }else{

                            IyeekuResponseMessage response = new IyeekuResponseMessage();
                            response.setRespCode(SystemResponseCode.ServiceClose.getCodeInfo());
                            response.setRespMsg(SystemResponseCode.ServiceClose.getDesc());
                            objectOutputStream.writeObject(response);
                            objectOutputStream.flush();

                        }
                    }

                }else {

                    IyeekuResponseMessage response = new IyeekuResponseMessage();
                    response.setRespCode(SystemResponseCode.RequireFormatWrong.getCodeInfo());
                    response.setRespMsg(SystemResponseCode.RequireFormatWrong.getDesc());
                    objectOutputStream.writeObject(response);
                    objectOutputStream.flush();

                }

            }catch (ClassNotFoundException e){
                LOGGER.error("err 收到的客户端请求不能发序列化...");
                e.printStackTrace();

                IyeekuExceptionMessage exception = new IyeekuExceptionMessage();
                exception.setExpCode(SystemResponseCode.SystemException.getCodeInfo());
                exception.setExpMsg(e.getMessage());

                objectOutputStream.writeObject(exception);
                objectOutputStream.flush();

            }
        }catch (IOException e){
            LOGGER.error("err 获取输入流失败...");
            e.printStackTrace();
        }finally {
            try {
                if (objectOutputStream != null)
                    objectOutputStream.close();
                if (objectInputStream != null)
                    objectInputStream.close();
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            }catch (IOException e){
                LOGGER.error("关闭流出现异常!!");
                e.printStackTrace();
            }
        }
    }

}
