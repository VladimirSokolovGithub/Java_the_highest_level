package Les_5_LambdaExpressions.Function;

import Les_5_LambdaExpressions.lambda_expressions_part1.Student;

import java.util.List;
import java.util.function.Function;

import java.util.ArrayList;

public class Example_1_Function {
    //Интерфейс Function<T, R> принимает в параметры два значения.
    //Метод интерфейса Function - R apply (T t), у него 2 параметра. Первый из них Т - это входной параметр,
    // второй R - это return type - возвращаемый тип.
    //Таким образом когда нужно принять на вход один тип данных, а на выход отдать другой можно использовать
    //Интерфейс Function<T, R>

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


        //Перед нами стоит задача найти среднеарифметическое по всем студентам по разным показателям.
        //Нужно написать код, который будет принимать любой из параметров(курс, возраст, средняя оценка).
        //Т.е на input я должен передавать студента (это Т - входной параметр метода R apply (T t)),
        //а получать double (вместо R - это return type).

        //Пример лямбда выражения с использованием интерфейса Function
        Function<Student, Double> f = student -> student.avgGrade;

        //Пример работы метода avgOfSomething
        double result = avgOfSomething(students, student -> student.avgGrade);
        System.out.println(result);

        double result2 = avgOfSomething(students, student -> (double)student.course);
        System.out.println(result2);

        double result3 = avgOfSomething(students, student -> (double)student.age);
        System.out.println(result3);


    }
    //А теперь создам метод с использованием интерфейса Function<T, R>
    //Я говорю что у функционального интерфейса Function, есть метод apply, который принимает в параметры Student
    //и возвращает Double. Что это за Double я здесь не прописываю, его я буду указывать с помощью лямбда
    // выражения, когда буду вызывать метод avgOfSomething.
    //А пока я пишу к result прибавлять Double, который вернёт наш функциональный интерфейс "f", на котором
    //вызывается метод apply(st) в параметрах которому передаётся студент. Этот метод мы будем переопределять
    //с помощью лямбда выражений при вызове метода avgOfSomething.
    private static double avgOfSomething(List<Student> list, Function<Student, Double> f) {
        double result = 0;
        for (Student st : list){
            result += f.apply(st);
        }
        result = result/list.size();
        return result;
    }
}

