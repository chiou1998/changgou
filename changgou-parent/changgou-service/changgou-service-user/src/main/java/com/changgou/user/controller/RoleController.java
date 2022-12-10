package com.changgou.user.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.user.pojo.Role;
import com.changgou.user.service.RoleService;
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
