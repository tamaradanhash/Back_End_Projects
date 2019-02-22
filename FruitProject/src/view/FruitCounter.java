package view;

import controller.Assistant;
import lombok.Data;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import model.Fruit;

import java.util.List;
import java.util.stream.Stream;

@UtilityClass
@Log
public class FruitCounter {

    public void display(List<Fruit> fruits){
        fruits.stream().forEach(e -> log.info(e.getName()+" "+e.getAmount()));
    }
}
