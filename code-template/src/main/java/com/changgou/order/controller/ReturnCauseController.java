package com.changgou.order.controller;
import com.changgou.order.pojo.ReturnCause;
import com.changgou.order.service.ReturnCauseService;
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
@RequestMapping("/returnCause")
@CrossOrigin
public class ReturnCauseController extends AbstractCoreController<ReturnCause>{

    private ReturnCauseService  returnCauseService;

    @Autowired
    public ReturnCauseController(ReturnCauseService  returnCauseService) {
        super(returnCauseService, ReturnCause.class);
        this.returnCauseService = returnCauseService;
    }
}
