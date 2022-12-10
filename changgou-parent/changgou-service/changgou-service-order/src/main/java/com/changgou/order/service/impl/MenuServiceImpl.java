package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.MenuMapper;
import com.changgou.order.pojo.Menu;
import com.changgou.order.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Menu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class MenuServiceImpl extends CoreServiceImpl<Menu> implements MenuService {

    private MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        super(menuMapper, Menu.class);
        this.menuMapper = menuMapper;
    }
}
