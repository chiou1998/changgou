package com.changgou.seckill.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.entity.DateUtil;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
    @GetMapping("/menu")
    public List<Date> dateMenu(){
        //展示当前五个时间段的秒杀活动时间
        return DateUtil.getDateMenus();
    }
    @GetMapping("/list")
    public List<SeckillGoods> list(String time){
        return seckillGoodsService.list(time);
    }
    @GetMapping("/one")
    public SeckillGoods one(String time ,Long id){
        return seckillGoodsService.one(time,id);
    }
}
