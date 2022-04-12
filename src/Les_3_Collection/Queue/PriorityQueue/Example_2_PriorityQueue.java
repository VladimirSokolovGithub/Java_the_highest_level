package Les_3_Collection.Queue.PriorityQueue;

import java.util.Objects;
import java.util.PriorityQueue;

public class Example_2_PriorityQueue {
    public static void main(String[] args) {
        Student5 st1 = new Student5("Vladimir", 5);
        Student5 st2 = new Student5("Misha", 1);
        Student5 st3 = new Student5("Igor", 2);
        Student5 st4 = new Student5("Marina", 3);
        Student5 st5 = new Student5("Sonya", 4);

        PriorityQueue<Student5> priorityQueue = new PriorityQueue<>();
        //Если бы наш класс Student5 не имплементировал бы интерфейс Comparable, то выходил бы Exception при
        //добавлении элементов.

        //Так же у PriorityQueue есть конструктор, который принимает Comparator.
        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);
        priorityQueue.add(st5);

        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());

        System.out.println();

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}

class Student5 implements Comparable <Student5> {
    String name;
    int course;

    public Student5(String name, int course) {
        this.name = name;
        this.course = course;
    }


    @Override
    public int compareTo(Student5 otherStudent) {
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
        Student5 student = (Student5) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}