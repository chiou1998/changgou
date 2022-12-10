package com.changgou.order.controller;
import com.changgou.order.pojo.OauthClientDetails;
import com.changgou.order.service.OauthClientDetailsService;
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
@RequestMapping("/oauthClientDetails")
@CrossOrigin
public class OauthClientDetailsController extends AbstractCoreController<OauthClientDetails>{

    private OauthClientDetailsService  oauthClientDetailsService;

    @Autowired
    public OauthClientDetailsController(OauthClientDetailsService  oauthClientDetailsService) {
        super(oauthClientDetailsService, OauthClientDetails.class);
        this.oauthClientDetailsService = oauthClientDetailsService;
    }
}
