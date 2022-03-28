package Les_1_ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example_2_Comparable {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Vladimir", "Sokolov", 12345);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Sidorov", 8542);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
//        Employee[] employees = new Employee[] {emp1, emp2, emp3};
//        Arrays.sort(employees);
//        System.out.println(employees);
        System.out.println("Before sorting \n" + list);
        Collections.sort(list); //java не понимает как делать сортировку у объектов Employee,
        //по какому критерию, поэтому компилятор будет ругаться.
        // Но с помощью этого метода отлично отсортировал бы String или Integer
        //Поэтому для сравнения таких объектов нам нужно воспользоваться интерфейсом Comparable и его
        // методом compareTo(Employee o). Для этого в классе Employee имплементируем интерфейс Comparable<Employee>
        // и Override-им его метод compareTo и после этого этот же метод отлично заработает.
        System.out.println("After sorting \n" + list);
    }
}

class Employee implements Comparable<Employee> {
    Integer id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    //1-й способ переопределения метода compareTo - классический
//    @Override
//    public int compareTo(Employee anotherEmp) {
//        if (this.id == anotherEmp.id) {
//            return 0;
//        } else if (this.id < anotherEmp.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//    }

    //2-й способ, в основном все пишут так
//    @Override
//    public int compareTo(Employee anotherEmp) {
//        return this.id - anotherEmp.id;
//    }

    //3-й способ
//    @Override
//    public int compareTo(Employee anotherEmp) {
//        return this.id.compareTo(anotherEmp.id); //Это в случае сравнения объектов типа Integer используя
//                                                // функциональность самого Integer-a так как тот же Integer
//                                                // и тот же String имплементируют интерфейс Comparable
//    }

    // способ при сравнении имени работника т.е. String
    @Override
    public int compareTo(Employee anotherEmp) {
        int result = this.name.compareTo(anotherEmp.name);
        if (result == 0 ){
            result = this.surname.compareTo(anotherEmp.surname);
        }
        return result;
    }
}
