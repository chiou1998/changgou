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
@RequestMapping("/ad")
public interface AdFeign {

    /***
     * Ad
     * @param ad
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Ad ad, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * Ad分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param ad
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Ad>> findList(@RequestBody(required = false) Ad ad);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Ad数据
     * @param ad
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Ad ad,@PathVariable(name="id") Integer id);

    /***
     * 新增Ad数据
     * @param ad
     * @return
     */
    @PostMapping
    Result add(@RequestBody Ad ad);

    /***
     * 根据ID查询Ad数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Ad> findById(@PathVariable(name="id") Integer id);

    /***
     * 查询Ad全部数据
     * @return
     */
    @GetMapping
    Result<List<Ad>> findAll();
}