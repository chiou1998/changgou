package com.changgou.order.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.order.pojo.ContentCategory;
import com.changgou.order.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/contentCategory")
@CrossOrigin
public class ContentCategoryController extends AbstractCoreController<ContentCategory>{

    private ContentCategoryService  contentCategoryService;

    @Autowired
    public ContentCategoryController(ContentCategoryService  contentCategoryService) {
        super(contentCategoryService, ContentCategory.class);
        this.contentCategoryService = contentCategoryService;
    }
}
