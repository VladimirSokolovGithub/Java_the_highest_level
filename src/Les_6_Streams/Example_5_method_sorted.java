package Les_6_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example_5_method_sorted {
    public static void main(String[] args) {
        //5
        //метод sorted() - делает сортировку, возвращает Stream

        //Объявляем массив int, переводим его в стрим, применяем метод sorted(), далее переводим стрим опять
        //в массив с помощью метода toArray(), который возвращает массив содержащий элементы этого потока и
        // присваиваем их в наш старый неотсортированный массив, перезаписывая его отсортированными элементами.
        int[] array = {3,8,1,5,9,12,4,21,81,7,18};
        array= Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));


        //Теперь попытаемся отсортировать List наших студентов

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

        //Берем ArrayList наших студентов, помещаем его элементы в стрим, сортируем методом sorted() и преобразуем
        //стрим в лист с помощью метода collect(Collectors.toList()).

//        students = students.stream().sorted().collect(Collectors.toList());

        //Но в таком виде у нас выбросится исключение ClassCastException так как java не находит Comparable и не
        //знает как сортировать наших студентов, поэтому в параметры метода sorted() мы должны вставить наш
        // Comparator (и сказать как сортировать студентов) с помощью лямбда выражения -
        // два элемента сравнивай по их имени в алфавитном порядке.
        students = students.stream().sorted((x,y) -> x.getName().compareTo(y.getName())).collect(Collectors.toList());
        System.out.println(students);
    }
}
