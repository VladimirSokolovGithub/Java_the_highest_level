package Les_3_Collection.Set_Interface.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class Example_1_TreeSet {
    //TreeSet хранит элементы в отсортированном по возрастанию порядке.
    //В основе TreeSet лежит TreeMap.
    //У элементов данного TreeMap ключи это элементы TreeSet, значение это константа-заглушка.
    //TreeSet не допускает дубликатов (повторяющихся значений).
    //В основе лежит красно-черное дерево.
    //null TreeSet хранить не может.

    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(10);

        System.out.println(treeSet);

        treeSet.remove(2);
        System.out.println(treeSet);

        System.out.println(treeSet.contains(1));

    }
}
