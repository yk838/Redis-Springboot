package com.yk;


import com.yk.pojo.User;
import com.yk.util.RedisUtil;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class RedisSpringbootApplicationTests {
    @Resource
//    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        // redisTemplate 操作不同的数据类型，api和我们的指令是一样的
        // opsForValue 操作字符串 类似String
        // opsForList 操作List 类似List
        // opsForHah

        // 除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的CRUD

        // 获取连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //connection.flushDb();
        //connection.flushAll();

        redisTemplate.opsForValue().set("mykey","狂神说java");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    void test() {
        User user = new User("狂神shuo",18);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }
    @Autowired
    private RedisUtil redisUtil;
    @Test
    void test2() {
        redisUtil.set("name","yk");
        System.out.println(redisUtil.get("name"));
    }
    @Test
    void test3() {
//        redisUtil.set("name","yk");
        System.out.println(redisUtil.get("name"));
        redisUtil.expire("name",15);
        System.out.println(redisUtil.getExpire("name"));
        System.out.println(redisUtil.hasKey("name"));
    }

}
