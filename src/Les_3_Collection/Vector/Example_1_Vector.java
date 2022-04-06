package Les_3_Collection.Vector;

import java.util.Vector;

public class Example_1_Vector {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Vladimir");
        vector.add("Misha");
        vector.add("Oleg");
        vector.add("Katya");
        System.out.println(vector);
        System.out.println(vector.firstElement()); //метод firstElement() возвращает первый элемент коллекции Vector
        System.out.println(vector.lastElement()); //метод firstElement() возвращает последний элемент коллекции Vector
        vector.remove(2);
        System.out.println(vector);
        System.out.println(vector.get(1));



    }
}
