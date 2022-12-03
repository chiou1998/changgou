package com.changgou.goods.controller;
import com.changgou.goods.pojo.StockBack;
import com.changgou.goods.service.StockBackService;
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
