package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortuneService{

    @Override
    public String getFortune() {
        return "You got lucky boy!";
    }
}
