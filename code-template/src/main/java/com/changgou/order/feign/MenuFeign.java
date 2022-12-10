package com.changgou.content.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="order")
@RequestMapping("/menu")
public interface MenuFeign {

    /***
     * Menu
     * @param menu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Menu menu, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * Menu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param menu
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Menu>> findList(@RequestBody(required = false) Menu menu);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改Menu数据
     * @param menu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Menu menu,@PathVariable(name="id") String id);

    /***
     * 新增Menu数据
     * @param menu
     * @return
     */
    @PostMapping
    Result add(@RequestBody Menu menu);

    /***
     * 根据ID查询Menu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Menu> findById(@PathVariable(name="id") String id);

    /***
     * 查询Menu全部数据
     * @return
     */
    @GetMapping
    Result<List<Menu>> findAll();
}