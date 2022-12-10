package com.changgou.order.controller;
import com.changgou.order.pojo.Pref;
import com.changgou.order.service.PrefService;
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
@RequestMapping("/pref")
@CrossOrigin
public class PrefController extends AbstractCoreController<Pref>{

    private PrefService  prefService;

    @Autowired
    public PrefController(PrefService  prefService) {
        super(prefService, Pref.class);
        this.prefService = prefService;
    }
}
