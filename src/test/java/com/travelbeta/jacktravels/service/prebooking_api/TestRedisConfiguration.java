package com.travelbeta.jacktravels.service.prebooking_api;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Assert;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Brume
 **/
public class TestRedisConfiguration {

    private static int REDIS_PORT = 6379;
    private static String REDIS_HOST = "172.105.73.58";

    private final RedisTemplate redisTemplate = null;

    Boolean isKeyAvailable = redisTemplate.hasKey(insertintoRedis ());


    @Bean
    public JedisConnectionFactory redisConnectionFactory( String ins) {

        RedisStandaloneConfiguration connectionFactory = new RedisStandaloneConfiguration ();
        connectionFactory.setHostName ( REDIS_HOST );
        connectionFactory.setPort ( REDIS_PORT );

        return new JedisConnectionFactory ( connectionFactory );

    }
    private String checkRedisCache(String redisKey){
        val valueOperations = redisTemplate.opsForValue();
        return String.valueOf ( valueOperations.get(redisKey) );
    }
    public static String insertintoRedis() {
        String redis = "brume";
        val stringBuilder = new StringBuilder ();
        return stringBuilder.append ( redis + 1 )
                .append ( redis + 122 )
                .toString ();

    }




    public void testRedisResult() {

        Assert.assertTrue ( isKeyAvailable );
        Assert.assertEquals ( checkRedisCache ( "1112" ), insertintoRedis () );
    }

    public static void main(String[] args) {
        System.out.println ( insertintoRedis () );
    }
}