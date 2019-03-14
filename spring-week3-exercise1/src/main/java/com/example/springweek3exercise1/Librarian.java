package com.example.springweek3exercise1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("bookshop")
public class Librarian {
    @Setter
    @Getter
    private Map<String, Integer> books;
}
