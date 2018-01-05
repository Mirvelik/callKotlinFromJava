package com.example.demo.rest;

import com.example.demo.rest.response.Result;
import com.example.demo.service.FirstService;
import com.example.demo.service.KotlinServiceAsync;
import com.example.demo.service.SecondService;
import com.example.demo.service.ThirdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final FirstService firstService;
    private final SecondService secondService;
    private final ThirdService thirdService;
    private final KotlinServiceAsync kotlinServiceAsync;

    public RestController(FirstService firstService, SecondService secondService, ThirdService thirdService, KotlinServiceAsync kotlinServiceAsync) {
        this.firstService = firstService;
        this.secondService = secondService;
        this.thirdService = thirdService;
        this.kotlinServiceAsync = kotlinServiceAsync;
    }

    @GetMapping("/test")
    public String authenticVerifyByHash() {
        return "Hello, World!";
    }


    @GetMapping("/test2")
    public Result getResultOfSomething() {
        return kotlinServiceAsync.getResultOfSomethingAsync();
//        return kotlinServiceAsync.getResultOfSomethingAsync()
//        return new KotlinServiceAsync(firstService, secondService, thirdService).getResultOfSomethingAsync();
    }
}
