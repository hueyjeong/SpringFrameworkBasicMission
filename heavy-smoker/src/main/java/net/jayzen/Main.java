package net.jayzen;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cigarette cigarette;
        ApplicationContext context = new AnnotationConfigApplicationContext(CigaretteConfig.class);
        System.out.println("싱글톤 타입");
        HeavySmoker heavySmoker = context.getBean(HeavySmoker.class);
        System.out.println(heavySmoker);
        HeavySmoker heavySmoker2 = context.getBean(HeavySmoker.class);
        System.out.println(heavySmoker2);

        System.out.println("프로토타입");
        cigarette = context.getBean(Cigarette.class);
        System.out.println(cigarette);
        heavySmoker.smoke(cigarette);

        cigarette = context.getBean(Cigarette.class);
        System.out.println(cigarette);
        heavySmoker.smoke(cigarette);
        heavySmoker.smoke(cigarette);
        cigarette = context.getBean(Cigarette.class);
        System.out.println(cigarette);
        heavySmoker.smoke(cigarette);
    }
}