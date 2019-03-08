package com.example.springweek3exercise3.model;

import lombok.Data;

import java.util.List;

@Data
public class Team {
    private String name;
    private List<String> players;
}
