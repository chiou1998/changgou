package com.changgou.user.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.user.dao.RoleMapper;
import com.changgou.user.pojo.Role;
import com.changgou.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Role业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RoleServiceImpl extends CoreServiceImpl<Role> implements RoleService {

    private RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        super(roleMapper, Role.class);
        this.roleMapper = roleMapper;
    }
}
