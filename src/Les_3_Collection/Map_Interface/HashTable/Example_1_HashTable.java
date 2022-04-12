package Les_3_Collection.Map_Interface.HashTable;

import Les_3_Collection.Map_Interface.TreeMap.Student2;

import java.util.Hashtable;

public class Example_1_HashTable {
    public static void main(String[] args) {
        //HashTable - это synchronized класс, который можно использовать в многопоточности(multi threading).
        //Но так как класс устаревший и нужна поддержка многопоточности, нужно использовать Concurrent HashMap.
        //В HashTable не ключ и не значение не могут быть null

        Hashtable<Double, Student2> ht = new Hashtable<>();

        Student2 st1 = new Student2("Vladimir", "Sokolov", 3);
        Student2 st2 = new Student2("Mariya", "Ivanova", 1);
        Student2 st3 = new Student2("Sergey", "Petrov", 4);
        Student2 st4 = new Student2("Igor", "Sidorov", 3);

        ht.put(7.8, st1);
        ht.put(9.3, st2);
        ht.put(5.8, st3);
        ht.put(6.0, st4);

        System.out.println(ht);

    }
}
