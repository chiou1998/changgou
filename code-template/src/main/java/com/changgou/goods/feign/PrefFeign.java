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
@RequestMapping("/pref")
public interface PrefFeign {

    /***
     * Pref
     * @param pref
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Pref pref, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * Pref分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param pref
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Pref>> findList(@RequestBody(required = false) Pref pref);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Pref数据
     * @param pref
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Pref pref,@PathVariable(name="id") Integer id);

    /***
     * 新增Pref数据
     * @param pref
     * @return
     */
    @PostMapping
    Result add(@RequestBody Pref pref);

    /***
     * 根据ID查询Pref数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Pref> findById(@PathVariable(name="id") Integer id);

    /***
     * 查询Pref全部数据
     * @return
     */
    @GetMapping
    Result<List<Pref>> findAll();
}