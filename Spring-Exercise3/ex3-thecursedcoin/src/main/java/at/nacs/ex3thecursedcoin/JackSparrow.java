package at.nacs.ex3thecursedcoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JackSparrow {
    private final LegendaryCompass legendaryCompass;


    public String findCursedCoin() {
        return "I found the " + legendaryCompass.lookForTheCursedCoin() + "!";
    }

}
