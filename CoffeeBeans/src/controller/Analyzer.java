package controller;

import model.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class Analyzer {
    private List<Bean> beans=CanFiller.fill();
    private Bean lastBean= Processor.getLastBean();
    public void analyse(){
        giveBeansColorsPercentage(beans);
        giveLastBeanColorPercentage(lastBean);

    }

    private void giveLastBeanColorPercentage(Bean lastBean) {
        String color = lastBean.getColor();
        Path path = whriteStatistics(color);
        try {
            List<String> attempts = Files.readAllLines(path);
            attempts.stream().mapToLong(e-> getPercentage(e)).forEach(e -> System.out.println(e));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path whriteStatistics(String color) {
        Path path = Paths.get("file/output");
        try {
            Files.write(path, Collections.singleton(color), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    private void giveBeansColorsPercentage(List<Bean> beans) {
        long whiteBeans = getPercentage("white");
        long blackBeans = getPercentage("black");
        System.out.println("white beans percentage is"+whiteBeans+"%\n");
        System.out.println("black beans percentage is"+blackBeans+"%\n");

    }

    private long getPercentage(String color) {
        long colorPresence = beans.stream().filter(bean -> bean.getColor().equals(color)).count();
        long percentage = (colorPresence * 100) / beans.size();
        System.out.println(percentage);
        return percentage;
    }

    public static void main(String[] args) {
        Analyzer analyzer=new Analyzer();
        analyzer.analyse();
    }

}
