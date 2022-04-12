package Les_3_Collection.Map_Interface.TreeMap;

import java.util.Objects;

public final class Student2 implements Comparable<Student2> {
    final String name;
    final String surname;
    final int course;

    public Student2(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Les_3_Collection.Map_Interface.TreeMap.Student2 student = (Les_3_Collection.Map_Interface.TreeMap.Student2) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    //Стандартная реализация среды разработки IntellijIdea
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }


    @Override
    public int compareTo(Student2 o) {
        return this.name.compareTo(o.name);
    }
}
