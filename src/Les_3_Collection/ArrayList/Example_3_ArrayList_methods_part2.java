package Les_3_Collection.ArrayList;

import java.util.ArrayList;

public class Example_3_ArrayList_methods_part2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Vladimir");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("!!!");
        arrayList2.add("???");

        //5
        //addAll(ArrayList al) -> boolean
        //addAll(int index, ArrayList al) -> boolean
        //метод добавляет элементы другого ArrayList, который передаётся в параметр метода
        //если в параметры передаётся один ArrayList, то его элементы будут добавлены в конец нашего ArrayList
        //если в параметры так же передаётся индекс, то элементы будут добавлены в наш ArrayList, начиная с
        //определенной позиции

        arrayList1.addAll(arrayList2);
        System.out.println(arrayList1);

        arrayList1.addAll(1, arrayList2);
        System.out.println(arrayList1);

        //6
        //clear() -> void
        //метод очищает наш ArrayList

        arrayList1.clear();
        System.out.println(arrayList1);

        //7
        //indexOf(Object element) -> int
        //метод принимает в параметрах объект ArrayList и возвращает его позицию (индекс) или -1, если
        //такой объект в нашем ArrayList не найден
        //Так как ArrayList позволяет хранить одинаковые объекты то будет выводиться индекс первого
        //вхождения объекта в списке
        //Далее метод будет рассмотрен в классе Example_2_ArrayList_methods_part2_1

        System.out.println(arrayList2.indexOf("???"));

        arrayList1.add("Vladimir");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Ivan");

        System.out.println(arrayList1.indexOf("Ivan"));

        //8
        //LastIndexOf(Object element) -> int
        //метод принимает в параметрах объект ArrayList и возвращает его позицию (индекс) или -1, если
        //такой объект в нашем ArrayList не найден
        //Так как ArrayList позволяет хранить одинаковые объекты то будет выводиться индекс последнего
        //вхождения объекта в списке

        System.out.println(arrayList1.lastIndexOf("Ivan"));

        //9
        //size() -> int
        //метод возвращает размер массива
        System.out.println(arrayList1.size());

        //10
        //isEmpty() -> boolean
        //метод возвращает true если наш ArrayList пуст и false если не пуст
        System.out.println(arrayList1.isEmpty());

        //11
        //contains(Object element) -> boolean
        //метод проверяет содержит ли ArrayList какой-либо объект и возвращает true
        //если наш ArrayList содержит этот объект и false если нет.
        System.out.println(arrayList1.contains("Mariya"));

        //12
        //toString() -> String
        //метод преобразует ArrayList в удобно читаемую форму в виде Строки, которую можно вывести на экран
        //в методе System.out.println(arrayList1.toString()); можно писать toString(), а можно и не писать
        //он сработает автоматически
        System.out.println(arrayList1.toString());




    }
}
