package com.changgou.goods.service.impl;
import com.changgou.goods.dao.CategoryBrandMapper;
import com.changgou.goods.pojo.CategoryBrand;
import com.changgou.goods.service.CategoryBrandService;
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
