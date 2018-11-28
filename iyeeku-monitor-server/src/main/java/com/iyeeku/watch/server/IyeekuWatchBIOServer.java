package com.iyeeku.watch.server;

import com.iyeeku.watch.service.MachineInfoService;
import com.iyeeku.watch.task.IWatchBioTask;
import com.iyeeku.watch.task.impl.IWatchBioTaskImpl;
import com.iyeeku.watch.utils.ContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IyeekuWatchBIOServer {

    public static Logger logger = LoggerFactory.getLogger(IyeekuWatchBIOServer.class);
    private volatile boolean running = false;

    private MachineInfoService machineInfoService = (MachineInfoService)ContextUtil.getBean(MachineInfoService.BEANID);

    public void start(){

        if (running){
            return;
        }

        //设置线程池
        final ThreadGroup threadGroup = new ThreadGroup(Thread.currentThread().getThreadGroup(),"Transaction");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize , maximunPoolSize , keepAliveTime ,
                TimeUnit.SECONDS , new ArrayBlockingQueue<Runnable>(QueueSize) , new ThreadPoolExecutor.AbortPolicy());
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(threadGroup , r , r.getClass().getSimpleName());
            }
        };

        executor.setThreadFactory(factory);

        try {
            server = new ServerSocket(port);
            running = true;
            logger.info("服务器启动成功并开始监听" + port + "端口...");
        }catch (IOException e){
            logger.error("端口" + port + "被占用...");
            e.printStackTrace();
        }

        Socket socket;

        while (running){
            try {
                socket = server.accept();
                socket.setSoTimeout(1000*iTimeOutSeconds);
                IWatchBioTask task = new IWatchBioTaskImpl(socket,machineInfoService);
                executor.execute(task);
            }catch (Exception ex){
                ex.printStackTrace();
                logger.error("出现异常，整个服务器停止!" , ex.getMessage());
                try {
                    server.close();
                }catch (Exception e){
                    logger.error("服务关闭出现异常!" , e.getMessage());
                }
                running = false;
                break;
            }
        }

    }


    private static int port = 6060;
    private static int corePoolSize = 1024;
    private static int maximunPoolSize = 4096;
    private static int QueueSize = 50;
    private static long keepAliveTime = 5;
    private static int iTimeOutSeconds = 60 * 10;
    private static ServerSocket server = null;

}
