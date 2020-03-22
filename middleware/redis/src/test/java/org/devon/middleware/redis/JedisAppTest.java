package org.devon.middleware.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author devon.ye
 * @datetime 2020/2/28 11:21 下午
 * @since
 */
public class JedisAppTest {
    private JedisPool jedisPool;
    private Jedis jedis;
	@Before
	public void setUp() throws Exception {
		jedisPool = new JedisPool("127.0.0.1",6379);
		jedis = jedisPool.getResource();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void  add() {
		jedis.set("test1","value2");
		String VALUE = jedis.get("test1");
		Map<String,String> hash= new HashMap<>();
		hash.put("name","devon");
		hash.put("age","19");
		jedis.hset("hash",hash);
		jedis.incr("count");
		System.out.println(jedis.hgetAll("hash"));
		jedis.lindex("list",0);

		jedis.sadd("myset","a","b","m","n","u","k","o","h");
	}


	@Test
	public void  test() {
		jedis.setex("key",10000,"value");  //set and expire
		jedis.setnx("","");
		jedis.del("");
		jedis.ttl("");
		jedis.keys("pattern");
		jedis.lpushx("");
	}

	@Test
	public void scard() {
	}

	@Test
	public void smembers() {
	}

	@Test
	public void sIsMember() {
	}

	@Test
	public void sdiff() {
	}

	@Test
	public void sdiffStore() {
	}

	@Test
	public void sinter() {
	}

	@Test
	public void sinterStore() {
	}

	@Test
	public void smove() {
	}

	@Test
	public void spop() {
	}

	@Test
	public void srandMember() {
	}

	@Test
	public void srem() {
	}

	@Test
	public void sunion() {
	}

	@Test
	public void sunionStore() {
	}
}