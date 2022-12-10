package com.changgou.controller;


import com.changgou.feign.SkuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/search")
public class SkuController {

    @Autowired
    private SkuFeign skuFeign;
    @RequestMapping("/list")
    public String search(@RequestParam(required = false) Map<String,String> searchMap, Model model){
        //接受页面传递过来的参数
        //调用feign 获取到搜索的结果（结果就是map）
        Map<String, Object> resultMap = skuFeign.search(searchMap);
        //将数据（结果就是map）设置到model中
        model.addAttribute("result",resultMap);
        model.addAttribute("searchMap",searchMap);
        String url = url(searchMap);
        model.addAttribute("url",url);
        //模板就可以通过
        return "search";
    }

    private String url(Map<String, String> searchMap) {
        String url = "/search/list";
        if (searchMap!=null && searchMap.size()>0) {
            url+="?";
            for (Map.Entry<String, String> stringStringEntry : searchMap.entrySet()) {
                String key = stringStringEntry.getKey();
                String value = stringStringEntry.getValue();
                url+=key+"="+value+"&";
            }
            url = url.substring(0, url.length()-1);
        }
        return url;
    }
}
