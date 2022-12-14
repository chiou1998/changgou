package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.SpecMapper;
import com.changgou.order.pojo.Spec;
import com.changgou.order.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Spec业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SpecServiceImpl extends CoreServiceImpl<Spec> implements SpecService {

    private SpecMapper specMapper;

    @Autowired
    public SpecServiceImpl(SpecMapper specMapper) {
        super(specMapper, Spec.class);
        this.specMapper = specMapper;
    }
}
