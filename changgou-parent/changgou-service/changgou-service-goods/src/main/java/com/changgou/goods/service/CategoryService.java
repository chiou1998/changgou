package com.changgou.goods.service;

import com.changgou.goods.pojo.Category;

import java.util.List;

/****
 * @Author:admin
 * @Description:Category业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CategoryService{

    List<Category> findByParentId(Integer pid);

    Category findById1(Integer id);
}
