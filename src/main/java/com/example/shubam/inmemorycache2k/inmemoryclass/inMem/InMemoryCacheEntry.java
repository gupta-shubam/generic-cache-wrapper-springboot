package com.example.shubam.inmemorycache2k.inmemoryclass.inMem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InMemoryCacheEntry <K,V>{
    private K key;
    private V value;
}
