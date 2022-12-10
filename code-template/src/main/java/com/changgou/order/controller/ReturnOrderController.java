package com.changgou.order.controller;
import com.changgou.order.pojo.ReturnOrder;
import com.changgou.order.service.ReturnOrderService;
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
@RequestMapping("/returnOrder")
@CrossOrigin
public class ReturnOrderController extends AbstractCoreController<ReturnOrder>{

    private ReturnOrderService  returnOrderService;

    @Autowired
    public ReturnOrderController(ReturnOrderService  returnOrderService) {
        super(returnOrderService, ReturnOrder.class);
        this.returnOrderService = returnOrderService;
    }
}
