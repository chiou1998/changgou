package com.changgou.goods.controller;
import com.changgou.goods.pojo.ContentCategory;
import com.changgou.goods.service.ContentCategoryService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.changgou.core.AbstractCoreController;

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
