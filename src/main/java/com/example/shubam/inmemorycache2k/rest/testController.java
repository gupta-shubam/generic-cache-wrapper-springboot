package com.example.shubam.inmemorycache2k.rest;

import com.example.shubam.inmemorycache2k.config.InMemoryCacheConfig;
import com.example.shubam.inmemorycache2k.inmemorycache.cachefactory.InMemoryCacheAbstractFactory;
import org.cache2k.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    InMemoryCacheConfig config;

    @GetMapping("/config")
    Object getConfig(){
        var props = config.getCacheProperties();
        return props;
    }

    @Autowired
    InMemoryCacheAbstractFactory cacheFactory;

    @GetMapping("/cache/suc/{key}")
    Object getSUCKey(@PathVariable String key){
        return cacheFactory.getCacheClient(InMemoryCacheConfig.InstanceType.SUC).get("abc");
    }


    @GetMapping("/cache/velocity/{key}")
    Object getVKey(@PathVariable String key){
        var value = cacheFactory.getCacheClient(InMemoryCacheConfig.InstanceType.VELOCITY).get(key);
        Cache client = cacheFactory.getCacheClient(InMemoryCacheConfig.InstanceType.VELOCITY).getStats();
        return value;
    }

    @GetMapping("/cache/velocity/stats")
    Object getVStats(){
        return cacheFactory.getCacheClient(InMemoryCacheConfig.InstanceType.VELOCITY).getStats();
    }



    @GetMapping("/cache/velocity/client")
    Object getVClient(){
        return cacheFactory.getCacheClient(InMemoryCacheConfig.InstanceType.VELOCITY);
    }

}
