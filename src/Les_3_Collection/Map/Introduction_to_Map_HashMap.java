package Les_3_Collection.Map;

import java.util.HashMap;
import java.util.Map;

public class Introduction_to_Map_HashMap {
    public static void main(String[] args) {
        //Элементами Map являются пары - key and value т.е ключ и значение хранятся как пара
        //HashMap не запоминает порядок добавления элементов.
        //Ключи и значения в HashMap могут быть разных типов или даже совпадать

        //1
        //метод put()


        //создадим Map с ключом Integer и значением String
        //ключи должны быть уникальными, Значения могут повторяться
        //если мы попытаемся вставить элементы с одинаковым ключом, то ключ останется на месте, а
        //значение изменится на новое(оно перезапишется)
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1000, "Vladimir Sokolov"); //метод put() добавляет элементы в коллекцию
        map1.put(3568, "Ivan Ivanov");
        map1.put(1525, "Mariya Sidorova");
        map1.put(5225, "Nikolay Petrov");
        map1.put(5555, "Nikolay Petrov");
        map1.put(1000, "Oleg Ivanov");
        map1.put(null, "Null Velikiy");
        map1.put(85214, null);
        System.out.println(map1);

        //2
        //метод putIfAbsent() - добавляет элемент в коллекцию HashMap если такого элемента нет.

        map1.putIfAbsent(5555, "Sergey Vasechkin"); // этот элемент добавлен не будет так как элемент с таким
                                                    // ключом уже существует
        //3
        //метод get() - метод возвращает значение по ключу, если такого ключа нет то вернется null
        System.out.println(map1.get(1000));

        //4
        //метод remove() - метод удаляет элемент по ключу
        map1.remove(5555);
        System.out.println(map1);

        //4
        //метод containsValue() - возвращает true если в нашем HashMap содержится определенное значение
        System.out.println(map1.containsValue("Ivan Ivanov"));

        //5
        //метод containsKey() - возвращает true если в нашем HashMap содержится определенный ключ
        System.out.println(map1.containsKey(1525));

        //6
        //метод keeSet() - возвращает множество всех ключей которыми мы пользуемся
        System.out.println(map1.keySet());

        //7
        //метод values() - возвращает множество значений в нашем HashMap
        System.out.println(map1.values());

        //8
        //**** метод entrySet() - метод будет разбираться после знакомства с внутренним устройством HashMap
        //код для примера из класса - Methods_equals_hashcode
//        for (Map.Entry<Student, Double> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        Map<String, String> map2 = new HashMap<>();
        map2.put("Sasha", "Dobriy");
        map2.put("Misha", "Umniy");



    }
}
