package com.example.springweek3exercise1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ConfigurationProperties("show")
public class BallerinaContest {
    private List<com.example.springweek3exercise1.Ballerina> ballerinas;
}

