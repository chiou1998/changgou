package com.changgou.seckill.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.seckill.pojo.Areas;
import com.changgou.seckill.service.AreasService;
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
@RequestMapping("/areas")
@CrossOrigin
public class AreasController extends AbstractCoreController<Areas>{

    private AreasService  areasService;

    @Autowired
    public AreasController(AreasService  areasService) {
        super(areasService, Areas.class);
        this.areasService = areasService;
    }
}