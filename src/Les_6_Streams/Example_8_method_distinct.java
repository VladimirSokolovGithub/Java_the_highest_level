package Les_6_Streams;

import java.util.stream.Stream;

public class Example_8_method_distinct {
    public static void main(String[] args) {
        //метод distinct() - intermediate метод возвращает стрим уникальных элементов, которые он сравнивает
        // с помощью метода equals

        //Буду выводить на экран уникальные методы нашего стрима.
        Stream<Integer> stream = Stream.of(1,2,3,4,5,1,2,3);
        stream.distinct().forEach(System.out::print);

    }
}
