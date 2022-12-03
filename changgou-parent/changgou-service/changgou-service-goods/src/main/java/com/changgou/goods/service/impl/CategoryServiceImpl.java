package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:Category业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

//    @Autowired
//    public CategoryServiceImpl(CategoryMapper categoryMapper) {
//        super(categoryMapper, Category.class);
//        this.categoryMapper = categoryMapper;
//    }

    @Override
    public List<Category> findByParentId(Integer pid) {
        List<Category> categoryList = categoryMapper.select(pid);
        return categoryList;
    }

    @Override
    public Category findById1(Integer id) {
        Category category = categoryMapper.select1(id);
        return category;
    }

}
