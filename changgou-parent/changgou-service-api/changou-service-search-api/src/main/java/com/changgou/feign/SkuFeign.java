package com.changgou.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "search",path = "/search")
public interface SkuFeign {
    @PostMapping
    public Map<String,Object> search(@RequestBody(required = false) Map<String,String> searchMap);
}
