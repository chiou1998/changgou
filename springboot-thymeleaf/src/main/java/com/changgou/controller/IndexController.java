package com.changgou.controller;

import com.changgou.user.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class IndexController {

    @RequestMapping("/index")
    public String showIndex(Model model){
        model.addAttribute("message","helllo");
        model.addAttribute("person",new Person(1l,"童林"));
        return "index";
    }
}
