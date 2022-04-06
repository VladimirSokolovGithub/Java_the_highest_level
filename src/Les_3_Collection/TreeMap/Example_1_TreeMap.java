package Les_3_Collection.TreeMap;

import java.util.Comparator;
import java.util.TreeMap;

public class Example_1_TreeMap {
    //Основная цель использования TreeMap - это нахождение отрезков(range - диапазона)

    public static void main(String[] args) {
        TreeMap<Double, Student2> treeMap = new TreeMap<>();

        Student2 st1 = new Student2("Vladimir", "Sokolov", 3);
        Student2 st2 = new Student2("Mariya", "Ivanova", 1);
        Student2 st3 = new Student2("Sergey", "Petrov", 4);
        Student2 st4 = new Student2("Vladimir", "Sokolov", 3);
        Student2 st5 = new Student2("Mariya", "Ivanova", 1);
        Student2 st6 = new Student2("Sergey", "Petrov", 4);
        Student2 st7 = new Student2("Elena", "Petrova", 4);
//        Student2 st8 = new Student2("Petr", "Sidorov", 4);

        treeMap.put(5.8, st1);
        treeMap.put(9.1, st7);
        treeMap.put(6.4, st2);
        treeMap.put(7.5, st4);
        treeMap.put(7.2, st3);
        treeMap.put(8.2, st6);
        treeMap.put(7.9, st5);
//        treeMap.put(9.1, st8);

        //При том что мы добавили элементы в TreeMap в разнобой, все они вывелись по возрастанию т.е.
        //были отсортированы по ключу.
        //Значение в TreeMap могут быть не уникальными, а вот ключи должны быть уникальными.
        //Если же ключ будет повторяться, то предыдущий объект с таким же ключом будет удален и заменен
        //вновь добавленным с таким же ключом.
        System.out.println(treeMap);

        //Рассмотрим методы
        //Put()
        //get()
        //remove()

        System.out.println(treeMap.get(6.4));
        treeMap.remove(5.8);
        System.out.println(treeMap);

        //метод descendingMap() - с помощью этого метода можно развернуть наш treeMap в обратную сторону
        System.out.println(treeMap.descendingMap());

        //Основная цель использования TreeMap - это нахождение отрезков(range - диапазона)
        //метод tailMap() - нахождение в treeMap значений выше чем в ключе указанном в параметре метода
        System.out.println(treeMap.tailMap(7.3));

        //метод headMap() - нахождение в treeMap значений ниже чем в ключе указанном в параметре метода
        System.out.println(treeMap.headMap(7.3));

        //метод lastEntry() - возвращает элемент treeMap, который находится в самом конце коллекции
        System.out.println(treeMap.lastEntry());

        //метод firstEntry() - возвращает элемент treeMap, который находится в самом начале коллекции
        System.out.println(treeMap.firstEntry());

        System.out.println();
        System.out.println();

//Теперь пусть ключом будут студенты
        //Но выйдет Exception - ClassCastException так как наш класс Student2 не имплементирует интерфейс
        //Comparable.
        //После имплементации в классе Student2 интерфейса Comparable и переопределения метода compareTo() и
        //реализации в нём сортировки по имени, наши ключи выведутся по именам, в алфавитном порядке
        TreeMap<Student2, Double> treeMap2 = new TreeMap<>();
        treeMap2.put(st1, 5.8);
        treeMap2.put(st7, 9.1);
        treeMap2.put(st2, 6.4);
        treeMap2.put(st4, 7.5);
        treeMap2.put(st3, 7.2);
        treeMap2.put(st6, 8.2);
        treeMap2.put(st5, 7.9);

        System.out.println(treeMap2);

        //Если же наш клас не реализует интерфейс Comparable, то есть другой метод правильно создать TreeMap
        TreeMap<Student2, Double> treeMap3 = new TreeMap<>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.name.compareTo(o2.name);
            }
        });


        //Если бы мы например не переопределили бы методы equals() и hashCode() в классе Student2, то
        //при сравнении ключей двух одинаковых объектов, один из которых конечно не добавлен в treeMap2
        //мы получим true, потому что при работе с TreeMap нет необходимости переопределять эти методы
        //для объекта ключа, потому что в TreeMap, все поиски, добавления и другие операции идут при помощи
        //compareTo() метода.
        // Но это правило не относится к значениям элементов TreeMap, например при работе метода
        //containsValue(st8) метод equals() будет использоваться, метод hashCode() не будет, но
        //хорошим тоном будет их переопределять всегда.

        Student2 st8 = new Student2("Elena", "Petrova", 4);
        System.out.println(treeMap2.containsKey(st8));
        System.out.println(treeMap2.containsValue(st8));

        //TreeMap не является потокобезопасной синхронизированной коллекцией, поэтому при работе с потоками
        //приходится синхронизировать самому вручную
    }
}


