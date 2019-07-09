package designType.main.com.sansan.cn.mysql;

import com.alibaba.fastjson.JSON;
import designType.main.com.sansan.cn.redis.config.RedisConnect;
import redis.clients.jedis.Jedis;

import java.util.List;

public class TestMysql {

    public static void main(String[] args) {
        Jedis jedis = RedisConnect.getJedis();
        String redisKey = "userInfo";

        long redisStr = System.currentTimeMillis();
        String s = jedis.get(redisKey);
        long redisEnd = System.currentTimeMillis();

        if (s != null) {
            System.out.println("查询数据时间：" + (redisEnd - redisStr));
            List<UserInfo> list = JSON.parseArray(s, UserInfo.class);
            System.out.println("从redis 缓存数据库加载数据");
            for (UserInfo userInfo : list) {
                System.out.println(userInfo.getId() + userInfo.getUserCode() +
                        userInfo.getUserName() + userInfo.getCreateTime());
            }

        } else {
            long mysqlStr = System.currentTimeMillis();
            List<UserInfo> list = UserOperation.getInstance().selectUserInfo();
            long mysqlEnd = System.currentTimeMillis();
            System.out.println("查询数据时间：" + (mysqlEnd - mysqlStr));

            System.out.println("从mysql 数据库获取数据");
            for (UserInfo userInfo : list) {
                System.out.println(userInfo.getId() + userInfo.getUserCode() +
                        userInfo.getUserName() + userInfo.getCreateTime());
            }

            String userJson = JSON.toJSONString(list);

            jedis.set(redisKey, userJson);
            jedis.expire(redisKey, 20000);
        }

    }
}
