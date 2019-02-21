package controller;

import lombok.experimental.UtilityClass;
import model.Bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
@UtilityClass
public class Processor {
    private List<Bean> beans = CanFiller.fill();

    public Bean getLastBean() {
        List<Bean> beanQ = new LinkedList<>(beans);

        Queue<Bean> beanQueue = (Queue<Bean>) beanQ;


        IntStream.generate(() -> 0)
                .takeWhile(n -> beanQueue.size() > 1)
                .forEach(e -> filter(beanQueue));


        //.filter(e->filter(beanQ1)).collect(Collectors.toList());

//                .flatMap(e-> Stream.of(beanQ1.add(Bean.builder().color("black").build()))
//        .mapToObj(filter(beanQ1.poll(),beanQ1.poll())).map(e->beanQ1.add(e)).collect(Collectors.toList());


//        while (beanQ1.size() != 1) {
//            beanQ1.add(filter(beanQ1.poll(), beanQ1.poll()));
//
//
//        }
//
//        return beanQ1.poll();

        return beanQueue.poll();

    }


    public void filter(Queue<Bean> beans) {
        Bean one = beans.poll();
        Bean two = beans.poll();
        if (one.equals(two)) {
            beans.add(Bean.builder().color("black").build());

        } else {
            beans.add(Bean.builder().color("white").build());
        }

    }
}
