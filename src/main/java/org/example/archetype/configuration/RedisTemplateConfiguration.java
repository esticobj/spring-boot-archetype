package org.example.archetype.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplateConfiguration {
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, String> restTemplate = new RedisTemplate<>();
        restTemplate.setConnectionFactory(redisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        restTemplate.setKeySerializer(stringRedisSerializer);
        restTemplate.setHashKeySerializer(stringRedisSerializer);
        restTemplate.setHashValueSerializer(stringRedisSerializer);
        restTemplate.setStringSerializer(stringRedisSerializer);
        restTemplate.setValueSerializer(stringRedisSerializer);
        return restTemplate;
    }
}
