package org.devon.spring.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import java.util.Collection;

public class GlobalCacheManager extends AbstractTransactionSupportingCacheManager {

    private  Collection<? extends Cache> caches;

    public GlobalCacheManager() {
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return caches;
    }


    public void setCaches(Collection<? extends Cache> caches){
        this.caches = caches;
    }
}
