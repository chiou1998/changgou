package com.changgou.order.controller;
import com.changgou.order.pojo.OrderItem;
import com.changgou.order.service.OrderItemService;
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
@RequestMapping("/orderItem")
@CrossOrigin
public class OrderItemController extends AbstractCoreController<OrderItem>{

    private OrderItemService  orderItemService;

    @Autowired
    public OrderItemController(OrderItemService  orderItemService) {
        super(orderItemService, OrderItem.class);
        this.orderItemService = orderItemService;
    }
}
