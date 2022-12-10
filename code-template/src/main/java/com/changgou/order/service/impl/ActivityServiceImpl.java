package com.changgou.order.service.impl;
import com.changgou.order.dao.ActivityMapper;
import com.changgou.order.pojo.Activity;
import com.changgou.order.service.ActivityService;
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
