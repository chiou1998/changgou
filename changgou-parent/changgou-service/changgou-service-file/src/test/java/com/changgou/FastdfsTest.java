package com.changgou;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FastdfsTest {
    //上传图片
    @Test
    public void upload() throws Exception{
        //1 创建一个配置文件 用于配置链接到tracker server的ip地址和端口
        //2 加载配置文件使其生效
        ClientGlobal.init("E:\\ideacode\\changgou\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //3 创建trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4 获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5 创建storageServer 赋值为空
        //6 创建stroageClient (提供了很多图片的操作的api)
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String[] jpgs = storageClient.upload_file("C:\\Users\\Reol\\Desktop\\Tx.jpg", "jpg", null);
        //7 执行上传图片
        for (String jpg : jpgs) {
            System.out.println(jpg);
        }
    }
    //下载图片
    @Test
    public void download() throws Exception{
        //1 创建一个配置文件 用于配置链接到tracker server的ip地址和端口
        //2 加载配置文件使其生效
        ClientGlobal.init("E:\\ideacode\\changgou\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //3 创建trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4 获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5 创建storageServer 赋值为空
        //6 创建stroageClient (提供了很多图片的操作的api)
        StorageClient storageClient = new StorageClient(trackerServer, null);
        byte[] group1s = storageClient.download_file("group1", "M00/00/00/wKjThGOGf-aAMAH4AAGkQas1m5M388.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\1234.jpg"));
        fileOutputStream.write(group1s);
    }
}
