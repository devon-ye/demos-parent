package com.ecas.common.shiro.service;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.InitializingBean;

public class CaptchaCacheService  implements InitializingBean {
    private CacheManager cacheManager;
    private Cache<String,String> cache;

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
