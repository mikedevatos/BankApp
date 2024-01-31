package com.example.bank.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;



@SpringBootTest
public class TestDemo1Application {

    public static void main(String[] args) {
        SpringApplication.from(BankApiApplication::main).with(TestDemo1Application.class).run(args);
    }

}
