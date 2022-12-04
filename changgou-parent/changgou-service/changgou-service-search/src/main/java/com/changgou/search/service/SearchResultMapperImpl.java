package com.changgou.search.service;

import com.alibaba.fastjson.JSON;
import com.changgou.SkuInfo;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Map;

//专门获取高亮数据 进行返回
public class SearchResultMapperImpl implements SearchResultMapper {
    @Override
    public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> aClass, Pageable pageable) {

        ArrayList<T> content = new ArrayList<T>();
        SearchHits hits = response.getHits();
        if (hits==null || hits.getTotalHits()<=0) {
            return new AggregatedPageImpl<T>(content);
        }
        for (SearchHit hit : hits) {
            SkuInfo skuInfo = JSON.parseObject(hit.getSourceAsString(), SkuInfo.class);
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if (highlightFields!=null && highlightFields.get("name")!=null && highlightFields.get("name").getFragments()!=null) {
                HighlightField highlightField = highlightFields.get("name");
                Text[] fragments = highlightField.fragments();
                StringBuffer sb = new StringBuffer();
                for (Text fragment : fragments) {
                    sb.append(fragment.string());
                }
                String s = sb.toString();
                if (!StringUtils.isEmpty(s)) {
                    skuInfo.setName(s);
                }
            }
            content.add((T)skuInfo);
        }
        long totalHits = hits.getTotalHits();
        Aggregations aggregations = response.getAggregations();
        return new AggregatedPageImpl<T>(content,pageable,totalHits,aggregations);
    }
}
