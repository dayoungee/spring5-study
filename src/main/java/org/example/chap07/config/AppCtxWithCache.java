package org.example.chap07.config;

import org.example.chap07.Calculator;
import org.example.chap07.RecCalculator;
import org.example.chap07.aspect.CacheAspect;
import org.example.chap07.aspect.ExeTimeAspect;
import org.springframework.context.annotation.Bean;

public class AppCtxWithCache {
    @Bean
    public CacheAspect cacheAspect(){
        return new CacheAspect();
    }

    @Bean
    public ExeTimeAspect exeTimeAspect(){
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
