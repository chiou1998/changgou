package com.changgou.user.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.user.pojo.FreightTemplate;
import com.changgou.user.service.FreightTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
