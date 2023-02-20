package org.example.chap04.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MemberRegisterService{
    @Autowired
    private MemberDao memberDao;
    // 변경된 부분, 생성자를 통한 의존 주입
    public MemberRegisterService(){
    }
    public MemberRegisterService(MemberDao memberDao){
    }

    public void regist(RegisterRequest req){
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null){
            // 이메일로 회원 데이터(Member 조회);
            throw new DuplicateMemberException("dup email " + req.getEmail());
        }
        // 같은 이메일을 가진 회원이 존재하지 않으면 DB에 삽입
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(),
                LocalDateTime. now());
        memberDao.insert(newMember) ;
    }
}
