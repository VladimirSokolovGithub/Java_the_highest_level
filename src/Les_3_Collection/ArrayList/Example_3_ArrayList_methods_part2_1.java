package Les_3_Collection.ArrayList;

import java.util.ArrayList;
import java.util.Objects;

public class Example_3_ArrayList_methods_part2_1 {

    //7
    //indexOf(Object element) -> int
    //метод принимает в параметрах объект ArrayList и возвращает его позицию (индекс) или -1, если
    //такой объект в нашем ArrayList не найден

    public static void main(String[] args) {
        Student2 st1 = new Student2("Ivan", 'm', 22, 3, 8.3);
        Student2 st2 = new Student2("Nikolay", 'm', 28, 2, 6.4);
        Student2 st3 = new Student2("Elena", 'f', 19, 1, 8.9);
        Student2 st4 = new Student2("Petr", 'm', 35, 4, 7.0);
        Student2 st5 = new Student2("Mariya", 'f', 23, 3, 7.4);

        ArrayList<Student2> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        System.out.println(studentList);

        //В нашем случае объект st6 в ArrayList не добавлен, но благодаря переопределенному методу equals
        //этот объект st6 в методе indexOf(st6) сравнивается с объектом st5 и так как все поля равны,
        //следовательно, объекты равны и метод возвращает нам индекс 4.
        //Но если бы метод equals не был бы переопределен то вернётся -1
        Student2 st6 = new Student2("Mariya", 'f', 23, 3, 7.4);
        System.out.println(studentList);

        int index = studentList.indexOf(st6);
        System.out.println(index);

    }
}

class Student2 {
    private String name;
    private char sex;
    private int age;
    private int course;
    private Double avgGrage;

    public Student2(String name, char sex, int age, int course, Double avgGrage) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrage = avgGrage;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrage=" + avgGrage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student = (Student2) o;
        return sex == student.sex &&
                age == student.age &&
                course == student.course &&
                Objects.equals(name, student.name) &&
                Double.compare(student.avgGrage, avgGrage) == 0;
    }
}
