package com.bank.client.api.controller;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
@SpringBootTest
public class TransactionApiClientTest {


    @Autowired
    private MockMvc mockMvc;


    @Before
    public void before() {
    }

    @After
    public void after() {
    }


    private MockMvc getMockMvc() {
        return mockMvc;
    }

    @Test
    @SneakyThrows
    public void testAC1TransactionAndExpectOk() {
        mockMvc.perform(post("/api/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bytesFromPath(new ClassPathResource("/src/test/java/resources/AC1_ok_transaction.json").getPath()))
                )
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void testAC2TransactionAndExpectBadRequest() {
        mockMvc.perform(post("/api/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bytesFromPath(new ClassPathResource("/src/test/java/resources/AC2_Insufficient_balance_bad_request.json").getPath()))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void testAC3TransactionAndExpectBadRequest() {
        mockMvc.perform(post("/api/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bytesFromPath(new ClassPathResource("/src/test/java/resources/AC3_same_account_bad_request_transaction.json").getPath()))
                )
                .andExpect(status().isBadRequest());
    }
    @Test
    @SneakyThrows
    public void testAC4TransactionAndExpectNotFound() {
        mockMvc.perform(post("/api/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bytesFromPath(new ClassPathResource("/src/test/java/resources/AC4_account_not_found_transaction.json").getPath()))
                )
                .andExpect(status().isNotFound());
    }



    @SneakyThrows
    public static byte[] bytesFromPath(final String path) {
        return Files.readAllBytes(Paths.get(path));
    }

}
