package net.jayzen.springframeworkbasic.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import net.jayzen.springframeworkbasic.domain.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Qualifier("MemberRepositoryMemVer")
public class MemberRepositoryMemVer implements MemberRepository {
    private static final Map<Long, Member> memberMap = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Member save(Member member) throws Exception {
        if (member.getId() == null) {
            member.setId(sequence.incrementAndGet());
        } else {
            throw new Exception("잘못된 입력입니다.");
        }

        if (memberMap.containsKey(member.getId())) {
            throw new Exception("이미 존재하는 아이디입니다.");
        }

        memberMap.put(member.getId(), member);

        return member;
    }

    @Override
    public List<Member> findAll() {
        return memberMap.values().stream().toList();
    }

    @PostConstruct
    public void initialize() throws Exception {
        save(new Member(null, "test1", "123456", "테스트1"));
        save(new Member(null, "test2", "123456", "테스트2"));
        save(new Member(null, "test3", "123456", "테스트3"));
        save(new Member(null, "test4", "123456", "테스트4"));
        save(new Member(null, "test5", "123456", "테스트5"));
        System.out.println("리포지토리 초기 멤버 설정됨 : " + findAll().size() + "개");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("리포지토리 반환됨");
    }
}
