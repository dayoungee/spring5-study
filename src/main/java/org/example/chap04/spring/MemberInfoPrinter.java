package org.example.chap04.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
* 설정 메서드 주입 방식
* : 세터 메서드이름을 통해 어떤 의존 객체가 주입되는지 알 수 있다.
* */
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
