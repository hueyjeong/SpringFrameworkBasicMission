package net.jayzen.springframeworkbasic.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.jayzen.springframeworkbasic.aop.TransactionAdvisor;
import net.jayzen.springframeworkbasic.repository.MemberRepository;
import net.jayzen.springframeworkbasic.repository.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("net.jayzen.springframeworkbasic")
public class RepoConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RepoConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Bean
    public MemberRepository memberRepository(EntityManager entityManager) {
        return new MemberRepositoryImpl(entityManager);
    }

//    @Bean
//    @Scope("prototype")
//    public TransactionAdvisor transactionAdvisor(PlatformTransactionManager platformTransactionManager) {
//        return new TransactionAdvisor(platformTransactionManager);
//    }
}
