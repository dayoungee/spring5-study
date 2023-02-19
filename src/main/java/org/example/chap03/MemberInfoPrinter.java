package org.example.chap03;

import org.example.chap03.Member;
import org.example.chap03.MemberDao;
import org.example.chap03.MemberPrinter;

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

    public void setMemberDao(MemberDao memberDao){
        this.memDao = memberDao;
    }

    public void setPrinter(MemberPrinter printer){
        this.printer = printer;
    }
}
