package Les_3_Collection.ArrayList;

import java.util.ArrayList;
import java.util.Objects;

public class Example_2_ArrayList_methods_part1_1 {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7.0);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        System.out.println(studentList);

        Student st6 = new Student("Mariya", 'f', 23, 3, 7.4);
//        studentList.add(st6);
        System.out.println(studentList);

        //4
        //remove(Object element) -> boolean
        //remove(int index) -> DataType
        //метод remove удаляет элемент из ArrayList, оставшиеся элементы сдвигаются влево

        //В нашем случае объект st6 - вторая Mariya будет удалён, так как мы добавили его в наш ArrayList
        studentList.remove(st6);
        System.out.println(studentList);
        //Но если мы бы не добавили объект st6 в ArrayList, и захотели бы удалить идентичный объект st5 - Mariya,
        //то у нас бы ничего не получилось так как это разные объекты и сравниваются они с помощью метода equals,
        //который, в данный момент, у нас не переопределён и сравнивает ссылки на объекты.
        //Но переопределив метод equals, тем самым сказав как нужно сравнивать объекты, мы удалим объект st5 из
        //нашего ArrayList.
    }
}

class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private Double avgGrage;

    public Student(String name, char sex, int age, int course, Double avgGrage) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrage = avgGrage;
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

    //Попробуем переопределить метод equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex &&
                age == student.age &&
                course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(avgGrage, student.avgGrage);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return sex == student.sex &&
//                age == student.age &&
//                course == student.course &&
//                Objects.equals(name, student.name) &&
//                Double.compare(student.avgGrage, avgGrage) == 0;
//    }
}
