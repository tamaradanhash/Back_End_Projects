package com.example.springweek3exercise1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("entertainment")
public class SaunaLoader {
    private Sauna sauna;
}
