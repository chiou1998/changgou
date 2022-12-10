package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Spu;
import com.changgou.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/spu1")
@CrossOrigin
public class SpuController extends AbstractCoreController<Spu>{

    private SpuService  spuService;

    @Autowired
    public SpuController(SpuService  spuService) {
        super(spuService, Spu.class);
        this.spuService = spuService;
    }
    //添加商品
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        spuService.save(goods);
        return new Result<>(true, StatusCode.OK,"添加成功");
    }
    //查询商品数据  根据商品的spu的id获取spu和sku的列表数据
    @GetMapping("/goods/{id}")
    public Result<Goods> findgoodsById(@PathVariable(name = "id") Long id){
        Goods goods = spuService.findgoodsById(id);
        return new Result<Goods>(true,StatusCode.OK,"查询列表成功",goods);
    }
}
