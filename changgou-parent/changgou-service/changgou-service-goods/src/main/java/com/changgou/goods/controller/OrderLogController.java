package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.goods.pojo.OrderLog;
import com.changgou.goods.service.OrderLogService;
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
@RequestMapping("/orderLog")
@CrossOrigin
public class OrderLogController extends AbstractCoreController<OrderLog>{

    private OrderLogService  orderLogService;

    @Autowired
    public OrderLogController(OrderLogService  orderLogService) {
        super(orderLogService, OrderLog.class);
        this.orderLogService = orderLogService;
    }
}
