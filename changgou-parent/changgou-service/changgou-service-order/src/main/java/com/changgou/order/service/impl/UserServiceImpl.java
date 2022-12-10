package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.UserMapper;
import com.changgou.order.pojo.User;
import com.changgou.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:User业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class UserServiceImpl extends CoreServiceImpl<User> implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        super(userMapper, User.class);
        this.userMapper = userMapper;
    }
}
