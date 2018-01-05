package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ThirdService {
    public String longestCalculation() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("3 done");
        return "333 ";

    }
}
