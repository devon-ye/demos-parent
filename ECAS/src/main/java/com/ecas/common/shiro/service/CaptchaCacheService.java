package com.ecas.common.shiro.service;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.InitializingBean;

public class CaptchaCacheService  implements PasswordService,InitializingBean {
    private CacheManager cacheManager;
    private Cache<String,String> cache;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public String encryptPassword(Object var1) throws IllegalArgumentException{
        return  null;
    }

    @Override
    public boolean passwordsMatch(Object var1, String var2){
      return false;
    }
}
