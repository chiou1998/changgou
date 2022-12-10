package com.changgou.order.service.impl;
import com.changgou.order.dao.ReturnOrderItemMapper;
import com.changgou.order.pojo.ReturnOrderItem;
import com.changgou.order.service.ReturnOrderItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import com.changgou.core.service.impl.CoreServiceImpl;
import java.util.List;
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
