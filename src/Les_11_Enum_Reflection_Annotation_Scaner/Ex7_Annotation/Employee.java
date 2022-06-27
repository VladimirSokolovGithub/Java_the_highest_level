package Les_11_Enum_Reflection_Annotation_Scaner.Ex7_Annotation;

//Пример по созданию аннотации.
//Аннотации могут использоваться для разных целей. Для создания документации для нашего кода, для передачи определенной
// информации компилятору, для использования их во время Runtime (во время обработки нашего кода), в это время
// к аннотации можно обратиться и исследовать её с помощью рефлексии.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation2
public class Employee {

    String name;
    double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @MyAnnotation2
    public void increaseSalary(){
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

//Создание аннотации.

//Аннотация для класса

@Target(ElementType.TYPE)
@interface MyAnnotation1{

}


//Аннотация для класса и метода
//Аннотация @Target говорит нам с чем будет работать наша аннотация(Типы перечислены в enum ElementType - это Класс,
// Поле, Метод, Параметр, Конструктор, Локальная переменная и др.)

//Так же есть ещё одна аннотация, которую часто используют при создании своих аннотаций. Эта аннотация
// называется @Retention(). @Retention() описывает жизненный цикл аннотаций, т.е. до какого этапа нашей программы
// будет видна аннотация. (Жизненные циклы смотрим в презентации - это SOURCE, CLASS, RUNTIME).

// SOURCE - это такие аннотации, как @Override - видна только в source коде на этапе компиляции, отбрасывается
// компилятором и уже в byte коде не видна. Получается что нет необходимости хранить эту аннотацию в byte коде,
// и о ней нет необходимости знать runtime - во время выполнения нашей программы.

// CLASS - аннотация видна в byte коде, отбрасывается JVM во время выполнения программы. Эти аннотации сохраняются
// после компиляции source кода, т.е. они есть в байт-коде (в файле с расширением .class), но не сохраняются JVM
// во время выполнения нашей программы. Это default вариант аннотации. Т.е. если мы аннотацию @Retention не укажем,
// то RetentionPolicy.CLASS у нас будет класс.

//RUNTIME - аннотация видна во время выполнения программы. К таким аннотациям мы можем обратиться с помощью рефлексии.
//Эти аннотации передают метаданные (данные о данных), которые могут быть использованы нашим приложением, либо каким то
// framework.

//Чаще всего при создании своих аннотаций используется RetentionPolicy.RUNTIME.
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{

}