package Les_6_Streams;

import java.util.ArrayList;
import java.util.List;

public class Example_16_method_skip {
    public static void main(String[] args) {

        //метод skip() - Ограничивает количество элементов в нашем стриме,
        //будет пропускать первые n элементов в нашем стриме, выводя все последующие после количества указанного
        //в параметре метода.
        //Это intermediate метод.

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7.0);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students.stream().filter(e -> e.getAge() > 20).forEach(System.out::println);
        System.out.println("________________________________________________");
        students.stream().filter(e -> e.getAge() > 20).limit(2).forEach(System.out::println);
        System.out.println("________________________________________________");
        students.stream().filter(e -> e.getAge() > 20).skip(2).forEach(System.out::println);

    }
}
