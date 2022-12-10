package com.changgou.user.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.user.dao.RoleMenuMapper;
import com.changgou.user.pojo.RoleMenu;
import com.changgou.user.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:RoleMenu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RoleMenuServiceImpl extends CoreServiceImpl<RoleMenu> implements RoleMenuService {

    private RoleMenuMapper roleMenuMapper;

    @Autowired
    public RoleMenuServiceImpl(RoleMenuMapper roleMenuMapper) {
        super(roleMenuMapper, RoleMenu.class);
        this.roleMenuMapper = roleMenuMapper;
    }
}
