package Model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Team {
    List<Participant> participants;
}
