package com.changgou.goods.controller;
import com.changgou.goods.pojo.CategoryReport;
import com.changgou.goods.service.CategoryReportService;
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
@RequestMapping("/categoryReport")
@CrossOrigin
public class CategoryReportController extends AbstractCoreController<CategoryReport>{

    private CategoryReportService  categoryReportService;

    @Autowired
    public CategoryReportController(CategoryReportService  categoryReportService) {
        super(categoryReportService, CategoryReport.class);
        this.categoryReportService = categoryReportService;
    }
}
