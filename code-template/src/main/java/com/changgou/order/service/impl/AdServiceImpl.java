package com.changgou.order.service.impl;
import com.changgou.order.dao.AdMapper;
import com.changgou.order.pojo.Ad;
import com.changgou.order.service.AdService;
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
 * @Description:Ad业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AdServiceImpl extends CoreServiceImpl<Ad> implements AdService {

    private AdMapper adMapper;

    @Autowired
    public AdServiceImpl(AdMapper adMapper) {
        super(adMapper, Ad.class);
        this.adMapper = adMapper;
    }
}
