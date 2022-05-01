package Les_6_Streams;

import java.util.ArrayList;
import java.util.List;

public class Example_11_method_flatMap {
    public static void main(String[] args) {

        //метод flatMap() - используется тогда, когда нам нужно поработать не с самими элементами нашей коллекции,
        //а с элементами элементов нашей коллекции. Это intermediate метод.

        //У нас есть List факультетов, который содержит факультеты, а сами факультеты содержат Листы своих
        //студентов.

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7.0);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Applied mathematics");

        f1.addStudentsOnFaculty(st1);
        f1.addStudentsOnFaculty(st2);
        f1.addStudentsOnFaculty(st3);

        f2.addStudentsOnFaculty(st4);
        f2.addStudentsOnFaculty(st5);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        //И с помощью метода flatMap(), в нашем случае, мы хотим вывести имена всех студентов всех факультетов.
        //Создадим stream на листе facultyList и вызовем метод flatMap, передаём в него как элемент faculty (факультет
        // f1, f2 которые содержат ArrayList студентов), из faculty получаю другой List с помощью метода
        // getStudentsOnFaculty() и уже на этом Листе студентов конкретного факультета вызываем метод stream() -
        // создаём новый стрим (отдельный стрим для каждого элемента листа факультетов) и с помощью
        // метода forEach уже перебираем и выводим имя каждого студента.

        facultyList.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
                .forEach(e -> System.out.println(e.getName()));
    }
}

class Faculty{
    String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void addStudentsOnFaculty(Student student){
        studentsOnFaculty.add(student);
    }
}