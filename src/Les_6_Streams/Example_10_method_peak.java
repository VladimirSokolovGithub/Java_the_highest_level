package Les_6_Streams;

import java.util.stream.Stream;

public class Example_10_method_peak {
    public static void main(String[] args) {

        //метод peak() - принимает в параметр consumer и возвращает stream. Это intermediate метод.
        //Обычно этот метод нужен, что бы посмотреть как проходит поэтапно наш method Сhaining.
        //метод peak() очень похож на метод forEach().

        //Пример
        //После применения на стриме метода distinct() у нас остались только уникальные элементы и с помомщью
        //метода peak() я смог просмотреть какие элементы у нас остались выведя их на экран и потом метод
        //count() вернул количество оставшихся элементов.
        Stream<Integer> stream = Stream.of(1,2,3,4,5,1,2,3);
        System.out.println(stream.distinct().peek(System.out::println).count());


    }
}
