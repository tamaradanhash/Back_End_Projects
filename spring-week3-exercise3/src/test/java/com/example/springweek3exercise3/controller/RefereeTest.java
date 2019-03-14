package com.example.springweek3exercise3.controller;

import com.example.springweek3exercise3.model.Stadium;
import com.example.springweek3exercise3.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RefereeTest {
    @Autowired
    Stadium stadium;
    @Autowired
Referee referee;
    @Test
    void decideTheWinner() {
        Team team = referee.decideTheWinner(stadium);
        System.out.println(team.getName());
    }
}