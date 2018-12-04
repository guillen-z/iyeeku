package com.iyeeku.watch.client;

import com.iyeeku.watch.message.IyeekuRequestMessgae;

import java.io.*;
import java.net.Socket;

public class IyeekuCall {

    public static Serializable call(String code,Serializable request){

        Socket socket = null;
        OutputStream out = null;
        InputStream in = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        IyeekuRequestMessgae req_message = (IyeekuRequestMessgae) request;
        req_message.setCode(code);

        try {
            //1.建立连接
            socket = new Socket("localhost" , 6060);

            out = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(req_message);
            objectOutputStream.flush();

            //TODO 注意这里，如果这里关闭了 outputStream , 会导致 Socket write error错误
            //objectOutputStream.close();

            in = socket.getInputStream();
            objectInputStream = new ObjectInputStream(in);
            Serializable response = (Serializable) objectInputStream.readObject();

            return response;


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (objectInputStream != null)
                    objectInputStream.close();
                if (objectOutputStream != null)
                    objectOutputStream.close();
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return null;

    }

}
