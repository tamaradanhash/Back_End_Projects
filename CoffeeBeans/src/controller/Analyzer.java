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
    private List<Bean> lastBean= Processor.getLastBean();
    public void analyse(){
        giveBeansColorsPercentage(beans);

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
