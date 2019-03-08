package com.example.springweek3exercise3.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Setter
@Getter
@Component
@ConfigurationProperties("match")
public class Stadium {
private List<Team> teams;
}
