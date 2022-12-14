package com.changgou.seckill.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.entity.SystemConstants;
import com.changgou.seckill.dao.SeckillGoodsMapper;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:SeckillGoods业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SeckillGoodsServiceImpl extends CoreServiceImpl<SeckillGoods> implements SeckillGoodsService {

    private SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    public SeckillGoodsServiceImpl(SeckillGoodsMapper seckillGoodsMapper) {
        super(seckillGoodsMapper, SeckillGoods.class);
        this.seckillGoodsMapper = seckillGoodsMapper;
    }

    @Override
    public List<SeckillGoods> list(String time) {
        List values = redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX + time).values();
        return values;
    }

    @Override
    public SeckillGoods one(String time, Long id) {
        SeckillGoods o = (SeckillGoods) redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX + time).get(id);
        return o;
    }
}
