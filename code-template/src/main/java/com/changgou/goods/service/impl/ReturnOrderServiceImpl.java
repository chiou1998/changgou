package com.changgou.goods.service.impl;
import com.changgou.goods.dao.ReturnOrderMapper;
import com.changgou.goods.pojo.ReturnOrder;
import com.changgou.goods.service.ReturnOrderService;
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
 * @Description:ReturnOrder业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ReturnOrderServiceImpl extends CoreServiceImpl<ReturnOrder> implements ReturnOrderService {

    private ReturnOrderMapper returnOrderMapper;

    @Autowired
    public ReturnOrderServiceImpl(ReturnOrderMapper returnOrderMapper) {
        super(returnOrderMapper, ReturnOrder.class);
        this.returnOrderMapper = returnOrderMapper;
    }
}
