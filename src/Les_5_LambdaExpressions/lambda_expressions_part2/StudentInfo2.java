package Les_5_LambdaExpressions.lambda_expressions_part2;

import Les_5_LambdaExpressions.lambda_expressions_part1.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentInfo2 {

    void testStudents(ArrayList<Student> students, StudentChecks sc){
        for (Student s : students){
            if (sc.check(s)){
                System.out.println(s);
            }
        }
    }

}

class Test {
    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo2 info = new StudentInfo2();
        //Допустим мы хотим отсортировать всех студентов которые находятся в ArrayList<Student> students.
        //Мы не имплементировали в классе Student интерфейс Comparable, поэтому мы будем использовать
        //Comparator.

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.course - s2.course;
            }
        }); //вторым параметром будет Comparator

        System.out.println(students);

        System.out.println();

        //То же самое мы можем сделать не используя анонимный класс, а используя лямбда выражения, так
        // как интерфейс Comparator имеет один абстрактный метод и является функциональным.

        Collections.sort(students, (s1, s2) -> s1.course - s2.course); //вторым параметром будет Comparator

        System.out.println(students);

    }
}

interface StudentChecks{
    boolean check(Student s);
}