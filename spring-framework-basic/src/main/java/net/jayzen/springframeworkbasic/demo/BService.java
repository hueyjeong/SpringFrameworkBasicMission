package net.jayzen.springframeworkbasic.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BService {
    @Lazy
    @Autowired
    private AService aService;

    public BService() {
    }

    public BService(AService aService) {
        this.aService = aService;
    }

    public void bar() {
        System.out.println("BService.bar 호출");
//        aService.foo();
    }
}
