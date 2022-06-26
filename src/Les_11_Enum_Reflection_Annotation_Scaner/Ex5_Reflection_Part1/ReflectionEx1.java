package Les_11_Enum_Reflection_Annotation_Scaner.Ex5_Reflection_Part1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionEx1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException
            , NoSuchMethodException {
        //Рассмотрим три варианта создания объекта класса "Class".
        //1.
        //в кавычках указываем полный путь к нашему классу пакет.className
//        Class employeeClass = Class.forName("Les_11_Enum_Reflection_Annotation_Scaner.Ex5_Reflection_Part1.Employee");

        //2.
//        Class employeeClass2 = Employee.class;

        //3.
//        Employee employee = new Employee();
//        Class employeeClass3 = employee.getClass();


        //a. Доступ к полям класса

        Class employeeClass = Class.forName("Les_11_Enum_Reflection_Annotation_Scaner.Ex5_Reflection_Part1.Employee");
        //Есть метод  getField("id"), который мы можем вызвать у объекта класса Class,
        // он возвращает тип Field. Т.е. мы передаём объекту класса Field(поле) поле id нашего класса Employee.
        //Далее мы можем узнать тип этого поля.
        Field someField = employeeClass.getField("id"); //доступ к полю по его имени
        System.out.println("Type of id field = " + someField.getType());

        System.out.println("********************");

        Field[] fields = employeeClass.getFields(); //доступ ко всем полям класса кроме private.
        for (Field field : fields){
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }

        System.out.println("********************");

        Field[] allFields = employeeClass.getDeclaredFields(); //доступ ко всем полям класса, в том числе и private.
        for (Field field : allFields){
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }

        System.out.println("------------------------------------------------");

        //b. Доступ к методам класса

        //доступ к конкретному методу
        //метод getMethod() - помимо имени метода принимает типы параметров, но из-за того, что второй параметр
        // "parameterTypes" является varArgs, мы можем этот параметр писать, а можем и не указывать. И когда мы не
        // пишем "parameterTypes", это означает что мы не задаем никакие параметры так как в методе их нет.
        // Но если у нас допустим есть перегруженный метод и в разных его модификациях разные типы параметров,
        // то кроме названия мы должны обязательно указывать и тип его параметров, например вот так
        // employeeClass.getMethod("setSalary", double.class).

        Method someMethod1 = employeeClass.getMethod("increaseSalary"); //доступ к методу класса по имени метода
        System.out.println("Return type of method increaseSalary = " + someMethod1.getReturnType()
                + ", parameter types = " + Arrays.toString(someMethod1.getParameterTypes()));

        System.out.println("********************");

        Method someMethod2 = employeeClass.getMethod("setSalary", double.class); //доступ к методу класса по имени метода
        System.out.println("Return type of method setSalary = " + someMethod2.getReturnType()
                + ", parameter types = " + Arrays.toString(someMethod2.getParameterTypes()));

        System.out.println("********************");

        //Выведем информацию обо всех методах класса Employee.
        //Метод getMethods() - вернет все методы в нашем классе, даже те которые были унаследованы от родителей, в т.ч
        // и от класса Object. Но этот метод не вернёт нам private методы.
        Method[] methods = employeeClass.getMethods();
        for(Method method : methods){
            System.out.println("Name of method = " + method.getName() + ", Return type = " + method.getReturnType()
                    + ", parameter types = " + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("********************");

        //Метод getDeclaredMethods() - вернёт информацию обо всех методах класса Employee, в том числе
        // и private методах, но без унаследованных методов родительских классов за исключением @Override методов.
        Method[] allMethods = employeeClass.getDeclaredMethods();
        for(Method method : allMethods){
            System.out.println("Name of method = " + method.getName() + ", Return type = " + method.getReturnType()
                    + ", parameter types = " + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("********************");

        //Как получить методы из моего класса, но только те access modifier которых public.
        //Этого можно добиться с помощью класса Modifier и его методов, в нашем случае isPublic() -
        // Modifier.isPublic(method.getModifiers()), но таких методов много.
        // Таких классов как Modifier так же много, это Field, Constructor.

        Method[] allMethods2 = employeeClass.getDeclaredMethods();
        for(Method method : allMethods2){
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println("Name of method = " + method.getName() + ", Return type = " + method.getReturnType()
                        + ", parameter types = " + Arrays.toString(method.getParameterTypes()));
            }
        }

        System.out.println("------------------------------------------------");

        //c. Доступ к конструкторам класса

        //Сначала получим какой-то конкретный конструктор с помощью метода getConstructor().
        //constructor1.getParameterCount() - сколько параметров имеет конструктор.
        //constructor1.getParameterTypes() - узнаем типы параметров нашего конструктора.
//        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Constructor constructor1 = employeeClass.getConstructor(); //конструктор без параметров
        System.out.println("Constructor has " + constructor1.getParameterCount() +
                " parameters, their types are: " + Arrays.toString(constructor1.getParameterTypes()));

        System.out.println("********************");

        //Посмотрим конструктор с тремя параметрами.
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("Constructor has " + constructor2.getParameterCount() +
                " parameters, their types are: " + Arrays.toString(constructor2.getParameterTypes()));

        System.out.println("********************");

        //Получим информацию о всех конструкторах.
        Constructor[] constructors = employeeClass.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println("Constructor " + constructor.getName() + " has " + constructor.getParameterCount() +
                    " parameters, their types are: " + Arrays.toString(constructor.getParameterTypes()));
        }

        System.out.println("********************");
        System.out.println("********************");


        //Так же есть метод getDeclaredConstructors() - возвращает, в том числе и private конструкторы.
        Constructor[] allConstructors = employeeClass.getDeclaredConstructors();
        for (Constructor constructor : allConstructors){
            System.out.println(String.format("Constructor " + constructor.getName() + " has " + constructor.getParameterCount() +
                    " parameters, their types are: " + Arrays.toString(constructor.getParameterTypes()) +
                    ", their Modifiers = " + constructor.getModifiers()));
        }

        System.out.println("********************");

    }
}
