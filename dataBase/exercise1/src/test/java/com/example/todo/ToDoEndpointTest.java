package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ToDoEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @SpyBean
    ToDoManager manager;


    @Test
    void get() {
    }

    @Test
    void getToDo() {
    }
}