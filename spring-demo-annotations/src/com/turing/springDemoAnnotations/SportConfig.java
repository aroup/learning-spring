package com.turing.springDemoAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.turing.springDemoAnnotations")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public FortuneService practiceFortuneService() {return new PracticeFortuneService();}

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }


    @Bean
    public Coach practiceCoach() { return new PracticeCoach(practiceFortuneService()); }

}
