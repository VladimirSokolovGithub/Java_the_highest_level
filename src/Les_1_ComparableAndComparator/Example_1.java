package Les_1_ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example_1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Vladimir");
        list.add("Ivan");
        list.add("Mariya");
        System.out.println("List before sorting");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("List after sorting");
        System.out.println(list);
    }
}
