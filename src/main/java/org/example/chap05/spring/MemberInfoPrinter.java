package org.example.chap05.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
* 설정 메서드 주입 방식
* : 세터 메서드이름을 통해 어떤 의존 객체가 주입되는지 알 수 있다.
* */
// Component 애노테이션 이름에 따라 빈으로 등록할 때,결정된다.
// 값을 주지 않으면, 클래스 이름의 첫글자를 소문자로 바꾼 이름을 빈 이름으로 사용한다.
@Component("infoPrinter")
public class MemberInfoPrinter {
    private MemberDao memDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email){
        Member member = memDao.selectByEmail(email);
        if(member == null){
            System.out.println("데이터 없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }
    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memDao = memberDao;
    }
    @Autowired
    @Qualifier("printer") // printer 인 빈을 의존 주입 후보로 사용한다.
    public void setPrinter(MemberPrinter printer){
        this.printer = printer;
    }
}
