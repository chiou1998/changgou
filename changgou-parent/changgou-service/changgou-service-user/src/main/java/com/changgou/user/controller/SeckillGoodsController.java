package com.changgou.user.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.user.pojo.SeckillGoods;
import com.changgou.user.service.SeckillGoodsService;
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
@RequestMapping("/seckillGoods")
@CrossOrigin
public class SeckillGoodsController extends AbstractCoreController<SeckillGoods>{

    private SeckillGoodsService  seckillGoodsService;

    @Autowired
    public SeckillGoodsController(SeckillGoodsService  seckillGoodsService) {
        super(seckillGoodsService, SeckillGoods.class);
        this.seckillGoodsService = seckillGoodsService;
    }
}
