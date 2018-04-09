package com.redis.demo.writer;

import org.springframework.data.redis.cache.RedisCacheWriter;

import java.time.Duration;

public class RedisCacheWriterImpl implements RedisCacheWriter {

    @Override
    public void put(String name, byte[] key, byte[] value, Duration ttl) {

    }

    @Override
    public byte[] get(String name, byte[] key) {
        return new byte[0];
    }

    @Override
    public byte[] putIfAbsent(String name, byte[] key, byte[] value, Duration ttl) {
        return new byte[0];
    }

    @Override
    public void remove(String name, byte[] key) {

    }

    @Override
    public void clean(String name, byte[] pattern) {

    }
}
