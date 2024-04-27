package com.example.shubam.inmemorycache2k.rest;

import com.example.shubam.inmemorycache2k.config.InMemoryCacheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
