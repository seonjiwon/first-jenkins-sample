package com.example.first_jenkins_sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${message}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return message + " 테스트 5번 입니다.";
    }
}
