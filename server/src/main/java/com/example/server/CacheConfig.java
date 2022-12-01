package com.example.server;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@Configuration
public class CacheConfig {

  @Bean
  public RedisTemplate<String, Object> objectRedisTemplate(LettuceConnectionFactory connectionFactory) {
    RedisTemplate<String, Object> objectRedisTemplate = new RedisTemplate<String, Object>();
    objectRedisTemplate.setConnectionFactory(connectionFactory);
    return objectRedisTemplate;
  }
}
