package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("DBService")
public class DatabaseFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Hello, DB Fortune Service injected!";
    }
}
