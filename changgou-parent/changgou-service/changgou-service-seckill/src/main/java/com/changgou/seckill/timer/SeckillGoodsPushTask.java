package com.changgou.seckill.timer;

import com.changgou.entity.DateUtil;
import com.changgou.entity.SystemConstants;
import com.changgou.seckill.dao.SeckillGoodsMapper;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class SeckillGoodsPushTask {
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    /****
     * 每30秒执行一次
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void loadGoodsPushRedis() {

        List<Date> dateMenus = DateUtil.getDateMenus();
        for (Date dateMenu : dateMenus) {
            String s = DateUtil.data2str(dateMenu, DateUtil.PATTERN_YYYY_MM_DDHHMM);
            //查询符合条件的商品
            Example example = new Example(SeckillGoods.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("status","1");
            criteria.andGreaterThan("stockCount",0);
            criteria.andEqualTo("startTime",dateMenu);
            criteria.andLessThan("endTime",DateUtil.addDateHour(dateMenu,2));
            Set keys = redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX + s).keys();
            if (keys!=null && keys.size()>0) {
                criteria.andNotIn("id",keys);
            }
            List<SeckillGoods> seckillGoods = seckillGoodsMapper.selectByExample(example);
            //将列表数据存储到redis中的hash
            for (SeckillGoods seckillGood : seckillGoods) {
                //key设置有效期2小时
                redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX+s).put(seckillGood.getId(),seckillGood);
                redisTemplate.boundHashOps(SystemConstants.SEC_KILL_GOODS_PREFIX+s).expire(2, TimeUnit.HOURS);
            }
        }

    }
}