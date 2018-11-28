package com.iyeeku.watch.client;

import com.iyeeku.watch.message.Message1000VO;
import com.iyeeku.watch.message.Message1000VO.Req_Message1000;

import java.io.*;
import java.net.Socket;

public class BioServerClient {

    private static String hostname = "localhost";
    //private static String hostname = "www.iyeeku.com";
    private static int port = 6060;

    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private ObjectOutputStream objOut = null;


    /**
     * 发送心跳包，30秒发送心跳包，保持链接有效
     */
    public void sendHeartBeat(){
        Req_Message1000 req_message1000 = new Req_Message1000();
        req_message1000.setCode("0110");
        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(30*1000); //30秒发送一次心跳
                    objOut = new ObjectOutputStream(out);
                    objOut.writeObject(req_message1000);
                    objOut.flush();
                    objOut.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private class ConnectSocketThread implements Runnable{

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            sendHeartBeat(); //发送心跳检测
            while (true){
                try {
                    if (socket == null || socket.isClosed()) {
                        socket = new Socket(hostname, port); //连接远程socket
                        out = socket.getOutputStream();
                    }
                    Thread.sleep(100);
                    in = socket.getInputStream();
                    int size = in.available();
                    if (size <= 0){
                        //这里约定，如果30秒没有收到服务器发回来的信息，说明socket连接可能已经被远程服务器关闭
                        if ((System.currentTimeMillis() - startTime) > 3 * 10 * 1000){
                            socket.close(); // 这里可以关闭socket链接了
                            startTime = System.currentTimeMillis();
                        }
                        continue;
                    }else {
                        startTime = System.currentTimeMillis();
                    }
                    ObjectInputStream objectInputStream = new ObjectInputStream(in);
                    Serializable response = (Serializable) objectInputStream.readObject();
                    if (response instanceof Message1000VO.Resp_Message1000){

                    }

                    if (response instanceof Message1000VO.Exp_Message1000){

                    }

                }catch (Exception e) {
                    e.printStackTrace();
                    try {
                        socket.close();

                    }catch (IOException e1){
                        e1.printStackTrace();
                    }
                }

            }

        }

    }


    public static void main(String[] args) {

        try {
            //1.建立连接
            Socket socket = new Socket(hostname , port);

            //Message1000VO message = new Message1000VO();
            Req_Message1000 req_message1000 = new Req_Message1000();
            req_message1000.setCode("1000");
            //message.setReq_message1000(req_message1000);

            OutputStream out = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

            objectOutputStream.writeObject(req_message1000);
            objectOutputStream.flush();
            objectOutputStream.close();

            InputStream in = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(in);

            Serializable response = (Serializable) objectInputStream.readObject();
            if (response instanceof Message1000VO.Resp_Message1000){


            }

            if (response instanceof Message1000VO.Exp_Message1000){


            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
