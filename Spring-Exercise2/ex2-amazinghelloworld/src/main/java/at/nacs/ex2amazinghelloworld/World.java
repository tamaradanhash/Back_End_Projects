package at.nacs.ex2amazinghelloworld;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@Value
public class World {
    public String getName() {
        return "World";
    }
}
