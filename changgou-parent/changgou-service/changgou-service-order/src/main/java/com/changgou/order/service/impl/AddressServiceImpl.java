package com.changgou.order.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.order.dao.AddressMapper;
import com.changgou.order.pojo.Address;
import com.changgou.order.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Address业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AddressServiceImpl extends CoreServiceImpl<Address> implements AddressService {

    private AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper) {
        super(addressMapper, Address.class);
        this.addressMapper = addressMapper;
    }
}
