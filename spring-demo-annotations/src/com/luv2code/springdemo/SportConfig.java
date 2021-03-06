package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * With @Configuration there is al config inside Java Code --> NO xml config needed!!!
 */
@Configuration
@PropertySource("classpath:sport.properties")
// @ComponentScan("com.luv2code.springdemo")
public class SportConfig {

    // Method to expose Bean
    // define bean for fortune-service
    @Bean
    public FortuneService sadFortuneService() {     // method name is Bean-ID
        return new SadFortuneService();
    }

    // Inject Dependencies
    // Define bean for swim-coach AND inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());  // must be Bean-ID from service above
    }

}
