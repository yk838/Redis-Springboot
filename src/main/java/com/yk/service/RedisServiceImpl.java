package com.yk.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Override
    public List<String> getAllDogName() {
        //这里我没有连接数据库，所以模拟一个方法当作从数据库中取数据
        List<String> list = getAllDogNameFromSql();
        return list;
    }

    private List<String> getAllDogNameFromSql() {
        System.out.println("=======从mysql数据库读取数据");
        List<String> list = Arrays.asList("Adog", "Bdog", "Cdog", "Ddog");
        System.out.println("=======数据读取完成");
        return list;
    }
}
