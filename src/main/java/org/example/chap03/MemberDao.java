package org.example.chap03;

import java.util.HashMap ;
import java.util.Map;
import java.util.Collection;
public class MemberDao {
    private static long nextld = 0;
    private Map<String, Member> map = new HashMap<>();

    public Member selectByEmail(String email) {
        return map.get(email);
    }

    public void insert(Member member) {
        member.setId(++nextld);
        map.put(member.getEmail(), member);
    }

    public void update(Member member) {
        map.put(member.getEmail(), member);
    }

    public Collection<Member> selectAll() {
        return map.values();
    }

}