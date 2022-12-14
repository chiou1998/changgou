package com.changgou.seckill.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.seckill.dao.ContentMapper;
import com.changgou.seckill.pojo.Content;
import com.changgou.seckill.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Content业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ContentServiceImpl extends CoreServiceImpl<Content> implements ContentService {

    private ContentMapper contentMapper;

    @Autowired
    public ContentServiceImpl(ContentMapper contentMapper) {
        super(contentMapper, Content.class);
        this.contentMapper = contentMapper;
    }
}
