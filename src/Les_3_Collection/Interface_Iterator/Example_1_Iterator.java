package Les_3_Collection.Interface_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Example_1_Iterator {
    //Iterator - это повторитель


    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Vladimir");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

        //С помощью объекта iterator, мы сможем пробежаться по объектам нашего arrayList1
        Iterator<String> iterator = arrayList1.iterator();

//        while (iterator.hasNext()){ //если iterator имеет следующий элемент
//            System.out.println(iterator.next()); //мы будем выводить на экран следующий элемент коллекции
//        }

        //С помощью объекта iterator, мы сможем удалить элементы нашей коллекции в отличие от for each loop
        while (iterator.hasNext()){
            iterator.next(); //получаем текущий элемент
            iterator.remove(); //удаляем текущий элемент с помощью метода remove()
        }
        System.out.println(arrayList1);






    }
}
