package com.example.shubam.inmemorycache2k.inmemorycache.cachefactory;

import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Builder
@Getter
public class InMemoryCacheEntry <K,V>{
    private K key;
    private V value;
    private Optional<Long> ttl;
}
