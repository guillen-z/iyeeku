package com.iyeeku.compress;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import java.io.*;

public class MIN {

    public static void main(String[] args) throws Exception {

        if (args == null || args.length == 0){
            System.out.println("【压缩文件夹内所有文件】：任务参数不能为空！");
            return;
        }

        if (args.length == 1){

            String archivePath = args[0];

            if (archivePath != null && !"".equals(archivePath)){
                if (archivePath.indexOf("E:\\auto_Oracle\\tmp") != -1){

                    String tarFile = archive(archivePath);

                    if (tarFile != null && !"".equals(tarFile)){
                        System.out.println(tarFile + "文件创建成功!");

                        String gzFile = compressArchive(tarFile);

                        if (gzFile != null && !"".equals(gzFile)){
                            System.out.println(gzFile + "文件创建成功!");
                        }else {
                            System.out.println("【压缩文件夹内所有文件】：gz压缩失败");
                        }
                    }else {
                        System.out.println("【压缩文件夹内所有文件】：tar压缩失败");
                    }
                }else {
                    System.out.println("【压缩文件夹内所有文件】：只能压缩E:\\auto_Oracle\\tmp目录下的莫个文件夹里面的所有文件");
                }
            }
        }else {
            System.out.println("【压缩文件夹内所有文件】：参数格式不对！");
        }

    }

    /**
     * 归档
     * @param entry
     * @throws IOException
     * @author yutao
     * @return
     * @date 2017年5月27日下午1:48:23
     */
    private static String archive(String entry) throws IOException {
        File file = new File(entry);

        TarArchiveOutputStream tos = new TarArchiveOutputStream(new FileOutputStream(file.getAbsolutePath() + ".tar"));
        String base = file.getName();
        if(file.isDirectory()){
            archiveDir(file, tos, base);
        }else{
            archiveHandle(tos, file, base);
        }

        tos.close();
        return file.getAbsolutePath() + ".tar";
    }

    /**
     * 递归处理，准备好路径
     * @param file
     * @param tos
     * @param basePath
     * @throws IOException
     * @author yutao
     * @date 2017年5月27日下午1:48:40
     */
    private static void archiveDir(File file, TarArchiveOutputStream tos, String basePath) throws IOException {
        File[] listFiles = file.listFiles();
        for(File fi : listFiles){
            if(fi.isDirectory()){
                archiveDir(fi, tos, basePath + File.separator + fi.getName());
            }else{
                archiveHandle(tos, fi, basePath);
            }
        }
    }

    /**
     * 具体归档处理（文件）
     * @param tos
     * @param fi
     * @param basePath
     * @throws IOException
     * @author yutao
     * @date 2017年5月27日下午1:48:56
     */
    private static void archiveHandle(TarArchiveOutputStream tos, File fi, String basePath) throws IOException {
        TarArchiveEntry tEntry = new TarArchiveEntry(basePath + File.separator + fi.getName());
        tEntry.setSize(fi.length());

        tos.putArchiveEntry(tEntry);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fi));

        byte[] buffer = new byte[1024];
        int read = -1;
        while((read = bis.read(buffer)) != -1){
            tos.write(buffer, 0 , read);
        }
        bis.close();
        tos.closeArchiveEntry();//这里必须写，否则会失败
    }



    /**
     * 把tar包压缩成gz
     * @param path
     * @throws IOException
     * @author yutao
     * @return
     * @date 2017年5月27日下午2:08:37
     */
    public static String compressArchive(String path) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));

        GzipCompressorOutputStream gcos = new GzipCompressorOutputStream(new BufferedOutputStream(new FileOutputStream(path + ".gz")));

        byte[] buffer = new byte[1024];
        int read = -1;
        while((read = bis.read(buffer)) != -1){
            gcos.write(buffer, 0, read);
        }
        gcos.close();
        bis.close();
        return path + ".gz";
    }

}
