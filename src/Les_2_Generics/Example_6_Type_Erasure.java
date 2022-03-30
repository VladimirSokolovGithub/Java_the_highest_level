package Les_2_Generics;

import java.util.ArrayList;

public class Example_6_Type_Erasure {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(5);

        //Информацию о Generics знает только компилятор для необходимых ему проверок, runtime эта информация
        // стирается и называется это - Type Erasure (Стирание типа)

        //Для JVM написание следующее:
//        ArrayList list = new ArrayList(); //т.е JVM воспринимает ArrayList как список raw types - сырых типов

        //Когда мы пишем
        int i = list.get(0);
        // JVM видит его в следующем виде
        // происходит кастинг так как без кастинга вот это выражение list.get(0) возвращает Object
        // поэтому Object сначала каститься до Integer, а затем назначается переменной i
        // это и называется стиранием Generics - Type Erasure, это механизм поддержания обратной совместимости кода
        // int i = (Integer)list.get(0);

    }

    //Здесь вроде бы эти два метода должны были бы работать нормально, но вместе они не работают потому, что
    // в JVM информация о Generics стирается и они выгладят вот так  - abc(Info6 info6)
    // поэтому мы не можем создавать вот такие Overloaded (перезаписанные) методы

//    public void abc(Info6<String> info6){
//        String s  = info6.getValue();
//    }
//
//    public void abc(Info6<Integer> info6){
//        Integer i  = info6.getValue();
//    }
}

class Info6 <T> {
    private T value;
    public Info6(T value){
        this.value = value;
    }

    public String toString(){
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}

//Теперь рассмотрим пример для method Overriding (переопределения методов)
// Здесь мы так же не сможем сделать @Override так как при катинге в классе наследнике(сабклассе) будут
// возникать проблемы

class Parent{
    public void abc(Info6<String> info6) {
        String s = info6.getValue();
    }
}

class Child extends Parent{
//    @Override
//    public void abc(Info6<Integer> info6) {
//        Integer i = info6.getValue();
//    }
}