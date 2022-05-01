package Les_6_Streams;

import java.util.stream.Stream;

public class Example_7_method_concat {
    public static void main(String[] args) {

        //Статический метод Stream.concat() - метод делает конкатенацию
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,1,2,3);

        Stream<Integer> stream2 = Stream.of(1,2,3,4,5);

        Stream<Integer> stream3 = Stream.of(6,7,8,9,10);

        //Создадим stream4.
        //Метод Stream.concat() статический и возвращает Stream, но он не может быть использован в цепочке методов.
        //Поэтому после работы метода Stream.concat, который объединил наши два стрима stream2 и stream3
        // нам необходимо на нашем стриме - stream4 вызвать метод forEach, пройтись по всем его элементам
        // и с помощью method reference, вывести их на экран
        Stream<Integer> stream4 = Stream.concat(stream2, stream3);
        stream4.forEach(System.out::print);
//        stream4.forEach(el -> System.out.print(el + " "));

    }
}
