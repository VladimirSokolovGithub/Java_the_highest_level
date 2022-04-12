package Les_3_Collection.Set_Interface.LinkedHashSet;

import java.util.LinkedHashSet;

public class Example_1_LinkedHashSet {
    public static void main(String[] args) {
        //В LinkedHashSet соблюдается последовательность добавления элементов.
        //Можно использовать LinkedHashSet тогда, когда нам нужен HashSet и нужна последовательность элементов
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(5);
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(8);
        linkedHashSet.add(10);
        System.out.println(linkedHashSet);

        linkedHashSet.remove(8);
        System.out.println(linkedHashSet);

        System.out.println(linkedHashSet.contains(8));



    }
}
