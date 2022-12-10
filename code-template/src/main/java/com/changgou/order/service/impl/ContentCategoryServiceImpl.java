package com.changgou.order.service.impl;
import com.changgou.order.dao.ContentCategoryMapper;
import com.changgou.order.pojo.ContentCategory;
import com.changgou.order.service.ContentCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import com.changgou.core.service.impl.CoreServiceImpl;
import java.util.List;
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
