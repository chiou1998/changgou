package com.changgou.content.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="goods")
@RequestMapping("/freightTemplate")
public interface FreightTemplateFeign {

    /***
     * FreightTemplate
     * @param freightTemplate
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) FreightTemplate freightTemplate, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * FreightTemplate分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param freightTemplate
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<FreightTemplate>> findList(@RequestBody(required = false) FreightTemplate freightTemplate);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改FreightTemplate数据
     * @param freightTemplate
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody FreightTemplate freightTemplate,@PathVariable(name="id") Integer id);

    /***
     * 新增FreightTemplate数据
     * @param freightTemplate
     * @return
     */
    @PostMapping
    Result add(@RequestBody FreightTemplate freightTemplate);

    /***
     * 根据ID查询FreightTemplate数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<FreightTemplate> findById(@PathVariable(name="id") Integer id);

    /***
     * 查询FreightTemplate全部数据
     * @return
     */
    @GetMapping
    Result<List<FreightTemplate>> findAll();
}