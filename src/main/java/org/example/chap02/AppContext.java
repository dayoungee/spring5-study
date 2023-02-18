package org.example.chap02;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 해당 클래스를 스프링 설정 클래스로 지정한다.
@Configuration
public class AppContext {
    @Bean
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s,안녕하세요!") ;
        return g;
    }

    @Bean
    public Greeter greeter2() {
        Greeter g = new Greeter();
        g.setFormat("%s,안녕하세요!") ;
        return g;
    }
}
