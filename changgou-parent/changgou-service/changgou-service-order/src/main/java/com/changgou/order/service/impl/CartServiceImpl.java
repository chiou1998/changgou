package com.changgou.order.service.impl;

import com.changgou.entity.Result;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.feign.SpuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.pojo.Spu;
import com.changgou.order.pojo.OrderItem;
import com.changgou.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SpuFeign spuFeign;
    @Autowired
    private SkuFeign skuFeign;
    @Override
    public void add(Integer num, Long id, String username) {

        if (num==0) {
            redisTemplate.boundHashOps("Cart_"+username).delete(id);
            return;
        }

        OrderItem orderItem = new OrderItem();
        Result<Sku> skuResult = skuFeign.findById(id);
        Sku data = skuResult.getData();//getdata为返回数据
        Result<Spu> spuResult = spuFeign.findById(data.getSpuId());
        Spu data1 = spuResult.getData();

        orderItem.setCategoryId1(data1.getCategory1Id());
        orderItem.setCategoryId2(data1.getCategory2Id());
        orderItem.setCategoryId3(data1.getCategory3Id());
        orderItem.setSpuId(data1.getId());
        orderItem.setSkuId(data.getId());
        orderItem.setName(data.getName());
        orderItem.setPrice(data.getPrice());
        orderItem.setNum(data.getNum());
        orderItem.setMoney(num*data.getPrice());
        orderItem.setPayMoney(num*data.getPrice());
        orderItem.setImage(data.getImage());
        redisTemplate.boundHashOps("Cart_"+username).put(id,orderItem);

    }

    @Override
    public List<OrderItem> list(String username) {
        return redisTemplate.boundHashOps("Cart_"+username).values();
    }
}
