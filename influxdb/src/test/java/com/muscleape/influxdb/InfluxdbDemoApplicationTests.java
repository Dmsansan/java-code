package com.muscleape.influxdb;

import org.influxdb.dto.QueryResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public void testInsert() throws ParseException {
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

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = format.parse("2021-09-09 07:50:00");
        Date endDate = format.parse("2021-09-09 07:50:02");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.HOUR, 8);
        // 开始时间
        String startTime = format.format(calendar.getTime());

        calendar.setTime(endDate);
        calendar.add(Calendar.HOUR, 8);
        // 结束时间
        String endTime = format.format(calendar.getTime());

        // influxDB存在8个小时的时差
        String command = "select * from usage where time  >= '" + startTime + "' and  time <=  '" + endTime + "'  limit 100  tz('Asia/Shanghai')";

        QueryResult query = influxDBConnect.query(command);
        List<QueryResult.Result> results = query.getResults();
        if (results.get(0).getSeries() != null) {
            List<List<Object>> values = results.get(0).getSeries().get(0).getValues();
            long endMillis = System.currentTimeMillis();
            System.out.println("influxDB execute time :" + (endMillis - startMillis));
            System.out.println("数据表总共的数据条数：" + values.size());
        } else {
            System.out.println("该时间段的数据记录不存在");
        }

    }

}
