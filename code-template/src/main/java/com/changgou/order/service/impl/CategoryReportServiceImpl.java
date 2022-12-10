package com.changgou.order.service.impl;
import com.changgou.order.dao.CategoryReportMapper;
import com.changgou.order.pojo.CategoryReport;
import com.changgou.order.service.CategoryReportService;
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
