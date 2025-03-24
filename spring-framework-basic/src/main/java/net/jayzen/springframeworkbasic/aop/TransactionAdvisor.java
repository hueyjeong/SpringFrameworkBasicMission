package net.jayzen.springframeworkbasic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
public class TransactionAdvisor {
    private final PlatformTransactionManager transactionManager;
    private TransactionStatus transactionStatus;

    @Autowired
    public TransactionAdvisor(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalPointcut() {

    }

    @Before("transactionalPointcut()")
    public void tranBefore() {
        System.out.println(this.toString());
        System.out.println("트랜잭션 시작");
        transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    @AfterReturning(pointcut = "transactionalPointcut()", returning = "result")
    public void tranAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("정상적으로 리턴 되었으므로 커밋");
        transactionManager.commit(transactionStatus);
    }

    @AfterThrowing(pointcut = "transactionalPointcut()", throwing = "exception")
    public void tranAfterThrowing(Throwable exception) {
        System.out.println("예외가 발생했으므로 롤백 - " + exception.getMessage());
        transactionManager.rollback(transactionStatus);
    }

    @After("transactionalPointcut()")
    public void tranAfter(JoinPoint joinPoint) {
        
    }

}
