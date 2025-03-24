package net.jayzen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CigaretteConfig {
    @Bean
    @Scope("prototype")
    public Cigarette cigarette() {
        return new GrapeFlavorCigarette();
    }

    @Bean
    @Scope("singleton")
    public HeavySmoker heavySmoker() {
        return new HeavySmoker();
    }
}
