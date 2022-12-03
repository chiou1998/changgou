package com.changgou.goods.controller;
import com.changgou.goods.pojo.FreightTemplate;
import com.changgou.goods.service.FreightTemplateService;
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
@RequestMapping("/freightTemplate")
@CrossOrigin
public class FreightTemplateController extends AbstractCoreController<FreightTemplate>{

    private FreightTemplateService  freightTemplateService;

    @Autowired
    public FreightTemplateController(FreightTemplateService  freightTemplateService) {
        super(freightTemplateService, FreightTemplate.class);
        this.freightTemplateService = freightTemplateService;
    }
}
