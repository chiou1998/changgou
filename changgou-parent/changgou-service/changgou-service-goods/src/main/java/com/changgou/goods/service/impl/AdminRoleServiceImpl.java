package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.AdminRoleMapper;
import com.changgou.goods.pojo.AdminRole;
import com.changgou.goods.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:AdminRole业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AdminRoleServiceImpl extends CoreServiceImpl<AdminRole> implements AdminRoleService {

    private AdminRoleMapper adminRoleMapper;

    @Autowired
    public AdminRoleServiceImpl(AdminRoleMapper adminRoleMapper) {
        super(adminRoleMapper, AdminRole.class);
        this.adminRoleMapper = adminRoleMapper;
    }
}
