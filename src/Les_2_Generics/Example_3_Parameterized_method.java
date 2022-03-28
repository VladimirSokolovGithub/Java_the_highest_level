package Les_2_Generics;

import java.util.ArrayList;

public class Example_3_Parameterized_method {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(10);
        al1.add(20);
        al1.add(5);
        int a = GenMethod.getSecondElement(al1); //метод возвращает второй элемент типа int
        System.out.println(a);

        ArrayList<String> al2 = new ArrayList<>();
        al2.add("abc");
        al2.add("def");
        al2.add("ghi");
        String s = GenMethod.getSecondElement(al2);
        System.out.println(s);
    }
}

class GenMethod{
    //<T> T - первое <T> в Diamond скобках говорит нам, что мы используем Generics. Второе T - это return type
    //и ArrayList<T> в параметрах говорит нам что мы можем использовать ArrayList любого типа. Но тип Т перед
    // названием метода и тип ArrayList<T> в параметре метода должны совпадать.
    public static <T> T getSecondElement(ArrayList<T> al){
        return al.get(1);
    }
}
