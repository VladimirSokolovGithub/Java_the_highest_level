package Les_3_Collection.Set_Interface.TreeSet;

import java.util.Objects;
import java.util.TreeSet;

public class Example_2_TreeSet {
    public static void main(String[] args) {
        //Деревья работают используя compareTo() или же при создании TreeSet мы можем указать Comparator
        //Метод equals() и hashCode() можно у деревьев не переопределять
        TreeSet<Student> treeSet = new TreeSet<>();

        Student st1 = new Student("Vladimir", 5);
        Student st2 = new Student("Misha", 1);
        Student st3 = new Student("Igor", 2);
        Student st4 = new Student("Marina", 3);
        Student st5 = new Student("Sonya", 4);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);

        System.out.println(treeSet);

        System.out.println(treeSet.first()); //возвращает студента с самым низким курсом который стоит первым

        System.out.println(treeSet.last()); //возвращает студента с самым высоким курсом который стоит последним


        Student st6 = new Student("Oleg", 3);

        System.out.println(treeSet.headSet(st6)); //Выведет студентов, которые учатся ниже чем Oleg, ниже чем на
                                                    // 3 курсе, берем студентов с головы(начала) нашего TreeSet

        System.out.println(treeSet.tailSet(st6)); //Выведет студентов, которые учатся выше чем Oleg, выше чем на
                                                    // 3 курсе, берем студентов с хвоста(конца) нашего TreeSet
                                                    //или же на том же курсе

        Student st7 = new Student("Ivan", 2);
        Student st8 = new Student("Elena", 4);

        System.out.println(treeSet.subSet(st7, st8)); //возвращает множество студентов, которые учатся на курсе
                                                        //выше чем 2 включительно и ниже чем 4 не включительно


        //Правило
        //Если мы создаём какой - то класс, то нужно переопределять метод equals()
        //Если a.equals(b) -> true, то и a.compareTo(b) -> 0

        System.out.println(st4.equals(st6));
        System.out.println(st4.compareTo(st6));
        System.out.println(st4.hashCode() == st6.hashCode());

    }
}

class Student implements Comparable <Student> {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }


    @Override
    public int compareTo(Student otherStudent) {
        return this.course - otherStudent.course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}