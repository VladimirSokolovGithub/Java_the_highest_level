package Les_6_Streams;

import java.util.stream.Stream;

public class Example_9_method_count {
    public static void main(String[] args) {
        //метод count() - terminal метод, считает количество элементов в стриме и возвращает long
        Stream<Integer> stream = Stream.of(1,2,3,4,5,1,2,3);
        //выведем в консоль сколько элементов содержит stream
//        System.out.println(stream.count());
        //а теперь выведем сколько уникальных элементов содержит stream
        System.out.println(stream.distinct().count());

    }
}
