package com.changgou.order.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.order.pojo.StockBack;
import com.changgou.order.service.StockBackService;
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
@RequestMapping("/stockBack")
@CrossOrigin
public class StockBackController extends AbstractCoreController<StockBack>{

    private StockBackService  stockBackService;

    @Autowired
    public StockBackController(StockBackService  stockBackService) {
        super(stockBackService, StockBack.class);
        this.stockBackService = stockBackService;
    }
}
