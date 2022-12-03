package com.changgou.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.entity.IdWorker;
import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.dao.SkuMapper;
import com.changgou.goods.dao.SpuMapper;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.pojo.Spu;
import com.changgou.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/****
 * @Author:admin
 * @Description:Spu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SpuServiceImpl extends CoreServiceImpl<Spu> implements SpuService {

    private SpuMapper spuMapper;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    public SpuServiceImpl(SpuMapper spuMapper) {
        super(spuMapper, Spu.class);
        this.spuMapper = spuMapper;
    }

    @Override
    public void save(Goods goods) {
        Spu spu = goods.getSpu();
        if (spu.getId()!=null) {
            spuMapper.updateByPrimaryKeySelective(spu);
            //先删除原来的sku 在添加
            Sku condition = new Sku();
            condition.setSpuId(spu.getId());
            skuMapper.delete(condition);
        }else {
            long id = idWorker.nextId();
            spu.setId(id);
            spu.setIsDelete("0");
            spu.setStatus("0");
            spuMapper.insertSelective(spu);
        }
        List<Sku> skuList = goods.getSkuList();
        for (Sku sku : skuList) {
            long id1 = idWorker.nextId();
            sku.setId(id1);
            String name = spu.getName();
            Map<String,String> map = JSON.parseObject(sku.getSpec(), Map.class);
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                //String key = stringStringEntry.getKey();
                String value = stringStringEntry.getValue();
                name+=" "+value;
            }
            sku.setName(name);
            sku.setCreateTime(new Date());
            sku.setUpdateTime(sku.getCreateTime());
            sku.setSpuId(spu.getId());
            sku.getCategoryId(spu.getCategory3Id());
            sku.setCategoryName(categoryMapper.select1(spu.getCategory3Id()).getName());
            sku.setBrandName(brandMapper.selectByPrimaryKey(spu.getBrandId()).getName());
            skuMapper.insertSelective(sku);
        }
    }

    @Override
    public Goods findgoodsById(Long id) {
        //根据id 从spu表中获取spu的记录
        Spu spu = spuMapper.selectByPrimaryKey(id);
        //根据spu的id 从sku表中获取sku的列表数据
        Sku sku = new Sku();
        sku.setSpuId(id);
        List<Sku> skuList = skuMapper.select(sku);
        return new Goods(spu,skuList);
    }
}
