package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/para")
@CrossOrigin
public class ParaController extends AbstractCoreController<Para>{

    private ParaService  paraService;

    @Autowired
    public ParaController(ParaService  paraService) {
        super(paraService, Para.class);
        this.paraService = paraService;
    }
    @GetMapping(value = "/category/{id}")
    public Result<List<Para>> getByCategoryId(@PathVariable(value = "id")Integer id){
        //根据分类ID查询对应的参数信息
        List<Para> paras = paraService.findByCategoryId(id);
        return new Result<List<Para>>(true, StatusCode.OK,"查询分类对应的品牌成功！",paras);
}}
