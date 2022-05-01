package Les_6_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Example_4_method_reduce {
    public static void main(String[] args) {
        //4
        //***// метод reduce() и знакомство с классом Optional

        //метод reduce() - в переводе уменьшить. Метод возвращает Optional
        //Объект типа Optional оборачивает собой в примере ниже объект Integer-а который мы получим
        //после работы метода reduce(), иначе говоря является контейнером для нашего значения.
        //Optional может содержать null и not null значения.

        //Метод уменьшает N-ое количество элементов в стриме до одного.
        //Очень удобно выполнять агрегированные функции - суммирование, умножение и т.д.
        //Агрегирование в общем смысле — это объединение нескольких элементов в единое целое.

        //Найдем произведение всех элементов нашего стрима
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        //***** Рассмотрим два варианта метода reduce()
        //1 - в лямбда выражении указывыаем два параметра

        int result = list.stream().reduce((accumulator, element) -> accumulator*element).get();
        System.out.println(result);
        //после вызова на листе метода stream(), мы получаем стрим 5,8,2,4,3
        //далее мы работаем с двумя параметрами
        //accumulator-у сразу присваивается первое значение нашего потока
        // accumulator = 5  40  80  320  960
        //второе значение нашего потока присваивается element-у
        // element =     8   2  4   3
        //далее происходит умножение аккумулятора на элемент и передача этого произведения аккумулятору и так далее
        //пока элемент не примет последние значение, после чего метод reduce() заканчивает свою работу и
        //возвращает 960
        //Метод get() в конце выражения нужен для того, чтобы получить из Optional значение и присвоить его
        //переменной result.

        //Проверка на присутствие значения null методом isPresent()
        List<Integer> list2 = new ArrayList<>();
//        int result2 = list2.stream().reduce((accumulator, element) -> accumulator*element).get();
//        System.out.println(list2);
        //List у нас пустой поэтому соответственно вылетит NoSuchElementException. Что бы этого не происходило
        //нужно выполнять проверку

        //Мы могли не вызывать метод get() и поместить значение в переменную типа Optional

        Optional<Integer> optional = list2.stream().reduce((accumulator, element) -> accumulator*element);
        if (optional.isPresent()){ //проверяем присутствует это значение или нет
            System.out.println(optional.get()); //если присутствует, выводи на экран значение optional
        }
        else {
            System.out.println("Mot present element");
        }


        //2 - мы можем добавить ещё один параметр в метод reduce(), который будет являться аккумулятором,
        //первичным, начальным значением нашего аккумулятора.
        //Теперь начальное значение нашего аккумулятора еденица. И при использовании такого варианта уже
        //нет варианта что мы получим null значение, потому что мы указываем начальное значение аккумулятора
        //равное еденице. И поэтому метод get() уже можно не использовать так как метод reduce() уже возвращает
        //нам Integer
        int result2 = list.stream().reduce(1,(accumulator, element) -> accumulator*element);
        System.out.println(result2);
        //после вызова на листе метода stream(), мы получаем стрим 5,8,2,4,3

        // accumulator = 1  5   40 80  320 960
        // element =     5  8   2   4   3


        //3
        //Рассмотрим ещё один пример для листа который содержит String найдём конкатенацию всех его элементов
        List<String> list3 = new ArrayList<>();

        list3.add("Hello");
        list3.add("How are you");
        list3.add("Ok");
        list3.add("Goodbye");

        String result3 = list3.stream().reduce((a, e) -> a + " " + e).get();
        System.out.println(result3);
    }
}
