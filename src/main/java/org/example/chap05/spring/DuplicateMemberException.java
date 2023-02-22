package org.example.chap05.spring;

// 동일한 이메일을 갖오 있는 회원이 존재할 때, MemberRegisterService가 발생시키는 익셉션타입
public class DuplicateMemberException extends RuntimeException{
    public DuplicateMemberException(String message){
        super(message);
    }
}
