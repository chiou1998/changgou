package com.changgou.goods.controller;
import com.changgou.goods.pojo.Admin;
import com.changgou.goods.service.AdminService;
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
