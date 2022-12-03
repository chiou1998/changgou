package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CitiesMapper;
import com.changgou.goods.pojo.Cities;
import com.changgou.goods.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Cities业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CitiesServiceImpl extends CoreServiceImpl<Cities> implements CitiesService {

    private CitiesMapper citiesMapper;

    @Autowired
    public CitiesServiceImpl(CitiesMapper citiesMapper) {
        super(citiesMapper, Cities.class);
        this.citiesMapper = citiesMapper;
    }
}
