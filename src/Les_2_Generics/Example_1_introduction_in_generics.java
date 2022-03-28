package Les_2_Generics;

import java.util.ArrayList;
import java.util.List;

public class Example_1_introduction_in_generics {
    public static void main(String[] args) {
        //Без Generics мы можем добавлять в ArrayList объект любого типа так как в основе ArrayList
        // лежит массив Object. Но так не делают так как это приведёт к серьёзным ошибкам

        //Такой тип, в нашем случае List, называется непараметризированный или сырой тип (raw type).
        // Но так мы писать не будем

//        List list = new ArrayList();
//        list.add("ok");
//        list.add(5);
//        list.add(new StringBuilder("String"));
//        list.add(new Car());

        //А будем вот так
        List<String> list = new ArrayList<>();

        //Допустим добавим в ArrayList String элементы
        list.add("Hello");
        list.add("goodbye");
        list.add("ok");
        list.add("never");
//        list.add(new Car());

        //мы не можем так написать потому что list содержит не String, а Object
//        for (String s : list){
//        }
        //Поэтому мы должны писать так
        for (Object o : list){
            System.out.println(o + "- длина: " + ((String)o).length());
        }

        //Но если добавить в list объект другого типа например Car, то мы получим runtime error так как, не
        //сможем кастануть его к String. Но компилятор при этом ругаться не будет

    }
}

class Car{}


//1. Джинерики были созданы для Типобезопасности - type safe
//2. reusable code - позволяет избежать, дублирование кода