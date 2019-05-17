package controller;

import lombok.experimental.UtilityClass;
import model.Bean;
import model.Beans;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class CanFiller {
  public List<Bean> fill() {

    return IntStream.generate(() -> 0)
                    .limit(4)
                    .mapToObj(n -> getBean()).collect(Collectors.toList());
  }

  private static Bean getBean() {
    return Beans.getBeans().get(new Random().nextInt(Beans.getBeans().size()));
  }
}
