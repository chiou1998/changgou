package com.changgou.order.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.order.config.TokenDecode;
import com.changgou.order.pojo.Order;
import com.changgou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController extends AbstractCoreController<Order>{

    private OrderService  orderService;
    @Autowired
    private TokenDecode tokenDecode;


    @Autowired
    public OrderController(OrderService  orderService) {
        super(orderService, Order.class);
        this.orderService = orderService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody Order order){
        order.setUsername(tokenDecode.getUsername());
        orderService.add(order);
        return new Result(true, StatusCode.OK,"下单成功");
    }
}
