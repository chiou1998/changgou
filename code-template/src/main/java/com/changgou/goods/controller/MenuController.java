package com.changgou.goods.controller;
import com.changgou.goods.pojo.Menu;
import com.changgou.goods.service.MenuService;
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
@RequestMapping("/menu")
@CrossOrigin
public class MenuController extends AbstractCoreController<Menu>{

    private MenuService  menuService;

    @Autowired
    public MenuController(MenuService  menuService) {
        super(menuService, Menu.class);
        this.menuService = menuService;
    }
}
