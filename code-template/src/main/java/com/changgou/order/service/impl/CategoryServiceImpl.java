package com.changgou.order.service.impl;
import com.changgou.order.dao.CategoryMapper;
import com.changgou.order.pojo.Category;
import com.changgou.order.service.CategoryService;
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
 * @Description:Category业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CategoryServiceImpl extends CoreServiceImpl<Category> implements CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        super(categoryMapper, Category.class);
        this.categoryMapper = categoryMapper;
    }
}
