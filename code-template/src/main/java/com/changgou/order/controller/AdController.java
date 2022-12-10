package com.changgou.order.controller;
import com.changgou.order.pojo.Ad;
import com.changgou.order.service.AdService;
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
