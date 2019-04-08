package com.example.todo;

import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@ConfigurationProperties("dataset")
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class ToDoManagerTest {
    @Autowired
    ToDoRepository repository;

    @Autowired
    ToDoManager manager;

    @Setter
    List<ToDo> todos;

    @BeforeEach
    void before() {
        repository.deleteAll();
        repository.saveAll(todos);
    }


    @Test
    void test() {

        List<ToDo> all = manager.findAll();
        assertThat(all.size()).isEqualTo(4);
    }
}