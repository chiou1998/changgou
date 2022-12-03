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
@RequestMapping("/admin")
public interface AdminFeign {

    /***
     * Admin
     * @param admin
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Admin admin, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * Admin分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param admin
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Admin>> findList(@RequestBody(required = false) Admin admin);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Admin数据
     * @param admin
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Admin admin,@PathVariable(name="id") Integer id);

    /***
     * 新增Admin数据
     * @param admin
     * @return
     */
    @PostMapping
    Result add(@RequestBody Admin admin);

    /***
     * 根据ID查询Admin数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Admin> findById(@PathVariable(name="id") Integer id);

    /***
     * 查询Admin全部数据
     * @return
     */
    @GetMapping
    Result<List<Admin>> findAll();
}