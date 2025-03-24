package net.jayzen.springframeworkbasic.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("CircularDependencyBeans.xml");

        AService aService = context.getBean(AService.class);

        aService.foo();
        context.close();
    }
}
