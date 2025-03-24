package net.jayzen;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.time.LocalDateTime;

public class GrapeFlavorCigarette implements Cigarette {
    private boolean isButt;
    @PostConstruct
    public void smokingStart() {
        isButt = false;
    }


    @PreDestroy
    public void smokingEnded() {
        if (isButt) {
            System.out.println("쓰레기는 쓰레기통으로...");
        } else {
            System.out.println("장초가 버려진다아~");
        }
    }

    @Override
    public void smoke() {
        if (!isButt) {
            System.out.println("보라색맛 났어!");
            isButt = true;
        } else {
            System.out.println("웩");
        }
    }
}
