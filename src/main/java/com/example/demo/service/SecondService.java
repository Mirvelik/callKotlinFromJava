package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SecondService {

    public String veryLongCalculation() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("2 done");

        return "222 ";

    }
}
