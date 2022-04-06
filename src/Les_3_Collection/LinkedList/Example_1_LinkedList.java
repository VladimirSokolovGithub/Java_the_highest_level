package Les_3_Collection.LinkedList;

import java.util.LinkedList;

public class Example_1_LinkedList {
    //Элементы LinkedList хранят ссылки на предыдущие и следующие элементы
    //В каком порядке мы добавили элементы в таком они и будут храниться в LinkedList
    //Вставка и удаление элементов в LinkedList происходят очень быстро так как мы просто меняем ссылки
    //на элементы

    public static void main(String[] args) {
        Student3 st1 = new Student3("Ivan", 3);
        Student3 st2 = new Student3("Nikolay", 2);
        Student3 st3 = new Student3("Elena", 1);
        Student3 st4 = new Student3("Petr", 4);
        Student3 st5 = new Student3("Mariya", 3);

        LinkedList<Student3> student3LinkedList = new LinkedList<>();
        student3LinkedList.add(st1);
        student3LinkedList.add(st2);
        student3LinkedList.add(st3);
        student3LinkedList.add(st4);
        student3LinkedList.add(st5);
        System.out.println("LinkedList = " + student3LinkedList);

        System.out.println(student3LinkedList.get(2));

        Student3 st6 = new Student3("Vladimir", 3);
        Student3 st7 = new Student3("Sergey", 4);

        student3LinkedList.add(st6);
        System.out.println("LinkedList = " + student3LinkedList);

        student3LinkedList.add(1,st7);
        System.out.println("LinkedList = " + student3LinkedList);

        student3LinkedList.remove(3);
        System.out.println("LinkedList = " + student3LinkedList);


    }
}

class Student3 {
    String name;
    int course;

    public Student3(String name, int course){
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
