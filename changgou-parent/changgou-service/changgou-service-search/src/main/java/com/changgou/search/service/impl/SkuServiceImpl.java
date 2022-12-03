package com.changgou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.SkuInfo;
import com.changgou.entity.Result;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.search.dao.SkuEsMapper;
import com.changgou.search.service.SkuService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuFeign skuFeign;
    @Autowired
    private SkuEsMapper skuEsMapper;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate; //提供了更多的搜索方法
    @Override
    public void importSku() {
        Result<List<Sku>> result = skuFeign.findByStatus("1");
        List<Sku> skuList = result.getData();
        String s = JSON.toJSONString(skuList);
        List<SkuInfo> skuInfos = JSON.parseArray(s, SkuInfo.class);
        for (SkuInfo skuInfo : skuInfos) {
            String spec = skuInfo.getSpec();
            Map<String,Object> map = JSON.parseObject(spec, Map.class);
            skuInfo.setSpecMap(map);

        }
        skuEsMapper.saveAll(skuInfos);
    }

    @Override
    public Map<String, Object> search(Map<String, String> searchMap) {
        //判断页面传递过来的值是否为空，如果为空返回一个默认的值
        String keywords = searchMap.get("keywords");
        if (StringUtils.isEmpty(keywords)) {
            keywords="华为";
        }
        //创建查询对象的构建对象
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //添加查询方法
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("name",keywords));
        SearchQuery query = nativeSearchQueryBuilder.build();
        AggregatedPage<SkuInfo> skuInfos = elasticsearchTemplate.queryForPage(query, SkuInfo.class);
        //获取结果（总记录数，总页数，当前页的记录等数据）
        List<SkuInfo> content = skuInfos.getContent();
        long totalElements = skuInfos.getTotalElements();
        int totalPages = skuInfos.getTotalPages();
         // 组装到map中返回
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("rows",content );
        resultMap.put("totalPages",totalPages );
        resultMap.put("total",totalElements );

        return resultMap;
    }
}
