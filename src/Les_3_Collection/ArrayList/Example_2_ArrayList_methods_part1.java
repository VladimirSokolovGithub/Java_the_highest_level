package Les_3_Collection.ArrayList;

import java.util.ArrayList;

public class Example_2_ArrayList_methods_part1 {
    public static void main(String[] args) {
        //Методы ArrayList
        //1
        //add(DataType element) -> boolean
        //add(int index, DataType element) -> boolean
        //метод add добавляет элемент на последующую позицию, в конец уже добавленного

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Vladimir");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add(1,"Misha"); //добавит Мишу после Владимира, при этом остальные элементы
                                                // сдвинуться вправо
        for (String s : arrayList1) {
            System.out.print(s + " ");
        }
        System.out.println();

        //Нельзя создавать ArrayList с примитивными типами данных
//        ArrayList<int> arrayList2 = new ArrayList<>();

        //2
        //get(int index) -> DataType
        //метод get возвращает элемент с определённым индексом из ArrayList
        System.out.println(arrayList1.get(2));

        for (int i = 0; i < arrayList1.size(); i++){
            System.out.println(arrayList1.get(i));
        }

        //3
        //set(int index, DataType element) -> DataType
        //метод set вставляет элемент в ArrayList на определенный индекс, при этом он заменит существующий на этом
        //месте элемент.

        arrayList1.set(1, "Masha");
        System.out.println(arrayList1);

        //4
        //remove(Object element) -> boolean
        //remove(int index) -> DataType
        //метод remove удаляет элемент из ArrayList, оставшиеся элементы сдвигаются влево
        //Далее метод будет рассмотрен в классе Example_2_ArrayList_methods_part1_1

        arrayList1.remove(0);
        System.out.println(arrayList1);

        arrayList1.remove("Ivan");
        System.out.println(arrayList1);


    }
}
