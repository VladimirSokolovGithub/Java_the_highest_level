package Les_3_Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Example_1_ArrayList {
    public static void main(String[] args) {
        //Варианты создания ArrayList
        //1
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Vladimir");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        System.out.println(arrayList1);

        //2
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Vladimir");
        arrayList2.add("Ivan");
        arrayList2.add("Mariya");
        System.out.println(arrayList2);

        //При создании ArrayList, за кулисами (background), создается массив Object вместимостью (capacity) = 10 мест
        //на данный момент, пока в ArrayList не добавлено ни одного элемента, его размер(размер ArrayList) равен 0 (ноль).
        //При добавлении в массив 11-го элемента, будет создан новый массив согласно формуле "(oldCapacity * 3) / 2 + 1"
        //в нашем случае из 16 элементов,
        //в него будет скопирован старый массив из 10-ти элементов и добавлен новый 11-й элемент + останутся места (5мест)
        //capacity для последующих элементов. И так будет происходить всё время если будет заканчиваться место.

        //Но если мы заранее знаем что наш ArrayList будет содержать определенное количество мест, например 100,
        //мы сразу можем задать его capacity при создании

        //3
        ArrayList<String> arrayList3 = new ArrayList<>(200);
        arrayList3.add("Vladimir");
        arrayList3.add("Ivan");

        //4
        List<String> arrayList4 = new ArrayList<>();

        //5
        //Если необходимо создать ArrayList такой же, как уже существующий, то в параметр ArrayList передаётся
        //объект(переменная), которая ссылается на существующий ArrayList, но при этом создаётся новый объект,
        //но с таким же содержанием
        ArrayList<String> arrayList5 = new ArrayList<>(arrayList1);
        System.out.println(arrayList5);


    }
}

