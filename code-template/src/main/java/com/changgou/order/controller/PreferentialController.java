package com.changgou.order.controller;
import com.changgou.order.pojo.Preferential;
import com.changgou.order.service.PreferentialService;
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
@RequestMapping("/preferential")
@CrossOrigin
public class PreferentialController extends AbstractCoreController<Preferential>{

    private PreferentialService  preferentialService;

    @Autowired
    public PreferentialController(PreferentialService  preferentialService) {
        super(preferentialService, Preferential.class);
        this.preferentialService = preferentialService;
    }
}
