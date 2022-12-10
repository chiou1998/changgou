package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.ActivityMapper;
import com.changgou.order.pojo.Activity;
import com.changgou.order.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Activity业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ActivityServiceImpl extends CoreServiceImpl<Activity> implements ActivityService {

    private ActivityMapper activityMapper;

    @Autowired
    public ActivityServiceImpl(ActivityMapper activityMapper) {
        super(activityMapper, Activity.class);
        this.activityMapper = activityMapper;
    }
}
