package com.changgou.oauth.config;

import com.changgou.entity.Result;
import com.changgou.user.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/***
 * 描述
 * @author ljh
 * @packagename com.itheima.config
 * @version 1.0
 * @date 2020/1/10
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("获取到的用户名是：" + username);
        String permission = "ROLE_ADMIN,ROLE_USER";//设置权限
        Result<com.changgou.user.pojo.User> result = userFeign.findById(username);
        com.changgou.user.pojo.User user = result.getData();
        if (user==null) {
            throw new UsernameNotFoundException("用户名没有找到");
        }
        String password = user.getPassword();
        return new User(username,password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(permission));
    }
}
