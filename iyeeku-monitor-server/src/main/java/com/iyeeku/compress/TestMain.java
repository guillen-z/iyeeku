package com.iyeeku.compress;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        //第一步：获取一个文件夹下的所有的文件
        List<File> files = file.getFiles("E:\\auto_Oracle\\tmp\\iyeeku04");
        List<File> sources = new ArrayList<>();
        for (File f : files){
            System.out.println(f.getName() + " , " + f.toURI());
            sources.add(f);
        }

        //第二步：把获取的文件下的文件压缩成一个tar文件 ，sources：要压缩的文件，target压缩的路径
        File target = new File("E:\\auto_Oracle\\iyeekuMonitor.tar");
        file.compress(GZIPUtil.pack(sources,target));

        try {

            //第三步把tar文件压缩成tar.gz文件也就是gzip文件，siuress:要压缩的tar文件，gzget：压缩后的gz文件
            String siuress = "E:\\auto_Oracle\\iyeekuMonitor.tar";

            String gzget = "E:\\auto_Oracle\\iyeekuMonitor.tar.gz";
            GZipUtils.compress(siuress, gzget);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
