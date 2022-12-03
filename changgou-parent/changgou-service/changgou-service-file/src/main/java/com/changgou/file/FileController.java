package com.changgou.file;

import com.changgou.file.util.FastDFSClicent;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
    @Value("${pic.url}")
    private String picPath;

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws Exception{
        if(!file.isEmpty()){
            //获取文件本身的字节数组
            byte[] bytes = file.getBytes();
            //获取文件的名称以及后缀
            String originalFilename = file.getOriginalFilename();
            //上传到fastadfs
            String[] upload = FastDFSClicent.upload(new FastDFSFile(originalFilename,bytes, StringUtils.getFilenameExtension(originalFilename)));
            //拼接url
            String realPath = picPath+"/"+upload[0]+"/"+ upload[1];
            //返回url给页面
            return realPath;
        }
        return null;
    }
}
