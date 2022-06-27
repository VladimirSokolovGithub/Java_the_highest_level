package Les_11_Enum_Reflection_Annotation_Scaner.Ex6_Reflection_Part2;


//Поговорим как с помощью Reflection можно создать объекты и вызвать на них методы.

import Les_11_Enum_Reflection_Annotation_Scaner.Ex5_Reflection_Part1.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionEx2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException
            , IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class employeeClass = Class.forName("Les_11_Enum_Reflection_Annotation_Scaner.Ex5_Reflection_Part1.Employee");

        //Создание объекта.
        //Создадим объект типа(класса) Employee с помощью объекта employeeClass.
        //В версиях Java ниже 11-й мы могли создать объект класса Employee следующим способом:
        Object o  = employeeClass.newInstance(); //или так
        Employee employee  = (Employee)employeeClass.newInstance(); //или так с кастингом
        System.out.println(o);
        System.out.println(employee);
        //Но с 11-й версии Java, метод newInstance() является deprecated,
        // поэтому будем создавать объект другим способом.
        //Сейчас рекомендуется метод newInstance() вызывать на конструкторе (класс Constructor).
        // Так же нужно обратить внимание, что Constructor работает с generics и мы можем либо использовать кастинг,
        // или generics у конструктора.
        Constructor constructor1 = employeeClass.getConstructor();
        Object obj1 = constructor1.newInstance(); //или так, помещаем объект класса Employee в Object
        Employee obj2 = (Employee)constructor1.newInstance(); //или так с кастингом

        //Или так с использованием generics в Constructor:
        Constructor<Employee> constructor2 = employeeClass.getConstructor();
        Employee obj3 = constructor2.newInstance(); //и тогда мы сразу без кастинга сможем указать,
                                                    // что constructor2.newInstance() возвращает Employee


        //Создадим объект с помощью конструктора, который имеет три параметра.
        Constructor constructor3 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object obj4 = constructor3.newInstance(5, "Vladimir", "IT");
        System.out.println(obj4);



        //Теперь с помощью Reflection вызовем метод setSalary.
        //Для начала мы должны создать этот метод - как объект класса Method, вызвав у employeeClass.getMethod(в
        // параметрах указывается название метода и то что метод принимает у себя в параметре, в нашем случае это double).
        Method method = employeeClass.getMethod("setSalary", double.class);
        //Теперь мы можем запускать этот метод, вызвав у объекта method метод invoke(и указав в параметрах: первый
        // параметр это объект у которого мы хотим вызвать этот метод далее параметры нашего метода
        // в нашем случае это double).
        method.invoke(obj4, 800.88);
        System.out.println(obj4);


    }
}
