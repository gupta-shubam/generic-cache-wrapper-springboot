package com.example.shubam.inmemorycache2k.inmemorycache.cacheloader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("SUCLoader")
public class SUCLoader implements ICacheLoader<String,String> {

    @Override
    public String load(String key) {
        log.info("PERFORMING EXPENSIVE OPERATION");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "suc-" + key;
    }

}
