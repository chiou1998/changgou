package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.StockBackMapper;
import com.changgou.order.pojo.StockBack;
import com.changgou.order.service.StockBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:StockBack业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class StockBackServiceImpl extends CoreServiceImpl<StockBack> implements StockBackService {

    private StockBackMapper stockBackMapper;

    @Autowired
    public StockBackServiceImpl(StockBackMapper stockBackMapper) {
        super(stockBackMapper, StockBack.class);
        this.stockBackMapper = stockBackMapper;
    }
}
