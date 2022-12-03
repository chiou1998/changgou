package com.changgou.goods.controller;
import com.changgou.goods.pojo.OrderConfig;
import com.changgou.goods.service.OrderConfigService;
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
@RequestMapping("/orderConfig")
@CrossOrigin
public class OrderConfigController extends AbstractCoreController<OrderConfig>{

    private OrderConfigService  orderConfigService;

    @Autowired
    public OrderConfigController(OrderConfigService  orderConfigService) {
        super(orderConfigService, OrderConfig.class);
        this.orderConfigService = orderConfigService;
    }
}
