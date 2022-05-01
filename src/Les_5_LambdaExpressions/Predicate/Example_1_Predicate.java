package Les_5_LambdaExpressions.Predicate;

import Les_5_LambdaExpressions.lambda_expressions_part1.Student;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Example_1_Predicate {

}

class StudentInfo {

    void testStudents(ArrayList<Student> students, Predicate<Student> st){
        for (Student s : students){
            if (st.test(s)){
                System.out.println(s);
            }
        }
    }

}

class Test{
    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        ArrayList<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();



        info.testStudents(students, (Student student) -> {return student.age < 30;});
        System.out.println("______________________");
        info.testStudents(students, (Student s) -> {return s.age > 20 && s.avgGrade < 9.5 && s.sex == 'f';});

        //Допустим мы хотим отфильтровать студентов по двум критериям avgGrade и sex.
        //Мы можем объединить эти две фильтрации (две строчки кода в одну) и достигается всё это с помощью
        //метода and().
        //т.е. метода and() выводит студента который, соответствует и первому и второму условию одновременно
        Predicate<Student> p1 = student -> student.avgGrade > 7.5;
        Predicate<Student> p2 = student -> student.sex == 'm';

        info.testStudents(students, p1.and(p2));
        System.out.println("________________");

        //Так же есть метод or(), выводит студентов, которые соответствуют или первому или второму условиям
        info.testStudents(students, p1.or(p2));

        System.out.println("________________");
        //метод negate() - в переводе отрицать. Метод отрицает какую то нашу уже написанную проверку, например
        //у проверки p1 у нас avgGrade студента > 7.5, а применив метод negate(), avgGrade студента станет < меньше 7.5
        info.testStudents(students, p1.negate());
    }
}


