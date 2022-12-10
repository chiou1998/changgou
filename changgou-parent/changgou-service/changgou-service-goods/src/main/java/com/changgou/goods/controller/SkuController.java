package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/sku1")
@CrossOrigin
public class SkuController extends AbstractCoreController<Sku>{

    private SkuService  skuService;

    @Autowired
    public SkuController(SkuService  skuService) {
        super(skuService, Sku.class);
        this.skuService = skuService;
    }
    @GetMapping("/status/{status}")
    Result<List<Sku>> findByStatus(@PathVariable(name = "status") String status){
        List<Sku> skuList = skuService.findByStatus(status);
        return new Result<List<Sku>>(true, StatusCode.OK,"获取成功",skuList);
    }
    @GetMapping("/decCount")
    public Result decCount(@RequestParam(name="id") Long id, @RequestParam(name="num") Integer num){
        Integer count = skuService.decCount(id,num);
        if (count>0) {
            return new Result(true,StatusCode.OK,"修改成功");
        }else {
            return new Result(false,StatusCode.OK,"修改失败");
        }
    }

}
