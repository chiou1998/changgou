package com.changgou.order.service.impl;
import com.changgou.order.dao.FreightTemplateMapper;
import com.changgou.order.pojo.FreightTemplate;
import com.changgou.order.service.FreightTemplateService;
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
