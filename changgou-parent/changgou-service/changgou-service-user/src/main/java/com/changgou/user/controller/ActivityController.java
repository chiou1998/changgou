package com.changgou.user.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.user.pojo.Activity;
import com.changgou.user.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/activity")
@CrossOrigin
public class ActivityController extends AbstractCoreController<Activity>{

    private ActivityService  activityService;

    @Autowired
    public ActivityController(ActivityService  activityService) {
        super(activityService, Activity.class);
        this.activityService = activityService;
    }
}
