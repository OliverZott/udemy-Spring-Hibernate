package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFortuneService {

    private final List<String> fortunes = new ArrayList<>(Arrays.asList("Fortune1", "Fortune2", "Fortune3"));

    public String getFortune() {
        int rnd = new Random().nextInt(3);
        return fortunes.get(rnd);
    }

}
