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
@RequestMapping("/para")
public interface ParaFeign {

    /***
     * Para
     * @param para
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Para para, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * Para分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param para
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Para>> findList(@RequestBody(required = false) Para para);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Para数据
     * @param para
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Para para,@PathVariable(name="id") Integer id);

    /***
     * 新增Para数据
     * @param para
     * @return
     */
    @PostMapping
    Result add(@RequestBody Para para);

    /***
     * 根据ID查询Para数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Para> findById(@PathVariable(name="id") Integer id);

    /***
     * 查询Para全部数据
     * @return
     */
    @GetMapping
    Result<List<Para>> findAll();
}