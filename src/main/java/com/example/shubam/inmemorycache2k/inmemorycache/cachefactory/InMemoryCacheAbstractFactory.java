package com.example.shubam.inmemorycache2k.inmemorycache.cachefactory;

import com.example.shubam.inmemorycache2k.config.InMemoryCacheConfig;
import com.example.shubam.inmemorycache2k.inmemorycache.cacheloader.ICacheLoader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.shubam.inmemorycache2k.inmemorycache.utils.TypeUtils.getTypeFromTypeName;
import static com.example.shubam.inmemorycache2k.inmemorycache.utils.TypeUtils.resolveType;


@Service
public class InMemoryCacheAbstractFactory {

    @Autowired
    InMemoryCacheConfig cacheConfig;

    @Autowired
    ApplicationContext applicationContext;

    private Map<InMemoryCacheConfig.InstanceType,InMemoryCacheClient<Object,Object>> caches;

    @PostConstruct
    void init(){
        caches = new HashMap<>();
        cacheConfig.getCacheProperties().forEach((key, value) -> caches.put(key, createCacheClient(value)));
    }

    public <K,V> InMemoryCacheClient<K,V> getCacheClient (InMemoryCacheConfig.InstanceType instanceType){
        return (InMemoryCacheClient<K,V>) caches.get(instanceType);
    }

    private  <K,V>InMemoryCacheClient<K,V> createCacheClient(InMemoryCacheConfig.InMemoryCacheProperties props) {

        Class<K> keyType = (Class<K>) resolveType(props.getKeyType());
        Class<V> valueType = (Class<V>) resolveType(props.getValueType());

        ICacheLoader<K,V> cacheLoader = null;
        if (Objects.nonNull(props.getLoader())) {
            cacheLoader = (ICacheLoader<K,V>) applicationContext.getBean(props.getLoader(), ICacheLoader.class);
        }
        return props.getClient().create(props, cacheLoader, keyType,valueType);
    }

}
