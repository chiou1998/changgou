package com.changgou.user.controller;

import com.alibaba.fastjson.JSON;
import com.changgou.core.AbstractCoreController;
import com.changgou.entity.BCrypt;
import com.changgou.entity.JwtUtil;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.user.pojo.User;
import com.changgou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.UUID;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController extends AbstractCoreController<User>{

    private UserService  userService;

    @Autowired
    public UserController(UserService  userService) {
        super(userService, User.class);
        this.userService = userService;
    }
    //实现fegin接口
    @GetMapping("load/{id}")
    Result<User> findById(@PathVariable(name = "id") String id){
        User user = userService.selectByPrimaryKey(id);
        return new Result<User>(true,StatusCode.OK,"查询成功",user);
    }
    /**
     * 给指定的用户名 添加积分
     * @param username  用户名
     * @param points  积分数
     * @return
     */
    @GetMapping("/points/add")
    public Result addPoints(@RequestParam(name="username") String username,
                            @RequestParam(name="points") Integer points){
       Integer count = userService.addPoints(username,points);
        if (count>0) {
            return new Result(true, StatusCode.OK,"修改积分成功");
        }else {
            return new Result(false, StatusCode.ERROR,"修改积分失败");
        }
    }
    @GetMapping(value = "/login")
    public Result login(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,HttpServletResponse response){
        //判断是否为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new Result(false, StatusCode.LOGINERROR,"用户名和密码不能为空");
        }
        //判断用户信息是否存在
        User user = userService.selectByPrimaryKey(username);
        if (user==null) {
            return new Result(false,StatusCode.LOGINERROR,"用户或密码错误");
        }
        //判断是否密码正确
        if (!password.equals(user.getPassword())) {
            return new Result(false,StatusCode.LOGINERROR,"用户或密码错误");
        }
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("username",username);
        objectObjectHashMap.put("role","Role_ADMIN");
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(objectObjectHashMap), null);
        Cookie cookie = new Cookie("Authorization",token);
        cookie.setPath("/");
        response.addCookie(cookie);


        return new Result(true,StatusCode.OK,"登录成功");
    }
}
