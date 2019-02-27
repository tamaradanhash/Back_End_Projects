package at.nacs.ex3thecursedcoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class LegendaryCompass {
private final CursedCoin coin;


    public String lookForTheCursedCoin(){
    return coin.getClass().getSimpleName();
}
}
