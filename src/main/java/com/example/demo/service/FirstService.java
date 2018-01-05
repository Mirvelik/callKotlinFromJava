package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FirstService {

    public String longCalculation() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("1 done");

        return "111 ";
    }
}
