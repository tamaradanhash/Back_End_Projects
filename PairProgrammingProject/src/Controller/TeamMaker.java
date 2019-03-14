package Controller;

import Model.Participant;
import Model.Team;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@UtilityClass
public class TeamMaker {
    public List<Team> make(List<Participant> participants) {
        if (participants.size() < 2) {
            return new ArrayList<>();
        }
        Queue<Participant> participantQueue = shuffleAndQueue(participants);
        List<Team> teams = PickTeams(participantQueue);
        addLastParticipant(teams, participantQueue);
        return teams;
    }

    private Queue<Participant> shuffleAndQueue(List<Participant> participants) {
        List<Participant> list = new LinkedList<>(participants);
        Collections.shuffle(list);
        return (Queue<Participant>) list;
    }

    private List<Team> PickTeams(Queue<Participant> participantQueue) {
        return IntStream.generate(() -> 0)
                .takeWhile(n -> participantQueue.size() > 1)
                .mapToObj(toTeams(participantQueue))
                .collect(Collectors.toList());
    }

    private IntFunction<Team> toTeams(Queue<Participant> participantQueue) {
        return n -> Team.builder()
                .participants(takeTwo(participantQueue)).build();
    }

    private List<Participant> takeTwo(Queue<Participant> participantQueue) {
        return Stream.of(participantQueue.poll(), participantQueue.poll()).collect(Collectors.toList());
    }

    private void addLastParticipant(List<Team> teams, Queue<Participant> participantQueue) {
        if (participantQueue.isEmpty()) {
            return;
        }
        Team firstTeam = teams.get(0);
        Participant lastParticipant = participantQueue.poll();
        firstTeam.getParticipants().add(lastParticipant);

    }
}
