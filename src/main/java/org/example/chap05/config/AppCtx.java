package org.example.chap05.config;

import org.example.chap05.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Assembler 클래스와 비슷한 스프링의 조립기
// 스프링은 DI를 지원하는 조립기이다.
@Configuration
@ComponentScan(basePackages = {"org.example.chap05.spring"})
public class AppCtx {

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1(){
        return new MemberPrinter();
    }

    @Bean                 // 자동주입할 빈을 한정할 때 사용한다.
   // @Qualifier("printer") // 해당 빈의 한정값으로 "printer" 를 지정한다.
    @Qualifier("summaryPrinter")
    public MemberPrinter memberPrinter2(){
        return new MemberPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
