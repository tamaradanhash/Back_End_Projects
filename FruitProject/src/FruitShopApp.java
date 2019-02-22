import controller.Assistant;
import controller.FileReader;
import model.Fruit;
import view.FruitCounter;

import java.util.List;
import java.util.stream.Stream;

public class FruitShopApp {
    public static void main(String[] args) {
        Stream<String> lines = FileReader.lines("delivery.txt");
        List<Fruit> fruits = Assistant.toFruit(lines);
        FruitCounter.display(fruits);
    }
}
