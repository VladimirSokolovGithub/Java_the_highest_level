package Les_1_ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example_3_Comparator {
    public static void main(String[] args) {
        List<Employee2> list = new ArrayList<>();
        Employee2 emp1 = new Employee2(100, "Vladimir", "Sokolov", 12345);
        Employee2 emp2 = new Employee2(15, "Ivan", "Petrov", 6542);
        Employee2 emp3 = new Employee2(123, "Ivan", "Sidorov", 8542);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

//        System.out.println("Before sorting \n" + list);
//        Collections.sort(list, new IdComparator());
//        System.out.println("After sorting \n" + list + "\n");
//
//        System.out.println("Before sorting \n" + list);
//        Collections.sort(list, new NameComparator());
//        System.out.println("After sorting \n" + list + "\n");

        System.out.println("Before sorting \n" + list);
        Collections.sort(list, new SalaryComparator()); //Для написания этого второго параметра сортировки зарплаты
        // можно не создавать отдельный класс, а использовать анонимный класс или лямбда выражения
        // (это будет рассмотрено позже)
        System.out.println("After sorting \n" + list + "\n");

        //Имплементируя одновременно интерфейс Comparable в основном классе Employee2 + переопределяя метод
        //compareTo и сочетая его с созданными классами, например SalaryComparator, для сортировки
        // имплементирующими интерфейс Comparator + переопределяя его метод compare, мы можем гибко подходить
        // к вопросу сортировки с помощью добавления параметра в методе Collections.sort(list), тем самым
        // перезатирая основную сортировку в нашем случае по id - на сортировку по salary -
        // Collections.sort(list, new SalaryComparator())

//        System.out.println("Before sorting \n" + list);
//        Collections.sort(list);
//        System.out.println("After sorting \n" + list + "\n");
    }
}

class Employee2
        implements Comparable<Employee2>
{
    Integer id;
    String name;
    String surname;
    int salary;

    public Employee2(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    //Имплементируя интерфейс Comparable и переопределяя его метод compareTo, так же рекомендуется,
    // но не является обязательным переопределить и метод "equals", что бы объекты были равны и в методе
    // compareTo и в методе "equals"
    @Override
    public int compareTo(Employee2 anotherEmp) {
        if (this.id == anotherEmp.id) {
            return 0;
        } else if (this.id < anotherEmp.id) {
            return -1;
        } else {
            return 1;
        }
    }
}



//class IdComparator implements Comparator <Employee2> {
//    @Override
//    public int compare(Employee2 emp1, Employee2 emp2) {
//        if (emp1.id == emp2.id) {
//            return 0;
//        } else if (emp1.id < emp2.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//    }
//}

class NameComparator implements Comparator <Employee2> {
    @Override
    public int compare(Employee2 emp1, Employee2 emp2) {
        return emp1.name.compareTo(emp2.name); //здесь используется метод compareTo класса String так как он
        //имплементирует интерфейс Comparable
    }
}

class SalaryComparator implements Comparator <Employee2> {
    @Override
    public int compare(Employee2 emp1, Employee2 emp2) {
        return emp1.salary - emp2.salary; //Если у первого работника зарплата больше чем у второго, то вернется
        //положительное значение, если у первого работника зарплата меньше чем у второго, то вернется
        // отрицательное значение, если зарплаты равны, то вернется ноль.
    }
}