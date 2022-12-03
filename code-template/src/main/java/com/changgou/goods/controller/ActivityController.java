package com.changgou.goods.controller;
import com.changgou.goods.pojo.Activity;
import com.changgou.goods.service.ActivityService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.changgou.core.AbstractCoreController;

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
