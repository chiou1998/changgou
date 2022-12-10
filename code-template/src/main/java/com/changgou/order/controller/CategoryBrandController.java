package com.changgou.order.controller;
import com.changgou.order.pojo.CategoryBrand;
import com.changgou.order.service.CategoryBrandService;
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
@RequestMapping("/categoryBrand")
@CrossOrigin
public class CategoryBrandController extends AbstractCoreController<CategoryBrand>{

    private CategoryBrandService  categoryBrandService;

    @Autowired
    public CategoryBrandController(CategoryBrandService  categoryBrandService) {
        super(categoryBrandService, CategoryBrand.class);
        this.categoryBrandService = categoryBrandService;
    }
}
