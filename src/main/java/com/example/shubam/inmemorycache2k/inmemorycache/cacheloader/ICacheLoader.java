package com.example.shubam.inmemorycache2k.inmemorycache.cacheloader;

import lombok.NonNull;

@FunctionalInterface
public interface ICacheLoader<K,V> {
    V load(K key);
}
