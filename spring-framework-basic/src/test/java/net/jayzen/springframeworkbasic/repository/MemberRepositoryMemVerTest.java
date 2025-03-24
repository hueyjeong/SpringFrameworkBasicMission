package net.jayzen.springframeworkbasic.repository;

import net.jayzen.springframeworkbasic.SpringFrameworkBasicApplication;
import net.jayzen.springframeworkbasic.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryMemVerTest {

    @Test
    void save() throws Exception {
        var context = new AnnotationConfigApplicationContext(SpringFrameworkBasicApplication.class);
        var memberRepository = context.getBean(MemberRepositoryMemVer.class);
        var member = memberRepository.save(new Member(null, "test6", "123456", "test6"));
        Assertions.assertThat(member.getId()).isNotNull();
        context.close();
    }
}