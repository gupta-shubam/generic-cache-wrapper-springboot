package com.example.shubam.inmemorycache2k.inmemorycache.cachefactory;

import org.cache2k.Cache;

public interface InMemoryCacheClient<K,V> {

    public InMemoryCacheEntry<K,V> get(K key);

    public void put(InMemoryCacheEntry<K,V> entry);

    public boolean remove(K key);

    public boolean containsKey(K key);

    public void flushCache();

    Cache getStats();
}
