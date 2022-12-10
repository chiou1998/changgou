package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.RoleMenuMapper;
import com.changgou.order.pojo.RoleMenu;
import com.changgou.order.service.RoleMenuService;
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
