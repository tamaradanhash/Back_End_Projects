package com.example.springweek3exercise3.controller;

import com.example.springweek3exercise3.model.Stadium;
import com.example.springweek3exercise3.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Component
public class Referee {
    private  Random random = new Random();
//private final Stadium stadium;
public Team decideTheWinner(Stadium stadium){
    Queue<Team> tournament=new LinkedList<>(stadium.getTeams());
    IntStream.generate(() -> 0)
            .takeWhile(n -> tournament.size() > 1)
            .forEach(e -> filter(tournament));

    return tournament.poll();
}

    private void filter(Queue<Team> tournament) {
        Team winnerTeam = getWinerTeam(tournament);
        tournament.add(winnerTeam);
    }

    private Team getWinerTeam(Queue<Team> tournament) {
        Team one = tournament.poll();
        Team two = tournament.poll();
        List<Team> match = List.of(one, two);
        int winner = random.nextInt(match.size());
        return match.get(winner);
    }
}
