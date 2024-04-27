package com.example.shubam.inmemorycache2k.inmemoryclass.inMem;

public interface InMemoryCacheClient<K,V> {

    public V get(K key);

    public void put(K key, V value);

    public void remove(K key);

    public boolean containsKey(K key);

}
