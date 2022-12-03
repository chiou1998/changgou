package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
//import com.changgou.goods.dao.ActivityMapper;
import com.changgou.goods.dao.ActivityMapper;
import com.changgou.goods.pojo.Activity;
import com.changgou.goods.service.ActivityService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:admin
 * @Description:Activity业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ActivityServiceImpl extends CoreServiceImpl<Activity> implements ActivityService {

    private ActivityMapper activityMapper;

  public ActivityServiceImpl(Mapper<Activity> baseMapper, Class<Activity> clazz) {
      super(baseMapper, clazz);
  }

    @Autowired
    public ActivityServiceImpl(ActivityMapper activityMapper) {
        super(activityMapper, Activity.class);
        this.activityMapper = activityMapper;
    }
}
