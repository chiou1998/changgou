package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.ContentCategoryMapper;
import com.changgou.goods.pojo.ContentCategory;
import com.changgou.goods.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:ContentCategory业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ContentCategoryServiceImpl extends CoreServiceImpl<ContentCategory> implements ContentCategoryService {

    private ContentCategoryMapper contentCategoryMapper;

    @Autowired
    public ContentCategoryServiceImpl(ContentCategoryMapper contentCategoryMapper) {
        super(contentCategoryMapper, ContentCategory.class);
        this.contentCategoryMapper = contentCategoryMapper;
    }
}
