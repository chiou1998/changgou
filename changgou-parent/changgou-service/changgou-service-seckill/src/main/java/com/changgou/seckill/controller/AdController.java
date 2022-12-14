package com.changgou.seckill.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.seckill.pojo.Ad;
import com.changgou.seckill.service.AdService;
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
@RequestMapping("/ad")
@CrossOrigin
public class AdController extends AbstractCoreController<Ad>{

    private AdService  adService;

    @Autowired
    public AdController(AdService  adService) {
        super(adService, Ad.class);
        this.adService = adService;
    }
}
