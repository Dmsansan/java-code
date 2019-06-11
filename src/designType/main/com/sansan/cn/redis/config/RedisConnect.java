package designType.main.com.sansan.cn.redis.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnect {

    // 服务IP地址
    private static String ADDR = "192.168.42.128";

    // 端口号
    private static int PORT = 6379;

    // 密码
    private static String AUTH = "123456";

    // 最大连接数
    private static int MAX_ACTIVE = 1024;
    private static int MAX_IDLE = 200;
    private static int MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;

    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;

    /**
     * 初始化redis连接池
     */
    static {
        try{
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis(){
        try{
            if(jedisPool != null){
                Jedis resource = jedisPool.getResource();
                return resource;
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if(jedis != null) {
            jedisPool.returnResource(jedis);
        }

    }

}
