package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryReportMapper;
import com.changgou.goods.pojo.CategoryReport;
import com.changgou.goods.service.CategoryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:CategoryReport业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CategoryReportServiceImpl extends CoreServiceImpl<CategoryReport> implements CategoryReportService {

    private CategoryReportMapper categoryReportMapper;

    @Autowired
    public CategoryReportServiceImpl(CategoryReportMapper categoryReportMapper) {
        super(categoryReportMapper, CategoryReport.class);
        this.categoryReportMapper = categoryReportMapper;
    }
}
