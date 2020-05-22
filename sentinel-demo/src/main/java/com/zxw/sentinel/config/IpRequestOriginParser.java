package com.zxw.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuhongyun
 * @date 2020/5/22 15:29
 */
public class IpRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRemoteAddr();
    }
}
