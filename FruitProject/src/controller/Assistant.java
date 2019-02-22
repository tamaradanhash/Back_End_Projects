package controller;

import lombok.experimental.UtilityClass;
import model.Fruit;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@UtilityClass
public class Assistant {


  public List<Fruit> toFruit(Stream<String> fruitNames){
    return fruitNames.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
             .entrySet().stream()
              .map(e -> Fruit.builder().name(e.getKey()).amount(e.getValue()).build())
              .collect(Collectors.toList());
  }

}
