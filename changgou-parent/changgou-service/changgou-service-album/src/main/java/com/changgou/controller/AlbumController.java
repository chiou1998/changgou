package com.changgou.controller;

import com.changgou.album.pojo.Album;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.service.AlbumService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    //增
    @Autowired
    private AlbumService albumService;
    @PostMapping("/add")
    public Result add(@RequestBody Album album){
        albumService.add(album);
        return new Result(true, StatusCode.OK,"添加成功");
    }
    @PostMapping("/search")
    public Result<List<Album>> search(@RequestBody(required = false) Album album){
        List<Album> albumList = albumService.search(album);
        return new Result(true, StatusCode.OK,"条件查询成功",albumList);
    }
    @GetMapping( "/search1/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable  Integer page, @PathVariable  Integer size){
        //分页查询
        PageInfo<Album> pageInfo = albumService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }//条件分页查询
    @GetMapping( "/search2/{page}/{size}")
    public Result<PageInfo> searchPage(@PathVariable  Integer page, @PathVariable  Integer size, @RequestBody(required = false) Album album){
        //分页查询
        PageInfo<Album> pageInfo = albumService.searchPage(page, size, album);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }
}
