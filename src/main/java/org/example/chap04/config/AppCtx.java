package org.example.chap04.config;

import org.example.chap04.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Assembler 클래스와 비슷한 스프링의 조립기
// 스프링은 DI를 지원하는 조립기이다.
@Configuration
public class AppCtx {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterSvc(){
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePasswordSvc(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
        // 의존을 주입하지 않아도 스프링이 Autowired 가 붙인 필드에
        // 해당 타입의 빈 객체를 찾아서 주입한다
        return pwdSvc;
    }

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
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        return new MemberInfoPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
