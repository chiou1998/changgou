package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "goods")
@RequestMapping("/sku1")
public interface SkuFeign {

    @GetMapping("/status/{status}")
    Result<List<Sku>> findByStatus(@PathVariable(name = "status") String status);

    /***
     * 根据ID查询SKU信息
     * @param id : sku的ID
     */
    @GetMapping(value = "/{id}")
    public Result<Sku> findById(@PathVariable(value = "id", required = true) Long id);

    @GetMapping("/decCount")
    public Result decCount(@RequestParam(name="id") Long id, @RequestParam(name="num") Integer num);

}
