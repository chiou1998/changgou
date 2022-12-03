package com.changgou.search.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("search")
public class SkuController {
    @Autowired
    private SkuService skuService;
    //从数据库获取数据导入数据到es服务器中
    @GetMapping("/import")
    public Result importData(){
        skuService.importSku();
        return new Result(true, StatusCode.OK,"导入成功");
    }
    @PostMapping
    public Map<String,Object> search(@RequestBody(required = false) Map<String,String> searchMap){
        if (searchMap==null) {
            searchMap = new HashMap<>();
        }
        return skuService.search(searchMap);
    }
}
