package com.zxw.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author wuhongyun
 * @date 2020/5/22 14:20
 */
@Configuration
public class SentinelConfig {

    @PostConstruct
    public void init() {
        WebCallbackManager.setUrlBlockHandler(new DemoUrlBlockHander());
        WebCallbackManager.setRequestOriginParser(new IpRequestOriginParser());
    }
}
