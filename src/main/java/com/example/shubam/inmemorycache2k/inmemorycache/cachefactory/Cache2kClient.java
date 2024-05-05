package com.example.shubam.inmemorycache2k.inmemorycache.cachefactory;

import com.example.shubam.inmemorycache2k.config.InMemoryCacheConfig;
import com.example.shubam.inmemorycache2k.inmemorycache.cacheloader.ICacheLoader;
import lombok.NonNull;
import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;
import org.cache2k.io.CacheLoader;

public class Cache2kClient<K,V> implements InMemoryCacheClient<K,V>{

    Cache<K,V> cache2KClient;

    public Cache2kClient(ICacheLoader<K,V> cacheLoader, InMemoryCacheConfig.InMemoryCacheProperties cacheProperties, Class<K> keyType, Class<V> valueType){
        initCacheClient(cacheLoader,cacheProperties, keyType,valueType);
    }


    private void  initCacheClient(ICacheLoader<K,V> cacheLoader, InMemoryCacheConfig.InMemoryCacheProperties cacheProperties, Class<K> keyType, Class<V> valueType){

        CacheLoader<K, V> customLoader = new CacheLoader<>() {
            @Override
            public @NonNull V load(@NonNull K k) throws Exception {
                return cacheLoader.load(k);
            }
        };

        Cache2kBuilder<K,V> builder =  Cache2kBuilder.of(keyType,valueType);
        builder.expireAfterWrite(cacheProperties.getTtl(), cacheProperties.getTtlTimeUnits());
        builder.loader(customLoader);
        cache2KClient = builder.build();
    }

    @Override
    public InMemoryCacheEntry<K, V> get(K key) {
        V value = cache2KClient.get(key);
        return InMemoryCacheEntry.<K,V>builder().value(value).build();
    }

    @Override
    public void put(InMemoryCacheEntry<K, V> entry) {
        cache2KClient.put(entry.getKey(), entry.getValue());
    }

    @Override
    public boolean remove(K key) {
        cache2KClient.remove(key);
        return true;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public void flushCache() {
        cache2KClient.clear();
    }

    @Override
    public Cache getStats(){
        return cache2KClient;
    }

}
