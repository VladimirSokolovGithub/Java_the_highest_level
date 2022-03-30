package Les_2_Generics;

import java.util.ArrayList;
import java.util.List;

public class Example_7_Wildcards {
    public static void main(String[] args) {
//        List<Number> list = new ArrayList<Integer>(); //вот так писать нельзя, потому что ArrayList<Integer> Интеджеров
        //не являлся подтипом List<Number> Намберов

//        List<Object> list = new ArrayList<Integer>(); //и так писать нельзя

        // Но если поставить знак вопроса, который и является символом Wildcard, то так писать можно
        // Это List<?> означает, что вместо <?> здесь может стоять и Integer и String и Object
        // т.е, что вместо <?> может быть подставлен любой класс
        List<?> list = new ArrayList<Integer>();


        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        showListInfo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("ok");
        list2.add("Hello");
        list2.add("Goodbye");
        showListInfo(list2);


        //Но есть и ограничения при работе с List<?>, который мы задаем с помощью Wildcards
        List<?> list3 = new ArrayList<String>();
//        list3.add("Hello"); // компилятор не разрешает ничего добавлять в такой лист с Wildcard так как
                            //он не знает какого типа этот List<?>, потому что мы пытаемся использовать метод,
                            //который изменяет наш объект.

        //следовательно используя Wildcard параметры мы не можем использовать методы, которые изменяют наш объект.

        //Так как ниже написан List мы писать не можем, но можем использовать границы - bounded wildcards
//        List<Number> list4 = new ArrayList<Integer>();
        List<? extends Number> list4 = new ArrayList<Integer>();
        List<? super Number> list10 = new ArrayList<Object>();

        ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.14);
        ald.add(3.15);
        ald.add(3.16);
        System.out.println(suma(ald));

        ArrayList<Integer> ali = new ArrayList<>();
        ali.add(3);
        ali.add(35);
        ali.add(30);
        System.out.println(suma(ali));
    }

    //Теперь с помощью Wildcards наш метод может работать с List-ом любого типа
    static void showListInfo(List<?> list) {
        System.out.println("Мой list содержит следующие элементы: " + list);
    }

    //пример метода к List<? extends Number> list4 = new ArrayList<Integer>();
    public static double suma(ArrayList<? extends Number> list){
        double sum = 0;
        for (Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }
}
