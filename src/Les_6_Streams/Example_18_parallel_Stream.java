package Les_6_Streams;

import java.util.ArrayList;
import java.util.List;

public class Example_18_parallel_Stream {
    public static void main(String[] args) {

        //Когда мы работаем со Stream, то по умолчанию используются последовательные (sequential) потоки.
        //Таким образом пока мы сами вручную не укажем Jav-e, то что мы хотим использовать parallel stream,
        //будут использоваться последовательный (sequential) stream.

        //parallel Stream - это возможность использования нескольких ядер процессора при выполнении каких-либо
        //операций со Stream.

        //Использование параллельных стримов подходит для каких то агрегированных функций, типа нахождения
        //минимума, максимума, суммы и не подходят когда наши действия над элементами стрима напрямую
        // зависят от их очередности.

        //parallel Stream можно получить двумя способами:
        //1 - когда мы у коллекции, например у List вместо метода stream, вызывам метод parallelStream()-
        //list.parallelStream(). ... Этот способ используется чаще всего

        //2 - когда мы создаём стрим с нуля
        //Stream<T> s = Stream.of(...);
        //s.parallel(). ...

        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        //обычный стрим - корректный результат
        double sumResult = list.stream().reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("sumResult = " + sumResult);

        //parallel stream - корректный результат
        double sumResult2 = list.parallelStream().reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("sumResult = " + sumResult);

        //*****************************

        //обычный стрим - корректный результат
        double divisionResult = list.stream().reduce((accumulator, element) -> accumulator / element).get();
        System.out.println("divisionResult = " + sumResult);

        //parallel stream - некорректный результат
        double divisionResult2 = list.parallelStream().reduce((accumulator, element) -> accumulator / element).get();
        System.out.println("divisionResult = " + sumResult);

    }
}
