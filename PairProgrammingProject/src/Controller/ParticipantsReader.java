package Controller;

import Model.Participant;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class ParticipantsReader {
    public List<Participant> toList(String filePath) {
        return FileReader.lines(filePath)
                .map(toParticipant()).collect(Collectors.toList());
    }

    private static Function<String, Participant> toParticipant() {
        return line -> Participant.builder()
                .name(line)
                .build();
    }

}
