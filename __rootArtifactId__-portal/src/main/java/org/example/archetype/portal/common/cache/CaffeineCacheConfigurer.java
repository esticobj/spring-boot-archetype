package org.example.archetype.portal.common.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheConfigurer {

    public static final Logger logger = LoggerFactory.getLogger(CaffeineCacheConfigurer.class);

    @Bean
    @Primary
    public CacheManager caffeineCacheManager(CacheLoader<Object, Object> cacheLoader) {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                //cache的初始容量值
                .initialCapacity(100)
                //maximumSize用来控制cache的最大缓存数量，maximumSize和maximumWeight(最大权重)不可以同时使用，
                .maximumSize(1000)
                //最后一次写入或者访问后过久过期
                .expireAfterAccess(10, TimeUnit.SECONDS)
                //创建或更新之后多久刷新,需要设置cacheLoader
                .refreshAfterWrite(10, TimeUnit.SECONDS);
        cacheManager.setCaffeine(caffeine);
        cacheManager.setCacheLoader(cacheLoader);
//        cacheManager.setCacheNames(names);//根据名字可以创建多个cache，但是多个cache使用相同的策略
        cacheManager.setAllowNullValues(false);//是否允许值为空
        return cacheManager;
    }

    /**
     * 必须要指定这个Bean，refreshAfterWrite配置属性才生效
     */
    @Bean
    public CacheLoader<Object, Object> cacheLoader() {
        return new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object key) throws Exception { return null;}
            // 重写这个方法将oldValue值返回回去，进而刷新缓存
            @Override
            public Object reload(Object key, Object oldValue) throws Exception {
                logger.info("--refresh--:"+key);
                return oldValue;
            }
        };
    }
}
