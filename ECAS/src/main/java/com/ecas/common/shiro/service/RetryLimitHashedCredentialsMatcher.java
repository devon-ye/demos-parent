package com.ecas.common.shiro.service;

import com.ecas.common.shiro.security.MyPasswordHash;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.InitializingBean;

public class RetryLimitHashedCredentialsMatcher  extends HashedCredentialsMatcher implements InitializingBean {

    private final CacheManager cacheManager;
    private MyPasswordHash myPasswordHash;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager, MyPasswordHash myPasswordHash) {
        this.cacheManager = cacheManager;
        this.myPasswordHash = myPasswordHash;
    }

    public RetryLimitHashedCredentialsMatcher(String hashAlgorithmName, CacheManager cacheManager, MyPasswordHash myPasswordHash) {
        super(hashAlgorithmName);
        this.cacheManager = cacheManager;
        this.myPasswordHash = myPasswordHash;
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
       // super.doCredentialsMatch(token,info);
        Object tokenHashedCredentials = this.hashProvidedCredentials(token, info);
        Object accountCredentials = this.getCredentials(info);
        return this.equals(tokenHashedCredentials, accountCredentials);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.setHashAlgorithmName(myPasswordHash.getAlgorithmName());
        super.setHashIterations(myPasswordHash.getHashIterations());
    }
}
