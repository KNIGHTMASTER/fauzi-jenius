package com.wissensalt.rnd.fj.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${jedis.host}")
    private String jedisHost;
    @Value("${jedis.port}")
    private Integer jedisPort;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setMinIdle(2);
        poolConfig.setMaxIdle(5);

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(jedisPort);
        connectionFactory.setHostName(jedisHost);
        connectionFactory.setUsePool(true);
        return connectionFactory;
    }

}
