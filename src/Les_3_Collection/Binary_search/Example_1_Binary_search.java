package Les_3_Collection.Binary_search;

import java.util.ArrayList;
import java.util.Collections;

public class Example_1_Binary_search {
    //Рассмотрим несколько методов класса Collections
    //У класса Collections много методов, но Collections.binarySearch(arrayList, 12); нужно знать обязательно
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-3);
        arrayList.add(8);
        arrayList.add(12);
        arrayList.add(-8);
        arrayList.add(0);
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(150);
        arrayList.add(-30);
        arrayList.add(19);
        int index1 = Collections.binarySearch(arrayList, 12); //в параметры вставляем наш arrayList и
                                                                    //искомый элемент
        System.out.println(index1); //искомый элемент будет не найден так как список не отсортирован
                                    //выведется отрицательное число

        Collections.sort(arrayList);
        int index2 = Collections.binarySearch(arrayList, 12);
        System.out.println(index2); //на 8-й позиции после сортировки будет найден наш элемент "12"

        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        Collections.shuffle(arrayList);
        System.out.println(arrayList);


    }
}
