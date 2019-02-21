package tests;

import controller.CanFiller;
import controller.Processor;
import model.Bean;
import model.Beans;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

    @Test
    void getLastBean() {

        List<Bean> beans = CanFiller.fill();

        System.out.println(CanFiller.fill());
        System.out.println(Processor.getLastBean());
    }
}