package Les_3_Collection.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example_4_ArrayList_methods_and_related {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");

        //1
        //Arrays.asList(Data type[]) -> List<Data type>
        //Метод принимает в параметрах массив определенного типа и на выходе возвращает List этого же типа

        StringBuilder[] array = {sb1, sb2, sb3, sb4};
        List<StringBuilder> list = Arrays.asList(array);
        System.out.println(list);
        //Длина этого нового объекта list уже измениться не может она будет такой же, как и у массива array
        //Если мы заменим элемент в массиве, то тоже самое отразится в объекте list
        array[0].append("!!!");
        System.out.println(list);

        array[0] = new StringBuilder("F");
        System.out.println(list);

        //2
        //removeAll(Collection<?> c) -> boolean
        //Метод удаляет все элементы в текущем ArrayList у которого вызывается метод,
        //которые он берет из ArrayList который передан в параметре

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Vladimir");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Ivan");
        arrayList2.add("Mariya");
        arrayList2.add("Igor");

//        arrayList1.removeAll(arrayList2);
//        System.out.println(arrayList1);

        //3
        //retainAll(Collection<?> c) -> boolean
        //Метод оставит в нашем ArrayList у которого вызывается метод, те элементы, которые есть в
        //ArrayList из параметра

//        arrayList1.retainAll(arrayList2);
//        System.out.println(arrayList1);

        //4
        //containsAll(Collection<?> c) -> boolean
        //Метод проверяет содержит ли наш ArrayList все элементы из ArrayList из параметра

        boolean result = arrayList1.containsAll(arrayList2);
        System.out.println(result);

        //5
        //subList(int fromIndex, int toIndex) -> List<E>
        //Метод создаёт из имеющегося ArrayList-а саблист(его какую-то часть(отрывок)) и возвращает List
        //с начального индекса включительно и до конечного индекса не включительно

//        List<String> myList = arrayList1.subList(1,4);
//        System.out.println(myList);
        //Примечание: созданный саблист myList, не существует в отдельности от arrayList1, он лишь
        //является его представлением. Т.е. мы говорим что мы хотим увидеть элементы с 1-го по третий
        //с помощью представления myList.
        //Если мы добавим в myList новый элемент он так же добавиться и в arrayList1, причем на позицию,
        //которую он занимает в myList
//        myList.add("Fedor");
//        System.out.println(myList);
//        System.out.println(arrayList1);

//        arrayList1.add("Sveta");
//        System.out.println(arrayList1);
//        System.out.println(myList); //здесь будет ConcurrentModificationException так как мы провели
        //структурную модификацию над самим arrayList1 и потом пытаемся как то использовать наше
        //представление myList, так делать нельзя

        //6
        //toArray() -> Object[]
        //toArray(T[] a) -> T[]
        //С помощью этого метода мы из нашего ArrayList получаем массив типа Object или же того типа,
        // который укажем в методе

        Object[] array1 = arrayList1.toArray();
        //Если мы хотим получить массив String, а не Object, что логично используем следующий метод
        String[] array2 = arrayList1.toArray(new String[5]); //если указать большее количество элементов,
        // то остальные будут заполнены null, если поставить например 2, то java всё равно добавит 5
        //наших элементов, поэтому чаще всего там пишут [0] ноль - arrayList1.toArray(new String[0]);
        System.out.println(array2);
        for (String s : array2){
            System.out.println(s);
        }

        //7
        //List.of(E...elements) -> List<E>
        //List.copyOf(Collection<E> c) -> List<E>
        //Эти методы вышли после java 8
        //Оба метода возвращают List, который содержит элементы определенного типа, и эти "Листы"
        //не изменяемы и не могут содержать значение null

        List<Integer> list1 = List.of(3, 8, 13); //создаём List, который будет содержать элементы 3, 8, 13
        System.out.println(list1);
        //Изменить это list1 уже нельзя
//        list1.add(100); // выйдет исключение UnsupportedOperationException

        //Второй метод List.copyOf(Collection<E> c) -> List<E> принимает в параметрах коллекцию и
        //возвращает unmodified List

        List<String> list2 = List.copyOf(arrayList1);
        System.out.println(list2);

    }
}
