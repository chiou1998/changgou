package com.changgou.goods.dao;
import com.changgou.goods.pojo.Category;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:admin
 * @Description:CategoryDao
 * @Date 2019/6/14 0:12
 *****/
public interface CategoryMapper{
    List<Category> select(Integer pid);

    Integer selectByPrimaryKey(Integer id);
    Category select1(Integer id);
}
