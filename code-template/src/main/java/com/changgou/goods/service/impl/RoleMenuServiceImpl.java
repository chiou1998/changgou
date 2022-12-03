package com.changgou.goods.service.impl;
import com.changgou.goods.dao.RoleMenuMapper;
import com.changgou.goods.pojo.RoleMenu;
import com.changgou.goods.service.RoleMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import com.changgou.core.service.impl.CoreServiceImpl;
import java.util.List;
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
