package Les_3_Collection.Set_Interface.HashSet;

import java.util.HashSet;

public class Example_1_HashSet {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(1);
        hashSet1.add(8);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(4);
        hashSet2.add(3);
        hashSet2.add(5);
        hashSet2.add(8);

        //Set это множество, а в математике есть операции которые можно проделывать над множествами

        //1
        //Объединение множества (union), дубликаты не входят, не помещаются в объединенную коллекцию
        //метод addAll()

        HashSet<Integer> union = new HashSet<>(hashSet1); //здесь union принял в параметры hashSet1, поэтому он
                                                            //стал таким же как и hashSet1
        union.addAll(hashSet2);
        System.out.println(union);

        //2
        //операция intersect - пересечение. Пересечением первого и второго множества являются общие элементы(3,5,8)
        //метод retainAll()

        HashSet<Integer> intersect = new HashSet<>(hashSet1);
        intersect.retainAll(hashSet2);
        System.out.println(intersect);

        //3
        //операция subtract (разность) - если от первого множества убрать второе, то останутся элементы(2,1)
        //то есть удалить из hashSet1 все элементы hashSet2
        //метод removeAll()

        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        subtract.removeAll(hashSet2);
        System.out.println(subtract);



    }
}
