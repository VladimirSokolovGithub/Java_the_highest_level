package Les_2_Generics;

import java.util.ArrayList;
import java.util.List;

public class Example_5_Subtyping_in_Generics {
    public static void main(String[] args) {
//        X x = new Y();
//        List<X> list1 = new ArrayList<X>(); // в ArrayList<>() -  X можно не указывать, но Y - мы уже поставить
        // в ArrayList<Y>() не сможем это будет неправильно

//        List<Number> list = new ArrayList<Integer>(); //Так писать нельзя
//        list.add(18);
//        list.add(3.14);


        Info2<Integer> info = new Info2<>(18);
        System.out.println(info);
        Integer i1 = info.getValue();

        Info2<Double> info2 = new Info2<>(18.1);
        System.out.println(info2);
        Double d1 = info2.getValue();

    }
}

class X {

}

class Y extends X {

}

interface I1 {

}

interface I2 {

}

//В этом случае после Type Erasure нет смысла писать вместо "Т" Object и поэтому вместо "Т" подставляется
//самый верхний клас в нашем случае Number и он уже будет удовлетворять всем условиям так как здесь вместо "Т"
// могут быть подставлены только он сам или его наследники

class Info2<T extends Number> { //Так я могу ограничивать классы, которые будут подходить под тип - "T", т.е.
    // здесь вместо типа "T" я могу использовать только класс Number и его наследников
    private T value;

    public Info2(T value) {
        this.value = value;
    }

    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}


//Когда у нас класс написан только с типом "Т" - без extends X и без super Y
//После Type Erasure
// для JVM информация о Generics стирается, JVM не знает о Дженериках, вместо "T" - подставляется Object
class Info3<T> {
    private T value;

    public Info3(T value) {
        this.value = value;
    }

    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}

//Для параметризованных методов такие ограничивающие условия <T extends Number>, в нашем случае говорят
// что метод может работать только с числами и указываются они в diamond скобках перед названием метода,
// но ни как не в параметрах метода.
class GenMethod2 {
    public static <T extends Number> T getSecondElement(ArrayList<T> al) {
        return al.get(1);
    }
}

//Здесь мы пишем что вместо "T" мы можем подставлять только те классы(наследники) которые extends Number и
// implements интерфейсы I1 и I2
class Info4<T extends Number & I1 & I2> {
    private T value;

    public Info4(T value) {
        this.value = value;
    }

    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}