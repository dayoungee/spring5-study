package org.example.chap07.main;

import org.example.chap07.Calculator;
import org.example.chap07.config.AppCtxWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                 new AnnotationConfigApplicationContext(AppCtxWithCache.class);

         Calculator cal = ctx .getBean("calculator", Calculator. class);
         cal.factorial(7);
         cal.factorial(7);
         cal.factorial(5);
         cal.factorial(5);
         ctx.close();

    }
}
