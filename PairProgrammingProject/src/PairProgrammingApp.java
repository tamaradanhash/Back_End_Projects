import Controller.ParticipantsReader;
import Controller.TeamMaker;
import Model.Participant;
import Model.Team;
import View.Screen;

import java.util.List;

public class PairProgrammingApp {
    public static void main(String[] args) {
        List<Participant> participants = ParticipantsReader.toList("File/Paticipants");
        List<Team> teams = TeamMaker.make(participants);
        Screen.display(teams);


    }
}
