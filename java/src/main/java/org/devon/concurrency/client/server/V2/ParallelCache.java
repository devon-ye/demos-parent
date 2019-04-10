package org.devon.concurrency.client.server.V2;

import org.devon.concurrency.client.server.concurrent.service.CacheItem;
import org.devon.concurrency.client.server.concurrent.service.CleanCacheTask;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dewen.ye
 * @date 2019/3/3 20:58
 */
public class ParallelCache {
    private static int MAX_LIVING_TIME_MILLIS = 600 * 1000;
    private final ConcurrentHashMap<String, CacheItem> cache;
    private final CleanCacheTask task;
    private final Thread thread;

    public ParallelCache() {
        cache = new ConcurrentHashMap<>();
        task = new CleanCacheTask(this);
        thread = new Thread(task);
        thread.start();
    }

    public String get(String command) {
        CacheItem item = cache.get(command);
        if (item == null) {
            return null;
        }
        item.setAccessTime(System.currentTimeMillis());
        return item.getReponse();
    }

    public void put(String key, String value) {
        CacheItem item = new CacheItem(key, value);
        cache.put(key, item);
    }

    public void clean() {
        long revisionDate = System.currentTimeMillis();
        Iterator<CacheItem> cacheItemIter = cache.values().iterator();
        while (cacheItemIter.hasNext()) {
            CacheItem cacheItem = cacheItemIter.next();
            if (revisionDate - cacheItem.getAccessTime() > MAX_LIVING_TIME_MILLIS) {
                cacheItemIter.remove();
            }
        }
    }

    public void shutDown() {
        thread.interrupt();
    }

    public int size() {
        return cache.size();
    }
}
