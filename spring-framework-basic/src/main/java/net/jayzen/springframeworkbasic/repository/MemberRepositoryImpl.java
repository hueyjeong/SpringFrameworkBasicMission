package net.jayzen.springframeworkbasic.repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import net.jayzen.springframeworkbasic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Primary
@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private final EntityManager entityManager;
    @Autowired
    public MemberRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Member save(Member member) throws Exception {
        System.out.println(this.toString());
        if (!entityManager.createQuery("select m from Member m where m.username = :username", Member.class).setParameter("username", member.getUsername()).getResultList().isEmpty()) {
            throw new Exception("중복된 Username이 존재합니다.");
        } else if (!entityManager.createQuery("select m from Member m where m.nickname = :nickname", Member.class).setParameter("nickname", member.getNickname()).getResultList().isEmpty()) {
            throw new Exception("중복된 Nickname이 존재합니다.");
        }

        entityManager.persist(member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m", Member.class).getResultList();
    }
}
