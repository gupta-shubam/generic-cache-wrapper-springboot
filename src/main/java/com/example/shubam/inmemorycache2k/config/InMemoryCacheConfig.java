package com.example.shubam.inmemorycache2k.config;
import com.example.shubam.inmemorycache2k.inmemorycache.cachefactory.Cache2kClient;
import com.example.shubam.inmemorycache2k.inmemorycache.cachefactory.InMemoryCacheClient;
import com.example.shubam.inmemorycache2k.inmemorycache.cacheloader.ICacheLoader;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
@Configuration
@ConfigurationProperties(prefix = "in-memory-cache")
public class InMemoryCacheConfig {

    Boolean isPreloadEnabled;
    Map<InstanceType,InMemoryCacheProperties> cacheProperties;

    public enum InstanceType {
        VELOCITY, SUC;
    }

    public enum Client{
        CACHE2K {
            @Override
            public <K, V> InMemoryCacheClient<K, V> create(InMemoryCacheProperties props, ICacheLoader<K, V> loader, Class<K> keyType, Class<V> valueType) {
                return new Cache2kClient<>(loader, props, keyType, valueType);
            }
        };

        public abstract <K,V> InMemoryCacheClient<K,V> create(InMemoryCacheProperties props, ICacheLoader<K,V> loader, Class<K> keyType, Class<V> valueType);
    }

    @Data
    public static class InMemoryCacheProperties {
        private long ttl;
        private String name;
        private TimeUnit ttlTimeUnits;
        private long size;
        private long refreshRate;
        private TimeUnit refreshTimeUnit;
        private Client client =Client.CACHE2K;
        private String loader;
        private String keyType;
        private String valueType;
    }
}
