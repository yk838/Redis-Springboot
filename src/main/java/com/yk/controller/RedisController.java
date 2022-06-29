package com.yk.controller;

import com.yk.service.RedisService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("dog")
public class RedisController {
    @Resource
    private RedisService redisService;
    @Cacheable(key = " 'allDogName' ", value = "selectList")
    //value就是之前在RedisConfig中定义的命名空间，也是缓存保存的空间
    //key就是缓存保存的key,这里以方法名为key,但是为避免方法名重复导致的key重复，所以加入id,来避免重复
    @GetMapping("/getAllDogName")
    public List<String> getAllDogName() {
        return redisService.getAllDogName();
    }
}
