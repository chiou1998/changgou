package com.changgou.user.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.user.pojo.AdminRole;
import com.changgou.user.service.AdminRoleService;
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
@RequestMapping("/adminRole")
@CrossOrigin
public class AdminRoleController extends AbstractCoreController<AdminRole>{

    private AdminRoleService  adminRoleService;

    @Autowired
    public AdminRoleController(AdminRoleService  adminRoleService) {
        super(adminRoleService, AdminRole.class);
        this.adminRoleService = adminRoleService;
    }
}
