package net.jayzen.springframeworkbasic.repository;

import net.jayzen.springframeworkbasic.domain.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member) throws Exception;

    List<Member> findAll();
}
