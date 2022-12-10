package com.changgou.order.service.impl;
import com.changgou.order.dao.ReturnCauseMapper;
import com.changgou.order.pojo.ReturnCause;
import com.changgou.order.service.ReturnCauseService;
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
