package Les_6_Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Example_1_Introduction_in_Streams_method_map {
    //Stream - это интерфейс
    //Stream - это последовательность элементов, поддерживающих последовательные и параллельные операции
    //над ними.
    //Stream позволяет упростить работу с наборами данных (упростить операции фильтрации, сортировки) и другие
    // манипуляции с данными такими как коллекции или массивы.

    //Stream - грубо говоря это поток данных, тех данных которые содержит наша коллекция или массив.
    //Самое необходимое и нужное место для использования лямбда выражений, это использование их в методах
    //нашего Stream-a.

    //Методы Stream-a позволяют нам писать быстрый и мощный код для работы с нашими коллекциями.
    //Таким образом Stream-ы позволяют писать код в функциональном стиле.

    //***//НАЧНЁМ ИЗУЧАТЬ МЕТОДЫ НАШЕГО Stream-a.

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("How are you");
        list.add("Ok");
        list.add("Goodbye");
        //Допустим я хочу поменять содержимое этого list-а и на место этих слов поставить их длину.
        //У нас list содержит String и значение длин соответственно тоже будут String.

        //вот как бы я сделал это раньше без Stream-ов.
//        for(int i = 0; i < list.size(); i++){
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
        System.out.println(list);

        //Теперь я создам Stream с помощью нашего list-a.
        //Stream можно создать и получить несколькими способами, самый распространенный, это создать его из
        //коллекции путем вызова метода stream() - list.stream().
        //Вызовем у list метод stream(), этот метод возвращает нам Stream. На выходе мы имеем поток, этот поток
        //не имеет никакого значения к многопоточности или к стримам с помощью которых мы читаем или записываем
        //что-то в файл.
        //Методы которые будут рассматриваться дальше работают не на прямую с коллекциями, например с нашим list,
        //а перед этим мы преобразовываем эти коллекции или массивы в потоки. Таким образом после list.stream() -
        // - метода stream() наш поток содержит все элементы из коллекции list (Hello, How are you, Ok, Goodbye),
        //ещё можно сказать что мы из коллекции получили Stream.

        //пример
//        list.stream()


        //1
        //метод map() - берёт поочереди каждый элемент из нашего стрима и сопоставляет ему элемент, который из
        // него получается после применения на нем тех действий, которые мы описываем, внутри метода map(),
        // с помощью лямбда выражений. Другими словами метод map() каждый элемент потока преобразует таким образом,
        //которым мы напишем в параметре метода map().

        //element - это каждый элемент нашего стрима. И в теле лямбда выражения каждому эдементу нашего стрима,
        //было сопоставлено значение его длины. И теперь на выходе метода map(), а он возвращает тоже Stream, мы
        //имеем уже другой стрим(длину наших слов). (5, 11, 2, 7)
        //Но сейчас мы не можем допустим создать новый List<Integer> list2 и присвоить ему новые значения, так
        // как это у нас поток, мы не можем присвоить Листу поток.
        //например вот так List<Integer> list2 = list.stream().map(element -> element.length());
        // Мы должны сначала этот поток преобразовать в List. Для этого используется
        // метод collect(Collectors.toList()) и в параметрах у него (Collectors.toList()).

        //2
        //метод collect(Collectors.toList())

        List<Integer> list2 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        //то есть теперь мы полученный поток преобразовали в List/
        System.out.println(list2); //[5, 11, 2, 7]

        //****//
        //ВАЖНО!!!
        //Все методы Stream не меняют саму коллекцию или массив на котором они были вызваны.
        //****//
        //т.е. как был наш изначальный list - [Hello, How are you, Ok, Goodbye], таким он и останется


        //**** Пример применения метода map() для массива***//
        int[] array = {5, 9, 3, 8, 1};
        //Как из массива получить Stream, нужно вызывать статический метод stream() класса Arrays и в параметры
        //передать ему наш массив. Далее уже у этого стрима мы можем вызвать метод map() и проделать какую либо
        //операцию над нашим массивом (например если элемент массива нацело делится на три, то мы будем делить
        //его на три. Если не делится, то ничего делать не будем).
        array = Arrays.stream(array).map(element
                -> {if(element % 3 == 0){
                    element = element/3;
                }
                return element;
        }).toArray();
        System.out.println(Arrays.toString(array));
        //Теперь после работы этого метода у нас уже поток будет (5, 3, 1. 8, 1).
        //Далее с помощью метода toArray() преобразуем наш поток в массив и присваиваем получившееся значение
        //нашему array. Теперь мы видоизменили наш array.


        //**** Пример применения метода map() для коллекции Set***//
        Set<String> set = new TreeSet<>(); //TreeSet<> by default отсортированная коллекция
        set.add("Hello");
        set.add("How are you");
        set.add("Ok");
        set.add("Goodbye");
        System.out.println(set);
        //ниже получаем поток который выглядит вот так - (5, 11, 2, 7)
        Set<Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        System.out.println(set2);
        //Так же несмотря на то, что мы этот поток получили из Set, мы можем свободно преобразовать его в List
        //и т.д.
        List<Integer> list3 = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(list3);
    }


}


