package com.example.shubam.inmemorycache2k.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "in-memory-cache")
public class InMemoryCacheConfig {

    Boolean isPreloadEnabled;
    Map<InMemoryCacheTypes,InMemoryCacheProperties> cacheProperties;

    public enum InMemoryCacheTypes {
        VELOCITY, SUC;
    }

    public enum Client{
        CACHE2K, CACHE3K, CACHE4K;
    }

    @Data
    public static class InMemoryCacheProperties {
        private long ttl;
        private String name;
        private String  ttlTimeUnits;
        private long size;
        private long refreshRate;
        private String refreshTimeUnit;
        private Client client =Client.CACHE4K;
    }
}
