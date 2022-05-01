package Les_6_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example_17_method_mapToInt {
    public static void main(String[] args) {

        //метод mapToInt() - этот метод возвращает Int stream.
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

        List<Integer> courses = students.stream()
                .mapToInt(el -> el.getCourse())
                .boxed()
                .collect(Collectors.toList());

        //метод boxed() конвертирует значение int в Integer

        System.out.println(courses);

        //У класса IntStream есть методы, которые работают с числами.
        //1
        //метод sum() - возвращает int и суммирует интовые элементы нашего стрима.
        int sum = students.stream().mapToInt(el -> el.getCourse()).sum();
        System.out.println(sum);

        //2
        //метод average() - возвращает OptionalDouble среднеарифметическое значение, элементов нашего стрима.
        double average = students.stream().mapToInt(el -> el.getCourse()).average().getAsDouble();
        System.out.println(average);

        //3
        //метод min() - возвращает OptionalInt минимальное значение, элементов нашего стрима.
        int min = students.stream().mapToInt(el -> el.getCourse()).min().getAsInt();
        System.out.println(min);

        //3
        //метод max() - возвращает OptionalInt максимальное значение, элементов нашего стрима.
        int max = students.stream().mapToInt(el -> el.getCourse()).max().getAsInt();
        System.out.println(max);



        //метод mapToDouble() - этот метод возвращает Double stream.
        List<Double> avgGrade = students.stream()
                .mapToDouble(el -> el.getAvgGrage())
                .boxed()
                .collect(Collectors.toList());

        System.out.println(avgGrade);
    }
}
