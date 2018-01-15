package com.ecas.util;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtilTesst {
    private static String IP = PropertiesFileUtil.getInstance("redis").get("master.redis.ip");

    // Redis的端口号
    private static int PORT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.port");

    // 访问密码
    private static String PASSWORD = AESUtil.aesDecode(PropertiesFileUtil.getInstance("redis").get("master.redis.password"));

    // 超时时间
    private static int TIMEOUT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.timeout");

    @Test
    public void test(){
        JedisPool pool = new JedisPool(new JedisPoolConfig(), IP, PORT, TIMEOUT);
        Jedis jedis = pool.getResource();
        jedis.auth("myredis");        //多了验证
        jedis.set("name", "cc");
        String name = jedis.get("name");
        System.out.println(name);
    }
}
