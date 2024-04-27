package com.example.shubam.inmemorycache2k.inmemoryclass.inMem;

public interface InMemoryCacheClient<K,V> {

    public InMemoryCacheEntry<K,V> get(K key);

    public void put(InMemoryCacheEntry<K,V> entry);

    public boolean remove(K key);

    public boolean containsKey(K key);

    public void flushCache();

}
