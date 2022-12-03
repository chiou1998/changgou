package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.goods.pojo.OauthClientDetails;
import com.changgou.goods.service.OauthClientDetailsService;
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
