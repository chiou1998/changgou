package com.changgou.user.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.user.dao.ReturnOrderItemMapper;
import com.changgou.user.pojo.ReturnOrderItem;
import com.changgou.user.service.ReturnOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:ReturnOrderItem业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ReturnOrderItemServiceImpl extends CoreServiceImpl<ReturnOrderItem> implements ReturnOrderItemService {

    private ReturnOrderItemMapper returnOrderItemMapper;

    @Autowired
    public ReturnOrderItemServiceImpl(ReturnOrderItemMapper returnOrderItemMapper) {
        super(returnOrderItemMapper, ReturnOrderItem.class);
        this.returnOrderItemMapper = returnOrderItemMapper;
    }
}
