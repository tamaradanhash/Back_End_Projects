package tests;

import controller.CanFiller;
import model.Bean;
import model.Beans;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CanFillerTest {
@Test
    void fill() {

    List<Bean> beans= CanFiller.fill();
    System.out.println(beans);
    }
}