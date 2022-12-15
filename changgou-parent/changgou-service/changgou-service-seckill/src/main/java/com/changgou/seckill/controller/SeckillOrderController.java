package com.changgou.seckill.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.seckill.pojo.SeckillStatus;
import com.changgou.seckill.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/seckillOrder")
@CrossOrigin
public class SeckillOrderController extends AbstractCoreController<SeckillOrder>{
    @Autowired
    private SeckillOrderService  seckillOrderService;

    @Autowired
    public SeckillOrderController(SeckillOrderService  seckillOrderService) {
        super(seckillOrderService, SeckillOrder.class);
        this.seckillOrderService = seckillOrderService;
    }
    @RequestMapping("/add")
    public Result add(String time,Long id){
         String username = "zhangsan";
         boolean flag = seckillOrderService.add(id,time,username);
        if (flag) {
            return new Result(true, StatusCode.OK,"派对中请稍等");
        }else {
            return new Result(false, StatusCode.ERROR,"下单失败");
        }
    }
    @GetMapping("/status/query")
    public Result<SeckillStatus> query(){
        String username = "zhangsan";
        SeckillStatus seckillStatus = seckillOrderService.queryStatus(username);
        return new Result<SeckillStatus>(true,StatusCode.OK,"查询状态成功",seckillStatus);
    }
}
