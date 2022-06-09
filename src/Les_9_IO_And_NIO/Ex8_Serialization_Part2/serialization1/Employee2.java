package Les_9_IO_And_NIO.Ex8_Serialization_Part2.serialization1;

import Les_9_IO_And_NIO.Ex7_Serialization_Part1.serialization1.Car;

import java.io.Serializable;

public class Employee2 implements Serializable {
    //Представим себе, что по определенным причинам мы не должны отправлять информацию о зарплате работника.
    //Для того, что бы при сериализации данные о поле salary не попадали в файл, дя этого существует ключевое
    //слово transient - переводится как временный.
    //Поэтому при десериализации наше поле будет выведено в консоль со значением ноль. Потому что мы не
    //сереализировали это поле, а дефолтное значение у типа double = 0.0.

    //Немного изменим наш пример. Предположим, что много программистов используют на своих компьютерах
    //проект связанный с вручением бонусов. И например я изменил класс Employee2, добавив фамилию.
    //А так же что при вручении бонусов нам не нужно знать возраст и я убрал поле age.
    //Теперь при десериализации нашего файла, второй програмист получит InvalidClassException так как
    //пользуется не измененной версией класса Employee2 и ничего не знает о том что там добавлена фамилия и
    //убран возраст.
    //И этот InvalidClassException сообщает нам о том, что serialVersionUID у наших классов разные.
    //stream classdesc serialVersionUID = 4782994865945471872, local class serialVersionUID = 5742931337867348575

    //Таким образом появилось правило что, если мы меняем класс, объект которого мы хотим сериализовать, то
    //нам нужно менять и версию этого класса. Поле serialVersionUID как раз и есть версия нашего класса.
    //Если версию не указать самостоятельно, то компилятор сделает это за нас сам.
    //Таким образом serialVersionUID пользуются при десериализации, что бы проверить, что когда делали
    //сериализацию программист - отправитель файла и когда делает десериализацию программист 2 - получатель
    //файла, одинаковые ли версии класса мы используем для этого.

    //Настоятельно рекомендуется, чтобы все сереализуемые классы явно объявляли значение serialVersionUID,
    //поскольку вычисление serialVersionUID по умолчанию очень чувствительно к деталям класса, которые
    //могут различаться от реализации компилятора и могут привезти к неожиданным исключениям во время
    // десериализации.

    static final long serialVersionUID = 2; //Правило написания serialVersionUID
    String name;
    String surname;
    String department;
//    int age;
    transient double salary;
    Car car;

    public Employee2(String name,
                     String surname,
                     String department,
//                     int age,
                     double salary, Car car) {
        this.name = name;
        this.surname = surname;
        this.department = department;
//        this.age = age;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                ", department='" + department + '\'' +
//                ", age=" + age +
                ", salary=" + salary +
                ", car =" + car +
                '}';
    }
}
