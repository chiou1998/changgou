package com.changgou.user.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.user.dao.PrefMapper;
import com.changgou.user.pojo.Pref;
import com.changgou.user.service.PrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Pref业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PrefServiceImpl extends CoreServiceImpl<Pref> implements PrefService {

    private PrefMapper prefMapper;

    @Autowired
    public PrefServiceImpl(PrefMapper prefMapper) {
        super(prefMapper, Pref.class);
        this.prefMapper = prefMapper;
    }
}
