package com.changgou.user.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.user.dao.CategoryBrandMapper;
import com.changgou.user.pojo.CategoryBrand;
import com.changgou.user.service.CategoryBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:CategoryBrand业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CategoryBrandServiceImpl extends CoreServiceImpl<CategoryBrand> implements CategoryBrandService {

    private CategoryBrandMapper categoryBrandMapper;

    @Autowired
    public CategoryBrandServiceImpl(CategoryBrandMapper categoryBrandMapper) {
        super(categoryBrandMapper, CategoryBrand.class);
        this.categoryBrandMapper = categoryBrandMapper;
    }
}
