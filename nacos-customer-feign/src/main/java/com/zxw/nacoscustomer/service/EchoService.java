package com.zxw.nacoscustomer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuhongyun
 * @date 2020/5/21 16:57
 */
@FeignClient("nacos-privider")
public interface EchoService {
    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);
}
