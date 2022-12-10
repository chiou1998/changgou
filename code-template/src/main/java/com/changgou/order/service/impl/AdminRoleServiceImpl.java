package com.changgou.order.service.impl;
import com.changgou.order.dao.AdminRoleMapper;
import com.changgou.order.pojo.AdminRole;
import com.changgou.order.service.AdminRoleService;
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
