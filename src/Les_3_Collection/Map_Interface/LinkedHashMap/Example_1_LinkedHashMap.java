package Les_3_Collection.Map_Interface.LinkedHashMap;

import Les_3_Collection.Map_Interface.TreeMap.Student2;

import java.util.LinkedHashMap;

public class Example_1_LinkedHashMap {
    public static void main(String[] args) {
        //При создании LinkedHashMap мы можем указать 3 параметра:
        // -Capacity, loadFactor,
        // и 3-й параметр - это как мы хотим сохранять порядок,
        // порядок добавления элементов или порядок использования элементов (значение false - по умолчанию
        // это порядок добавления элементов, значение true - порядок постоянно будет меняться в зависимости от того,
        // какие элементы были использованы в каком порядке-например методы put() b get()).
        // В примере ниже видно, что последний элемент который мы использовали с помощью метода get(), стал
        // на последнее место в LinkedHashMap, перед ним на предпоследний, остальные не поменяли свою последовательность


        LinkedHashMap<Double, Student2> lhm = new LinkedHashMap<>(16, 0.75f, true);

        Student2 st1 = new Student2("Vladimir", "Sokolov", 3);
        Student2 st2 = new Student2("Mariya", "Ivanova", 1);
        Student2 st3 = new Student2("Sergey", "Petrov", 4);
        Student2 st4 = new Student2("Igor", "Sidorov", 3);

        //В LinkedHashMap в каком порядке элементы добавлены, в таком порядке они и содержаться в коллекции.
        //Кроме того, что LinkedHashMap содержит элементы коллекции, он так же содержит ссылку на предыдущий
        //добавленный элемент и на следующий добавленный элемент.
        lhm.put(6.4, st3);
        lhm.put(7.5, st4);
        lhm.put(5.8, st1);
        lhm.put(9.1, st2);

        System.out.println(lhm);

        System.out.println(lhm.get(6.4));
        System.out.println(lhm.get(7.5));

        System.out.println(lhm);
    }
}
