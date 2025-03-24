package net.jayzen.springframeworkbasic.demo;

public class AService {
    private BService bService;
    
    public AService(BService bService) {
        this.bService = bService;
    }
    
    public void foo() {
        System.out.println("AService.foo 호출");
        bService.bar();
    }
}
