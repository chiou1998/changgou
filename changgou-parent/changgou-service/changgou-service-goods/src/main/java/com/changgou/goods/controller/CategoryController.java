package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService  categoryService;

//    @Autowired
//    public CategoryController(CategoryService  categoryService) {
//        super(categoryService, Category.class);
//        this.categoryService = categoryService;
//    }

    @GetMapping("list/{pid}")
    public Result<List<Category>> findByParentId(@PathVariable(name = "pid") Integer pid){
        List<Category> categoryList = categoryService.findByParentId(pid);
        return new Result<List<Category>>(true, StatusCode.OK,"查询成功",categoryList);
    }
    @GetMapping("list2/{id}")
    public Result<Category> findById(@PathVariable(name = "id") Integer id){
        Category category = categoryService.findById1(id);
        return new Result<Category>(true, StatusCode.OK,"查询成功",category);
    }
}
