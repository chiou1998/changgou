package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.ReturnCauseMapper;
import com.changgou.goods.pojo.ReturnCause;
import com.changgou.goods.service.ReturnCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:ReturnCause业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ReturnCauseServiceImpl extends CoreServiceImpl<ReturnCause> implements ReturnCauseService {

    private ReturnCauseMapper returnCauseMapper;

    @Autowired
    public ReturnCauseServiceImpl(ReturnCauseMapper returnCauseMapper) {
        super(returnCauseMapper, ReturnCause.class);
        this.returnCauseMapper = returnCauseMapper;
    }
}
