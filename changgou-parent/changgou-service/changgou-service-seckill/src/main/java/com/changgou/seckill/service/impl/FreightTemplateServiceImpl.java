package com.changgou.seckill.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.seckill.dao.FreightTemplateMapper;
import com.changgou.seckill.pojo.FreightTemplate;
import com.changgou.seckill.service.FreightTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:FreightTemplate业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FreightTemplateServiceImpl extends CoreServiceImpl<FreightTemplate> implements FreightTemplateService {

    private FreightTemplateMapper freightTemplateMapper;

    @Autowired
    public FreightTemplateServiceImpl(FreightTemplateMapper freightTemplateMapper) {
        super(freightTemplateMapper, FreightTemplate.class);
        this.freightTemplateMapper = freightTemplateMapper;
    }
}
