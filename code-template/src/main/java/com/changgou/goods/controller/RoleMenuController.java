package com.changgou.goods.controller;
import com.changgou.goods.pojo.RoleMenu;
import com.changgou.goods.service.RoleMenuService;
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
