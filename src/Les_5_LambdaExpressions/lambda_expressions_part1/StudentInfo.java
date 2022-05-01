package Les_5_LambdaExpressions.lambda_expressions_part1;

import java.util.ArrayList;

public class StudentInfo {

    //нам достаточно написать всего лиш один метод, который в параметрах будет принимать ArrayList<Student> и
    //объект класса, который будет имплементировать интерфейс StudentChecks.

    void testStudents(ArrayList<Student> students, StudentChecks sc){
        for (Student s : students){
            if (sc.check(s)){
                System.out.println(s);
            }
        }
    }

//    void printStudentsOverGrade(ArrayList<Student> students, double grade){
//        for (Student s : students){
//            if (s.avgGrade > grade){
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsUnderAge(ArrayList<Student> students, int age){
//        for (Student s : students){
//            if (s.age < age){
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsMixCondition(ArrayList<Student> students, int age, double grade, char sex){
//        for (Student s : students){
//            if (s.age > age && s.avgGrade < grade && s.sex == sex){
//                System.out.println(s);
//            }
//        }
//    }

}

class Test{
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

        StudentInfo info = new StudentInfo();
        info.testStudents(students, new CheckOverGrade());

        System.out.println("______________________");

        //использование анонимного класса вместо класса CheckOverGrade.
        info.testStudents(students, new StudentChecks(){
            @Override
            public boolean check(Student s){
                return s.age < 30;
            }
        });

        System.out.println("______________________");
        System.out.println("Теперь используем лямбда выражения");
        System.out.println("______________________");

        //И теперь после всего проделанного можно приступить к написанию Lambda выражений
        //Теперь вместо написания анонимного класса мы берем его самую нужную вещь, а именно параметры и
        //тело метода check и вставляем вторым параметром в наш метод testStudents()
        info.testStudents(students, (Student student) -> {return student.age < 30;});
        System.out.println("______________________");


 //****       //***** Далее рассмотрим разные варианты написания лямбда выражений
        info.testStudents(students, (Student student) -> {return student.avgGrade > 8;});
        info.testStudents(students, student -> student.avgGrade > 8);
        info.testStudents(students, student -> {return student.avgGrade > 8;});
        info.testStudents(students, (Student student) -> student.avgGrade > 8);
        info.testStudents(students, student -> {System.out.println("Hello"); return student.avgGrade > 8;});

//*****      //Ещё один тип написания лямбда выражений. Можно вынести наше лямбда выражение из параметра
        //метода.

        StudentChecks sc = (Student student) -> {return student.avgGrade > 8;};
        info.testStudents(students, sc);


        System.out.println("______________________");
        info.testStudents(students, (Student s) -> {return s.age > 20 && s.avgGrade < 9.5 && s.sex == 'f';});



//        StudentInfo info = new StudentInfo();
//        info.printStudentsOverGrade(students, 8);
//        System.out.println("______________________");
//        info.printStudentsUnderAge(students, 30);
//        System.out.println("______________________");
//        info.printStudentsMixCondition(students, 20, 9.5, 'f');
    }
}

//Что можно сделать чтобы не писать все эти методы в классе StudentInfo, тем более если нам нужно будет
//создать новую фильтрацию и соответственно новый метод, или же мы не будем иметь доступа у StudentInfo,
//для его модификации.

//Создадим interface у которого всего один метод. И тогда внутри класса StudentInfo нам достаточно написать
//всего лиш один метод.
//Такой интерфейс ещё называют функциональным, так как он содержит всего один абстрактный метод, который
//мы и используем для написания лямбда выражений. Такой интерфейс так же может содержать другие статический
//или дефолтные методы, но абстрактный метод должен быть только один.
interface StudentChecks{
    boolean check(Student s);
}

//Заменить класс CheckOverGrade нам поможет анонимный класс.
class CheckOverGrade implements StudentChecks {

    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8;
    }
}