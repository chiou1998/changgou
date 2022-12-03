package com.changgou.goods.controller;
import com.changgou.goods.pojo.Album;
import com.changgou.goods.service.AlbumService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.changgou.core.AbstractCoreController;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController extends AbstractCoreController<Album>{

    private AlbumService  albumService;

    @Autowired
    public AlbumController(AlbumService  albumService) {
        super(albumService, Album.class);
        this.albumService = albumService;
    }
}
