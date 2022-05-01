package Les_6_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example_2_method_filter {
    public static void main(String[] args) {
        //2
        //метод filter()

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

        //Теперь отфильтруем студентов чей возраст 22 года и старше и средняя оценка меньше 7.2.
        //Метод filter() вернет Stream, который соответствует условиям, которые мы пропишем в теле метода.
        students = students.stream().filter(el
                -> el.getAge() > 22 && el.getAvgGrage() < 7.2).collect(Collectors.toList());
        System.out.println(students);

        //**********//
        //ВАЖНО!!!
        //Необязательно создавать Stream из готового массива или коллекции, мы так же можем создать его с нуля.

        Stream<Student> myStream = Stream.of(st1, st2, st3, st4, st5);
        List<Student> list2 = myStream.filter(el
                -> el.getAge() > 22 && el.getAvgGrage() < 7.2).collect(Collectors.toList());
        System.out.println(list2);
    }
}

class Student{
    private String name;
    private char sex;
    private int age;
    private int course;
    private Double avgGrage;

    public Student(String name, char sex, int age, int course, Double avgGrage) {
        this.setName(name);
        this.setSex(sex);
        this.setAge(age);
        this.setCourse(course);
        this.setAvgGrage(avgGrage);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrage=" + avgGrage +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Double getAvgGrage() {
        return avgGrage;
    }

    public void setAvgGrage(Double avgGrage) {
        this.avgGrage = avgGrage;
    }
}