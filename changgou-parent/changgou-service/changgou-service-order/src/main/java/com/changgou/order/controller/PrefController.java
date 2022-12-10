package com.changgou.order.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.order.pojo.Pref;
import com.changgou.order.service.PrefService;
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
