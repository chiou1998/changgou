package com.changgou.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/11/23 08:55
 * @description 标题
 * @package com.changgou.oauth.controller
 */
@Controller
@RequestMapping("/oauth")
public class LoginRedirect {

    /**
     * 页面渲染的 接收请求 直接返回展示一个页面
     *
     * @return 逻辑视图地址
     */
    @RequestMapping("/login")
    public String showLogin(String url, Model model) {
        model.addAttribute("url",url);
        return "login";
    }
}
