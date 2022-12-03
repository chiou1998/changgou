package com.changgou.goods.service.impl;
import com.changgou.goods.dao.ProvincesMapper;
import com.changgou.goods.pojo.Provinces;
import com.changgou.goods.service.ProvincesService;
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
 * @Description:Provinces业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ProvincesServiceImpl extends CoreServiceImpl<Provinces> implements ProvincesService {

    private ProvincesMapper provincesMapper;

    @Autowired
    public ProvincesServiceImpl(ProvincesMapper provincesMapper) {
        super(provincesMapper, Provinces.class);
        this.provincesMapper = provincesMapper;
    }
}
