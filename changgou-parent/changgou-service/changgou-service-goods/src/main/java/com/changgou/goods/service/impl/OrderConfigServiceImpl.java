package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.OrderConfigMapper;
import com.changgou.goods.pojo.OrderConfig;
import com.changgou.goods.service.OrderConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:OrderConfig业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OrderConfigServiceImpl extends CoreServiceImpl<OrderConfig> implements OrderConfigService {

    private OrderConfigMapper orderConfigMapper;

    @Autowired
    public OrderConfigServiceImpl(OrderConfigMapper orderConfigMapper) {
        super(orderConfigMapper, OrderConfig.class);
        this.orderConfigMapper = orderConfigMapper;
    }
}
