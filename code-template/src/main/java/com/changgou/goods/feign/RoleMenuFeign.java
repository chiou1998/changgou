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
@RequestMapping("/roleMenu")
public interface RoleMenuFeign {

    /***
     * RoleMenu
     * @param roleMenu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) RoleMenu roleMenu, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * RoleMenu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param roleMenu
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<RoleMenu>> findList(@RequestBody(required = false) RoleMenu roleMenu);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改RoleMenu数据
     * @param roleMenu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody RoleMenu roleMenu,@PathVariable(name="id") Integer id);

    /***
     * 新增RoleMenu数据
     * @param roleMenu
     * @return
     */
    @PostMapping
    Result add(@RequestBody RoleMenu roleMenu);

    /***
     * 根据ID查询RoleMenu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<RoleMenu> findById(@PathVariable(name="id") Integer id);

    /***
     * 查询RoleMenu全部数据
     * @return
     */
    @GetMapping
    Result<List<RoleMenu>> findAll();
}