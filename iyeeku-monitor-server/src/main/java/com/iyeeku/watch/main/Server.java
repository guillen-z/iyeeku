package com.iyeeku.watch.main;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    public interface ObjectAction{
        public Object doAction(Object rev,Server server);
    }

    public static final class DefaultObjectAction implements ObjectAction{
        @Override
        public Object doAction(Object rev, Server server) {
            System.out.println("处理并返回：" + rev);
            return rev;
        }
    }


    private int port;
    private volatile boolean running = false;
    private long receiveTimeDelay = 3000;
    private ConcurrentHashMap<Class,ObjectAction> actionConcurrentHashMap = new ConcurrentHashMap<>();
    private Thread connWatchDog;

    public Server(int port){
        this.port = port;
    }

    public void start(){
        if (running) return;
        running = true;
        connWatchDog = new Thread(new ConnWatchDog());
        connWatchDog.start();
    }

    public void stop(){
        if (running) running = false;
        if (connWatchDog != null)
            connWatchDog.stop();
    }



    class ConnWatchDog implements Runnable{
        @Override
        public void run() {
            try {
                ServerSocket ss = new ServerSocket(port,2018);
                while (running){
                    Socket s = ss.accept();
                    new Thread(new SocketAction(s)).start();
                }
            }catch (IOException e){
                e.printStackTrace();
                Server.this.stop();
            }
        }
    }

    class SocketAction implements Runnable{
        Socket socket;
        boolean run = true;
        long lastReceiveTime = System.currentTimeMillis();

        public SocketAction(Socket s){
            this.socket = s;
        }

        @Override
        public void run() {
            while (running && run){
                if (System.currentTimeMillis() - lastReceiveTime > receiveTimeDelay){
                    overThis();
                }else {

                    try {
                        InputStream in = socket.getInputStream();
                        if (in.available()>0){
                            ObjectInputStream ois = new ObjectInputStream(in);
                            Object obj = ois.readObject();
                            lastReceiveTime = System.currentTimeMillis();
                            System.out.println("接收：\t"+obj);
                            //ObjectAction oa = actionMapping.get(obj.getClass());
                        }else {
                            Thread.sleep(10);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }

        public void overThis(){
            if (run) run = false;
            try {
                if (socket!=null) socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("关闭：" + socket.getRemoteSocketAddress());
        }
    }




}
