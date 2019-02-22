package controller;

import model.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;



class AssistantTest {

    @Test
    void toFruit() {
        Stream<String> test = Stream.of("apple");
        List<Fruit> list = Assistant.toFruit(test);
          List<Fruit> expected= Arrays.asList(Fruit.builder().name("apple").amount(1l).build());
        Assertions.assertEquals(expected,list);

    }
}