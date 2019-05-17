package controller;

import model.Bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyzer {
  private List<Bean> beans = CanFiller.fill();
  private List<Bean> lastBean = Processor.getLastBean();

  public static void main(String[] args) {
//    Analyzer analyzer = new Analyzer();
//    analyzer.analyse();
    System.out.println(getLonggest("hello world"));
  }

  public static String getLonggest(String sentence) {
    if (sentence.isBlank()) {
      return "";
    }
    List<String> words = Stream.of(sentence.split("[^A-Za-z0-9]"))
                               .collect(Collectors.toList());
    int position = 0;
    while (words.size() > 1) {
      String word1 = words.get(position);
      String word2 = words.get(position + 1);
      if (word1.length() >= word2.length()) {
        words.remove(word2);
      } else {
        words.remove(word1);
      }
    }

    return words.get(0);
  }


  public void analyse() {
    giveBeansColorsPercentage(beans);
  }

  private void giveBeansColorsPercentage(List<Bean> beans) {
    long whiteBeans = getPercentage("white");
    long blackBeans = getPercentage("black");
    System.out.println("white beans percentage is" + whiteBeans + "%\n");
    System.out.println("black beans percentage is" + blackBeans + "%\n");
  }

  private long getPercentage(String color) {
    long colorPresence = beans.stream().filter(bean -> bean.getColor().equals(color)).count();
    long percentage = (colorPresence * 100) / beans.size();
    System.out.println(percentage);
    return percentage;
  }
}
