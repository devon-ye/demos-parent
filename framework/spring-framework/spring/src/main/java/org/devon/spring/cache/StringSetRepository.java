package org.devon.spring.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;


import redis.clients.jedis.JedisPool;
import java.util.Set;

@Component
public class StringSetRepository {

    @Autowired
    private RedisTemplate<String,Set> redisTemplate;


    public void add(String key,Set value){

        redisTemplate.opsForSet().add(key,value);
    }

    public void list(String key){
        SetOperations<String,Set> setSetOperations =  redisTemplate.opsForSet();
       Set set =setSetOperations.members(key);
        for (Object o : set) {
            System.out.printf("o:"+o);
        }

    }
}
