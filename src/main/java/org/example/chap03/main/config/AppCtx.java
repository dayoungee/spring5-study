package org.example.chap03.main.config;

import org.example.chap03.*;
import org.example.chap03.MemberInfoPrinter;
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
        // 생성자를 통한 의존주입
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordSvc(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
        // set메서드를 통한 의존 주입
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao());
        infoPrinter.setPrinter(memberPrinter());
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
