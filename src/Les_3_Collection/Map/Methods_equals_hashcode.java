package Les_3_Collection.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Methods_equals_hashcode {
    public static void main(String[] args) {
        //создадим HashMap который будет содержать студента и его среднюю оценку
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Vladimir", "Sokolov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 9.2);
        System.out.println(map);

        Student st4 = new Student("Vladimir", "Sokolov", 3);

        boolean result = map.containsKey(st4); //false без метода hashCode() и true с методом hashCode()
        System.out.println("result = " + result);
        System.out.println(st1.equals(st4)); //true без метода hashCode() и true с методом hashCode()

        //Всё дело в том что некоторые коллекции используют кэширование при поиске и сравнении
        //т.е. одного метода equals недостаточно что бы сравнить объекты в HashMap и HashSet, должен ещё быть корректно
        //переопределенный метод hashCode()

        //Хеширование - это преобразование с помощью метода hashCode() любого объекта в int
        //Сравнение в HashMap сначала идёт по hashCode() и лишь потом по equals()
        //У объектов String и Integer, Double и в других стандартных методах java методы hashCode() и equals()
        // отлично переопределены, поэтому при использовании этих типов в HashMap все прекрасно работает.

        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());

        System.out.println();
        Student st5 = new Student("Marshal", "Sidorov", 4);

        //Эти хеш коды равны, что означает что наш метод hashCode() написан не очень качественно
        //Когда у разных объектов возвращается одинаковый хеш код - это называется коллизией и чем меньше
        //коллизий, тем лучше
        System.out.println(st1.hashCode());
        System.out.println(st5.hashCode());

        System.out.println();

        System.out.println(st1.hashCode());
        System.out.println(st4.hashCode());

        //Но если даже мы не переопределяем метод hashCode(), всё равно он будет у наших объектов, как дефолтная
        //реализация от Object.(в алгоритме реализации этого hashCode() используется адрес нашего объекта), но
        //в этом случае хеш коды у одинаковых объектов будут разными, поэтому нужно всегда переопределять этот метод


        //8
        //**** метод entrySet() - метод будет разбираться после знакомства с внутренним устройством HashMap
        //Entry - это интерфейс внутренний для Map, который имплементируется классом Node внутренним для Map.
        for (Map.Entry<Student, Double> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

class Student {
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    //Стандартная реализация среды разработки IntellijIdea
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }


//    //Собственная реализация
//    //в hashCode() очень часто задействованы поля нашего класса
//    @Override
//    public int hashCode() {
//        return name.length() + surname.length() + course;
//    }

    //Собственная реализация с уменьшением коллизий
    //для этого используем простые числа, это числа которые делятся только на себя или на единицу нацело,
    //но и эта реализация далека от совершенства, поэтому в нашем примере реализация от среды разработки
    //самая нормальная
//    @Override
//    public int hashCode() {
//        return name.length()*7 + surname.length()*11 + course*53;
//    }
}
