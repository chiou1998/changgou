package com.changgou.order.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.OrderItem;
import com.changgou.order.config.TokenDecode;
import com.changgou.order.pojo.Order;
import com.changgou.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private TokenDecode tokenDecode;

    @GetMapping("/add") //num为商品数量 id为商品sku id
    public Result addCart(Integer num,Long id){

        String username = tokenDecode.getUsername();
        cartService.add(num,id,username);
        return new Result(true, StatusCode.OK,"添加购物车成功");
    }
    @GetMapping("/list")
    public Result<List<com.changgou.order.pojo.OrderItem>> list(){
        String username = "zhangsan";
        List<com.changgou.order.pojo.OrderItem> orderItemList = cartService.list(username);
        return new  Result<List<com.changgou.order.pojo.OrderItem>>(true, StatusCode.OK,"查询成功",orderItemList);
    }
}
