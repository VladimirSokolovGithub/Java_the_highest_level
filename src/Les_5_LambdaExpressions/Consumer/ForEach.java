package Les_5_LambdaExpressions.Consumer;

import java.util.ArrayList;
import java.util.List;
//Рассмотрим метод ForEach для коллекций, который принимает в параметры интерфейс Consumer - потребитель
public class ForEach {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "Hou are you?", "Very good", "Goodbye");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
        list.forEach(str -> System.out.println(str));

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.forEach(el -> {
            System.out.print(el + " ");
            el *= 2;
            System.out.print(el + " ");
            System.out.println();
        });
    }

}
