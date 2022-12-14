package com.changgou.seckill.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.seckill.dao.BrandMapper;
import com.changgou.seckill.pojo.Brand;
import com.changgou.seckill.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Brand业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BrandServiceImpl extends CoreServiceImpl<Brand> implements BrandService {

    private BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(BrandMapper brandMapper) {
        super(brandMapper, Brand.class);
        this.brandMapper = brandMapper;
    }
}
