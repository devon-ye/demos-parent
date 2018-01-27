package com.ecas.common.shiro.security;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class MyPasswordHash implements InitializingBean {
    private String algorithmName;
    private int hashIterations;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasLength(algorithmName, "algorithmName mast be MD5、SHA-1、SHA-256、SHA-384、SHA-512");
    }

    public String totoBase64(Object source,Object salt) {
        return  toHashByShiro(algorithmName,  source,  salt,  hashIterations);
    }

    public String toHashByShiro(String algorithmName, Object source, Object salt, int hashIterations) {
        return new SimpleHash( algorithmName,  source,  salt,  hashIterations).toBase64();
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getHashIterations() {
        return hashIterations;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }





}
