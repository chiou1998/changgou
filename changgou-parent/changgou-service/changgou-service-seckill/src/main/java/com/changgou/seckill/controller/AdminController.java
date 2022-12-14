package com.changgou.seckill.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.seckill.pojo.Admin;
import com.changgou.seckill.service.AdminService;
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
@RequestMapping("/admin")
@CrossOrigin
public class AdminController extends AbstractCoreController<Admin>{

    private AdminService  adminService;

    @Autowired
    public AdminController(AdminService  adminService) {
        super(adminService, Admin.class);
        this.adminService = adminService;
    }
}
