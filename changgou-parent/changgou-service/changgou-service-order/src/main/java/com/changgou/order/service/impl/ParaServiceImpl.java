package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.ParaMapper;
import com.changgou.order.pojo.Para;
import com.changgou.order.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Para业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ParaServiceImpl extends CoreServiceImpl<Para> implements ParaService {

    private ParaMapper paraMapper;

    @Autowired
    public ParaServiceImpl(ParaMapper paraMapper) {
        super(paraMapper, Para.class);
        this.paraMapper = paraMapper;
    }
}
