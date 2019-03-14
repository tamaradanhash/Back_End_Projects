package View;

import Model.Participant;
import Model.Team;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

@UtilityClass
public class Screen {
    public void display(List<Team> teams) {
        System.out.println("\n------- PAIRS -------\n");
        teams.forEach(display());
        System.out.println("\n------- PAIRS -------");
    }

    private Consumer<Team> display() {
        return team -> {
            String names = team.getParticipants().stream()
                    .map(Participant::getName)
                    .collect(joining(", "));
            System.out.println(names);
        };
    }

}
