package org.example.chap08.spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
    private MemberDao memberDao;

    @Transactional // 두 개 이상의 쿼리문을 하나의 작업으로 간주하여 쿼리문이 하나라도 실패하면 롤백함
    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null)
            throw new MemberNotFoundException();
        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
}
