package com.muscleape.influxdb;

import org.influxdb.dto.QueryResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfluxdbDemoApplicationTests {

    @Resource
    InfluxDBConnect influxDBConnect;

    @Test
    public void contextLoads() {
        System.out.println("Test Start");
    }

    @Test
    public void testInsert() {
        Map<String, String> tagsMap = new HashMap<>();
        Map<String, Object> fieldsMap = new HashMap<>();
        long startMillis = System.currentTimeMillis();
//        System.out.println("influxDB start time :" + System.currentTimeMillis());
//        int i = 0;
//        for (int j = 0; j <= 2000000; j++) {
//            tagsMap.put("user_id", String.valueOf(i % 10));
//            tagsMap.put("url", "http://www.baidu.com");
//            tagsMap.put("service_method", "testInsert" + (i % 5));
//            fieldsMap.put("count", i % 5);
//            influxDBConnect.insert("usage", tagsMap, fieldsMap);
//            i++;
//        }

        String command = "select * from usage limit 100";

        QueryResult query = influxDBConnect.query(command);
        List<QueryResult.Result> results = query.getResults();
        List<List<Object>> values = results.get(0).getSeries().get(0).getValues();
        long endMillis = System.currentTimeMillis();
        System.out.println("influxDB execute time :" + (endMillis - startMillis));
        System.out.println("数据表总共的数据条数：" + values.size());
    }

}
