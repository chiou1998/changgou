package com.changgou.user.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.user.dao.ActivityMapper;
import com.changgou.user.pojo.Activity;
import com.changgou.user.service.ActivityService;
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
