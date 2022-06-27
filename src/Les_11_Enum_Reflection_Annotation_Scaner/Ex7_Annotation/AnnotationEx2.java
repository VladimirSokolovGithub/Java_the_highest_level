package Les_11_Enum_Reflection_Annotation_Scaner.Ex7_Annotation;

import java.lang.annotation.*;

public class AnnotationEx2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //Теперь прочитаем информацию об аннотации Xiaomi и Iphone с помощью рефлексии.
        //Применил два способа создания объекта типа Class.
        Class XiaomiClass = Class.forName("Les_11_Enum_Reflection_Annotation_Scaner.Ex7_Annotation.Xiaomi");
        Annotation annotation1 = XiaomiClass.getAnnotation(SmartPhone.class);
        //сразу код выше но с кастингом к аннотации SmartPhone
//        SmartPhone annotation2 = (SmartPhone) XiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1; //сделаем кастинг полученной аннотации к аннотации SmartPhone.
        System.out.println("Annotation info from Xiaomi class: " + sm1.OS() + ", " + sm1.yearOfCompanyCreation());


        Class IphoneClass = Iphone.class;
        SmartPhone annotation2 = (SmartPhone) IphoneClass.getAnnotation(SmartPhone.class);
        System.out.println("Annotation info from Iphone class: " + annotation2.OS()
                + ", " + annotation2.yearOfCompanyCreation());

    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    //Создадим внутри аннотации, элементы аннотации.
    //Если мы создаём элементы, то мы обязаны их указывать при использовании аннотации
    //Так же мы можем прописывать, а можем и не прописывать default значения для наших элементов.
    //Используя default значения элементов, мы можем не указывать их в момент использования аннотации( как в
    // примере с классом Xiaomi).
    //При создании элементов аннотаций, мы можем использовать примитивные типы данных, например int, можем
    // использовать массивы, но мы не можем использовать ссылочные Типы данных, например StringBuilder sb(); (
    // класс String является исключением).

    //без default значений
//    String OS();
//    int yearOfCompanyCreation();

    //с default значениями
    String OS() default "Android";
    int yearOfCompanyCreation() default 2010;
}

@SmartPhone()
class Xiaomi{
    String model;
    double price;
}

//здесь указанные в скобках значения элементов аннотации, перезаписывают default значения.
@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class Iphone{
    String model;
    double price;
}

