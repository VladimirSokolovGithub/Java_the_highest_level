package Les_6_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Example_6_methodСhainingInStream {
    //6
    //method chaining in stream - вызов методов друг за другом. Chaining переводится как цепочка.
    //Method chaining в stream работает следующим образом. На вход подаётся коллекция или массив, из
    //них создаём стрим и используем элементы стрима в наших методах, которые называются intermediate методы -
    //- промежуточные методы (или так же называют lazy) и в конечном итоге эти элементы т.е. наш поток,
    //поступают на вход к Terminal методу - терминальному методу - конечному методу (или так же называют eager).
    //Промежуточные методы обрабатывают поступающие элементы и возвращают стрим, т.е. к ним к методам пришёл
    //стрим и на выходе на output-e тоже стрим, и так далее пока мы не вызовем терминальный метод. Без терминального
    //метода ни один из промежуточных не сработает. Терминальный метод уже не возвращает нам stream(они либо
    // void или другой результат отличный от stream).

    public static void main(String[] args) {
        //Пример №1
        //Создадим Stream из этого массива и отфильтруем его так, чтобы остались только нечётные числа,
        //затем поделим те числа которые делятся на три без остатка и найдём сумму оставшихся измененных чисел.
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};

        int result = Arrays.stream(array).filter(e -> e % 2 == 1)
                .map(e -> {
                    if (e % 3 == 0) {
                        e = e / 3;
                    }
                    return e;
                })
                .reduce((a, e) -> a + e).getAsInt();
        System.out.println(result);

        //Пример №2
        //Представим, что для нашего List-a студентов имена сделать заглавными буквами, отфильтровать по полу,
        //и отсортировать по возрасту.

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7.0);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        List<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students.stream().map(element ->
                {
                    element.setName(element.getName().toUpperCase());
                    return element;
                }).filter(element -> element.getSex() == 'f').sorted((x, y) -> x.getAge() - y.getAge())
                .forEach(element -> System.out.println(element));


        //Пример №3
        //Без терминального метода collect(Collectors.toList()) метод filter не сработает и "!!!" не
        //выведутся на экран
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,1,2,3);
        stream1.filter(el -> {
            System.out.println("!!!");
            return  el % 2 == 0;
        }).collect(Collectors.toList());

    }
}
