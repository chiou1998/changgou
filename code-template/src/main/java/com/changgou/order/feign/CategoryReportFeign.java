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
@RequestMapping("/categoryReport")
public interface CategoryReportFeign {

    /***
     * CategoryReport
     * @param categoryReport
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) CategoryReport categoryReport, @PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * CategoryReport分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable(name="page")  int page, @PathVariable(name="size")  int size);

    /***
     * 多条件搜索品牌数据
     * @param categoryReport
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<CategoryReport>> findList(@RequestBody(required = false) CategoryReport categoryReport);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Date id);

    /***
     * 修改CategoryReport数据
     * @param categoryReport
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody CategoryReport categoryReport,@PathVariable(name="id") Date id);

    /***
     * 新增CategoryReport数据
     * @param categoryReport
     * @return
     */
    @PostMapping
    Result add(@RequestBody CategoryReport categoryReport);

    /***
     * 根据ID查询CategoryReport数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<CategoryReport> findById(@PathVariable(name="id") Date id);

    /***
     * 查询CategoryReport全部数据
     * @return
     */
    @GetMapping
    Result<List<CategoryReport>> findAll();
}