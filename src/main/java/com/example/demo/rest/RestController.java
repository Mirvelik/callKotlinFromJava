package com.example.demo.rest;

import com.example.demo.service.FirstService;
import com.example.demo.service.SecondService;
import com.example.demo.service.ThirdService;
import com.my.kotlin.example.demo.KotlinServiceAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.transform.Result;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final FirstService firstService;
    private final SecondService secondService;
    private final ThirdService thirdService;

    public RestController(FirstService firstService, SecondService secondService, ThirdService thirdService) {
        this.firstService = firstService;
        this.secondService = secondService;
        this.thirdService = thirdService;
    }

    @GetMapping("/test")
    public String authenticVerifyByHash() {
        return "Hello, World!";
    }


    @GetMapping("/test2")
    public Result getResultOfSomething() {
        return new KotlinServiceAsync(firstService, secondService, thirdService).getResultOfSomethingAsync();
    }
}
