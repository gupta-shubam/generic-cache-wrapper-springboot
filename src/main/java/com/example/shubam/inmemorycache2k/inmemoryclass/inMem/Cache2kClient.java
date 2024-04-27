package com.example.shubam.inmemorycache2k.inmemoryclass.inMem;


import com.example.shubam.inmemorycache2k.config.InMemoryCacheConfig;

import java.util.function.Function;

public class Cache2kClient<K,V> implements InMemoryCacheClient<K,V>{

    String cache2KClient;

    public Cache2kClient(Function<K,V> cacheLoader, InMemoryCacheConfig.InMemoryCacheProperties cacheProperties){
        this.cache2KClient = cacheProperties.getName();
    }


    @Override
    public InMemoryCacheEntry<K, V> get(K key) {
        return null;
    }

    @Override
    public void put(InMemoryCacheEntry<K, V> entry) {

    }

    @Override
    public boolean remove(K key) {

        return false;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public void flushCache() {

    }

}
