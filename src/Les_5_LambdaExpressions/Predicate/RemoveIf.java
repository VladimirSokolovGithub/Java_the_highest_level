package Les_5_LambdaExpressions.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveIf {
    //Метод removeIf() удаляет объекты из коллекции по какому-то критерию, используя в своём параметре
    //объект типа интерфейса Predicate.

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("Hello");
        al.add("Goodbye");
        al.add("Ok");
        al.add("Learning Java");
        al.add("Lambdas");

        System.out.println(al);
//        al.removeIf(element -> element.length() < 5);

        //то же самое применяя другую методику записи
        Predicate<String> p = element -> element.length() < 5;
        al.removeIf(p);
        System.out.println(al);
    }
}
