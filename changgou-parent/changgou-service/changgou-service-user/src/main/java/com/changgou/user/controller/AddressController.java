package com.changgou.user.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.user.config.TokenDecode;
import com.changgou.user.pojo.Address;
import com.changgou.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController extends AbstractCoreController<Address>{

    private AddressService  addressService;
    @Autowired
    private TokenDecode tokenDecode;

    @Autowired
    public AddressController(AddressService  addressService) {
        super(addressService, Address.class);
        this.addressService = addressService;
    }
    @GetMapping("/user/list")
    public Result<List<Address>> listResult(){
        String username = tokenDecode.getUsername();
        List<Address> listResult = addressService.list(username);
        return new Result<List<Address>>(true, StatusCode.OK,"查询成功",listResult);
    }
}
