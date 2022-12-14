package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.dao.ParaMapper;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:Para业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ParaServiceImpl extends CoreServiceImpl<Para> implements ParaService {

    private ParaMapper paraMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    public ParaServiceImpl(ParaMapper paraMapper) {
        super(paraMapper, Para.class);
        this.paraMapper = paraMapper;
    }

    @Override
    public List<Para> findByCategoryId(Integer id) {
        Integer id1 = categoryMapper.selectByPrimaryKey(id);
        Para condition = new Para();
        condition.setTemplateId(id1);
        List<Para> select = paraMapper.select(condition);
        return select;
    }
}
