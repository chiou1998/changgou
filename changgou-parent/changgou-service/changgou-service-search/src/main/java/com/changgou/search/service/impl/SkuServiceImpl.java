package com.changgou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.SkuInfo;
import com.changgou.entity.Result;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.search.dao.SkuEsMapper;
import com.changgou.search.service.SkuService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.*;

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
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("skuCategorygroup").field("categoryName").size(10000));
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("skuBrandgroup").field("brandName").size(10000));
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("skuSpecgroup").field("spec.keyword").size(10000));

        //添加查询方法
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("name",keywords));//匹配查询 从name上搜索内容为指定关键字的数据

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        String category = searchMap.get("category");
        if (!StringUtils.isEmpty(category)) {
            boolQueryBuilder.must(QueryBuilders.termQuery("categoryName",category));
        }


        nativeSearchQueryBuilder.withFilter(boolQueryBuilder);


        SearchQuery query = nativeSearchQueryBuilder.build();
        AggregatedPage<SkuInfo> skuInfos = elasticsearchTemplate.queryForPage(query, SkuInfo.class);
        //获取结果（总记录数，总页数，当前页的记录等数据）
        List<SkuInfo> content = skuInfos.getContent();
        long totalElements = skuInfos.getTotalElements();
        int totalPages = skuInfos.getTotalPages();

        List<String> categoryList = getStrings(skuInfos, "skuCategorygroup");

        List<String> brandList = getStrings(skuInfos, "skuBrandgroup");

        StringTerms stringTerms = (StringTerms) skuInfos.getAggregation("skuSpecgroup");
        Map<String, Set<String>> specMap = getStringSetMap(stringTerms);
        // 组装到map中返回
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("rows",content );
        resultMap.put("totalPages",totalPages );
        resultMap.put("total",totalElements );
        resultMap.put("categoryList",categoryList);
        resultMap.put("brandList",brandList);
        resultMap.put("specMap",specMap);
        return resultMap;
    }

    private Map<String, Set<String>> getStringSetMap(StringTerms stringTermsSpec) {
        Map<String, Set<String>> specMap = new HashMap<>();
        if (stringTermsSpec!=null) {
            Set<String> values = new HashSet<>();
            for (StringTerms.Bucket bucket : stringTermsSpec.getBuckets()) {
                String keyAsString = bucket.getKeyAsString();
                Map<String,String> map = JSON.parseObject(keyAsString, Map.class);
                for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                    String key = stringStringEntry.getKey();
                    String value = stringStringEntry.getValue();
                    values = specMap.get(key);
                    if (values==null) {
                        values = new HashSet<String>();
                    }
                    values.add(value);
                    specMap.put(key,values);
                }
            }
        }
        return specMap;
    }
    private static List<String> getStrings(AggregatedPage<SkuInfo> skuInfos, String skuCategorygroup) {
        List<String> categoryList = new ArrayList<>();
        StringTerms stringTerms = (StringTerms) skuInfos.getAggregation(skuCategorygroup);
        if (stringTerms!=null) {
            for (StringTerms.Bucket bucket : stringTerms.getBuckets()) {
                categoryList.add(bucket.getKeyAsString());
            }
        }
        return categoryList;
    }
}
