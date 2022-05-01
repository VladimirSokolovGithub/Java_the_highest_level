package Les_6_Streams;

import java.util.Arrays;

public class Example_3_method_forEach {
    public static void main(String[] args) {
        //3
        //Метод forEach() -> void
        //Это не тот метод который напрямую вызывался у коллекций, это метод который мы будем вызывать на Stream-e.
        //Так как этот метод ничего не возвращает, то мы не сможем после использования этого метода создать List c
        //помощью метода collect.
        //Метод forEach() позволяет нам проходится по всем элементам Стрима и выводить например на экран эти
        //элементы.

        //создадим массив интов и удвоим каждый элемент этого массива с помощью Stream и метода forEach()
        int[] array = {5, 9, 3, 8, 1};
        Arrays.stream(array).forEach(el -> {el *= 2; System.out.println(el);});
        //Можно было просто вывести на экран все элементы
        Arrays.stream(array).forEach(el -> System.out.println(el));
        //Так же мы можем ещё упростить вышенаписанное выражение по выводу элементов в консоль
        Arrays.stream(array).forEach(System.out::println);
        //Это выражение System.out::println - называется method reference (метод референс), т.е. мы даем
        //ссылку на наш метод println. И Java сама уже понимает что в этот метод println, который вызывается
        //в параметре метода forEach(System.out::println), нужно передать каждый элемент нашего массива.

        //***//Ещё один пример на method reference :: (используя свой метод myMethod из класса Utils)
        Arrays.stream(array).forEach(Utils::myMethod); //Я говорю, что каждый элемент Стрима(потока) помести
                                    //в метод myMethod в качестве параметра, который находится в классе Utils
        //Это было короткое написание ниже приведенного лямбда выражения
        Arrays.stream(array).forEach(el -> Utils.myMethod(el));

    }
}

class Utils{
    public static void myMethod(int a){
        a = a + 5;
        System.out.println("Element = " + a);
    }
}