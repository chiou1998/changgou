package com.changgou.order.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.order.pojo.Menu;
import com.changgou.order.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
