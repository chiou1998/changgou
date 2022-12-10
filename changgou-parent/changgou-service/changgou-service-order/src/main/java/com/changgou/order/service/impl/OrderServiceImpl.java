package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.entity.IdWorker;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.order.config.TokenDecode;
import com.changgou.order.dao.OrderItemMapper;
import com.changgou.order.dao.OrderMapper;
import com.changgou.order.pojo.Order;
import com.changgou.order.pojo.OrderItem;
import com.changgou.order.service.OrderService;
import com.changgou.user.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/****
 * @Author:admin
 * @Description:Order业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OrderServiceImpl extends CoreServiceImpl<Order> implements OrderService {

    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SkuFeign skuFeign;
    @Autowired
    private UserFeign userFeign;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        super(orderMapper, Order.class);
        this.orderMapper = orderMapper;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Order order) {
        String orderId = idWorker.nextId()+ "";
        order.setId(orderId);
        Integer totalNum = 0;
        Integer totalMoney = 0;
        List<OrderItem> values = redisTemplate.boundHashOps("Cart_" + order.getUsername()).values();
        for (OrderItem value : values) {
            Integer num = value.getNum();
            Integer money = value.getMoney();
            totalNum+=num;
            totalMoney+=totalMoney;

            //
            String orderItemId = idWorker.nextId()+"";
            value.setId(orderItemId);
            value.setOrderId(orderId);
            value.setIsReturn("0");
            orderItemMapper.insertSelective(value);

            skuFeign.decCount(value.getSkuId(),num);
            userFeign.addPoints(order.getUsername(),10);
        }


        order.setTotalNum(totalNum);
        order.setTotalMoney(totalMoney);
        order.setPayMoney(totalMoney);
        order.setCreateTime(new Date());
        order.setUpdateTime(order.getCreateTime());
        order.setBuyerRate("0");
        order.setPayStatus("0");
        order.setConsignStatus("0");
        //添加数据到订单表
        //添加数据到订单选项表
        orderMapper.insertSelective(order);

        //删除购物车的数据

    }
}
