package com.kind1ess.springboot;

import com.kind1ess.springboot.entity.Employee;
import com.kind1ess.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


@SpringBootTest
class SpringBootLearn009CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier("employeeRedisTemplate")
    RedisTemplate employeeRedisTemplate;

    @Autowired
    @Qualifier("myCacheManager")
    RedisCacheManager redisCacheManager;
    @Test
    void contextLoads() {
        System.out.println(employeeMapper.getEmployeeById(1));
    }

    /**
     * Redis常见的五大数据类型
     * String（字符串）、list（线性表）、set（集合）、hash（散列表）、ZSet（有序集合）
     * stringRedisTemplate.opsForValue()[String字符串的]
     */
    @Test
    public void testRedis(){
//        stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    /**
     * 测试保存对象
     */
    @Test
    public void testRedisObj(){
        Employee employee = employeeMapper.getEmployeeById(1);
//        redisTemplate.opsForValue().set("emp-01",employee);     //employee需要实现序列化
        employeeRedisTemplate.opsForValue().set("emp-02",employee);
    }

    @Test
    public void testRedisPutCache(){
        System.out.println("取出数据");
        Cache cache = redisCacheManager.getCache("dept");
        Cache.ValueWrapper wrapper = cache.get("2");
        System.out.println(wrapper.get());
    }

}
