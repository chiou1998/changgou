package com.changgou.file.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FastDFSClicent {
    static {
        //2 加载配置文件使其生效
        try {
            ClassPathResource classPathResource = new ClassPathResource("fdfs_client.conf");
            ClientGlobal.init(classPathResource.getPath());
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    //上传图片
    public static String[] upload(FastDFSFile file) throws MyException, IOException {
        //3 创建trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4 获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5 创建storageServer 赋值为空
        //6 创建stroageClient (提供了很多图片的操作的api)
        StorageClient storageClient = new StorageClient(trackerServer, null);
        NameValuePair[] meta_list = new NameValuePair[]{
                new NameValuePair(file.getName())
        };
        String[] jpgs = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        //7 执行上传图片
        return jpgs;
    }

    //下载图片
    public static byte[] downFile(String groupName,String remoteFileName) throws Exception{
        //3 创建trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4 获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5 创建storageServer 赋值为空
        //6 创建stroageClient (提供了很多图片的操作的api)
        StorageClient storageClient = new StorageClient(trackerServer, null);
        byte[] group1s = storageClient.download_file(groupName, remoteFileName);
        return group1s;
    }

    //删除图片
    //下载图片
    public static boolean deleteFile(String groupName,String remoteFileName) throws Exception{
        //3 创建trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4 获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5 创建storageServer 赋值为空
        //6 创建stroageClient (提供了很多图片的操作的api)
        StorageClient storageClient = new StorageClient(trackerServer, null);
        int i = storageClient.delete_file(groupName, remoteFileName);
        return i==0;
    }
}
