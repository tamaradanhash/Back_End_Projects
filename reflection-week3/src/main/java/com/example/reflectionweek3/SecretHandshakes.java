package com.example.reflectionweek3;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Setter
@Getter
@Component
@ConfigurationProperties("secretagent")
public class SecretHandshakes {
    private Map<Integer,String> secrethandshakes;
}
