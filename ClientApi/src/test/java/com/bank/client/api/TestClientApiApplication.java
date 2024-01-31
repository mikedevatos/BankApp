package com.bank.client.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
public class TestClientApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(ClientApiApplication::main).with(TestClientApiApplication.class).run(args);
    }

}
