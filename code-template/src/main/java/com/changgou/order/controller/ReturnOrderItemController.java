package com.changgou.order.controller;
import com.changgou.order.pojo.ReturnOrderItem;
import com.changgou.order.service.ReturnOrderItemService;
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
@RequestMapping("/returnOrderItem")
@CrossOrigin
public class ReturnOrderItemController extends AbstractCoreController<ReturnOrderItem>{

    private ReturnOrderItemService  returnOrderItemService;

    @Autowired
    public ReturnOrderItemController(ReturnOrderItemService  returnOrderItemService) {
        super(returnOrderItemService, ReturnOrderItem.class);
        this.returnOrderItemService = returnOrderItemService;
    }
}
