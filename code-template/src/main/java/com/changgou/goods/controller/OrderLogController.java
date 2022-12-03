package com.changgou.goods.controller;
import com.changgou.goods.pojo.OrderLog;
import com.changgou.goods.service.OrderLogService;
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
