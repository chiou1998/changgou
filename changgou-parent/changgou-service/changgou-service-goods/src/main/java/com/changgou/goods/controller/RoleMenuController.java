package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.goods.pojo.RoleMenu;
import com.changgou.goods.service.RoleMenuService;
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
@RequestMapping("/roleMenu")
@CrossOrigin
public class RoleMenuController extends AbstractCoreController<RoleMenu>{

    private RoleMenuService  roleMenuService;

    @Autowired
    public RoleMenuController(RoleMenuService  roleMenuService) {
        super(roleMenuService, RoleMenu.class);
        this.roleMenuService = roleMenuService;
    }
}
