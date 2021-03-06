package com.example.springweek3exercise1;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Word {
    @Getter
    @Value("${word.name}")
    private String word;

}
