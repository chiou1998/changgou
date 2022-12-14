package com.changgou.seckill.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.seckill.dao.OauthClientDetailsMapper;
import com.changgou.seckill.pojo.OauthClientDetails;
import com.changgou.seckill.service.OauthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:OauthClientDetails业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OauthClientDetailsServiceImpl extends CoreServiceImpl<OauthClientDetails> implements OauthClientDetailsService {

    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Autowired
    public OauthClientDetailsServiceImpl(OauthClientDetailsMapper oauthClientDetailsMapper) {
        super(oauthClientDetailsMapper, OauthClientDetails.class);
        this.oauthClientDetailsMapper = oauthClientDetailsMapper;
    }
}
