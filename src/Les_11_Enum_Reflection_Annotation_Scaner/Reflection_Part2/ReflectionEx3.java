package Les_11_Enum_Reflection_Annotation_Scaner.Reflection_Part2;

import Les_11_Enum_Reflection_Annotation_Scaner.Ex5_Reflection_Part1.Employee;

import java.lang.reflect.Field;

public class ReflectionEx3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //Теперь рассмотрим очень интересный момент в Рефлексии. Перед этим закомментируем getters and setters,
        //которые устанавливают значение salary, у нашего класса Employee. Так же закомментируем конструктор,
        // который этот salary принимает.
        //Поле salary у нас private. И получается что теперь благодаря инкапсуляции нам до поля salary не добраться,
        //не прочитать и не изменить его из вне.
        //Допустим, что дефолтное значение поля salary = 1000, установим его в классе Employee.

        //Попробуем прочитать его.

        Employee employee = new Employee(10, "Vladimir", "IT");
        Class employeeClass = employee.getClass();
        //Теперь получим поле salary.
        Field field = employeeClass.getDeclaredField("salary");
        //Теперь попробуем значение нашего field записать в какую-либо переменную.
        //Но чтобы тать себе доступ на работу с private полем, нужно написать следующий код.
        field.setAccessible(true); //здесь мы говорим, что хотим получить доступ к филду, даже если оно private.
        double salaryValue = (Double) field.get(employee); //get() возвращает Object, поэтому нужен кастинг до Double
        System.out.println(salaryValue);

        //Таким же способом мы можем изменить значение филда salary.
        field.set(employee, 1500);
        System.out.println(employee);
        System.out.println(field.get(employee));

    }
}
