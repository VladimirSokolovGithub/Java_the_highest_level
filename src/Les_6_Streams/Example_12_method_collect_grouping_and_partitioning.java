package Les_6_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Example_12_method_collect_grouping_and_partitioning {
    public static void main(String[] args) {

        //метод collect() - уже знаком. Используется для того что бы поток(stream) преобразовать в List, Set
        //или какую либо другую коллекцию.
        //Когда мы использовали этот метод мы использовали class Collectors у которого есть два интересных метода:
        //groupingBy() and partitioningBy().
        //Эти методы при использовании стримов очень популярны.

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

        //метод groupingBy() - означает группировка по.
        //Изменим написание имён студентов заглавными буквами и отсортируем их по курсам. Для каждого курса
        //у нас будет свой лист. Метод collect() в данном случае вернет нам Map в качестве ключа будет курс, а
        // в качестве значения лист студентов.

        Map<Integer, List<Student>> map = students.stream().map(el -> {
            el.setName(el.getName().toUpperCase());
            return el;
        }).collect(Collectors.groupingBy(el -> el.getCourse()));

        for (Map.Entry<Integer, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }

        //метод partitioningBy() - означает разделение по.
        //Поделим студентов на две группы, те кто получают высокую оценку >7 и те кто низкую <7.

        Map<Boolean, List<Student>> map2 = students.stream().collect(Collectors
                .partitioningBy(el -> el.getAvgGrage() > 7));

        for (Map.Entry<Boolean, List<Student>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }

    }
}
