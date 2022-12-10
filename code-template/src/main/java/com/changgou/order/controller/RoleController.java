package com.changgou.order.controller;
import com.changgou.order.pojo.Role;
import com.changgou.order.service.RoleService;
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
@RequestMapping("/role")
@CrossOrigin
public class RoleController extends AbstractCoreController<Role>{

    private RoleService  roleService;

    @Autowired
    public RoleController(RoleService  roleService) {
        super(roleService, Role.class);
        this.roleService = roleService;
    }
}
