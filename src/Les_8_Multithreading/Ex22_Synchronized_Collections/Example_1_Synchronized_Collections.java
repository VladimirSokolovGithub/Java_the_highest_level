package Les_8_Multithreading.Ex22_Synchronized_Collections;


//Почти все рассмотренные ранее коллекции были not synchronized - не ThreadSafe (не потокобезопасны).
//Исключениями были устаревшие Vector, Stack и HashTable.
//Если нужно использовать коллекции не в многопоточном коде, тогда мы будем использовать обычные коллекции, они
//работают быстрее.

//Коллекции для работы с многопоточностью.

//Когда нам нужна коллекция с которой будут работать больше одного потока, мы можем выбирать между двумя вариантами:
//1. Это Synchronized Collections - получаются из традиционных коллекций благодаря их обёртыванию.
//2. Это Concurrent Collections - изначально созданы для работы с многопоточностью.

//На этом уроке рассмотрим первый вариант -  Synchronized Collections.
//Класс Collections (Collections.synchronizedXYZ(коллекция)) - предоставляет для работы с многопоточностью
//wrapper-ы - обёртки. Эти обёртки будут оборачивать уже известные нам коллекции, такие как - ArrayList, HashMap,
//и др.
//Это происходит с помощью следующих методов Collections.synchronizedXYZ(коллекция) - вместо XYZ будет
//подставляться SynchronizedList, SynchronizedMap, SynchronizedSet и т.д.

import java.util.ArrayList;

public class Example_1_Synchronized_Collections {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            source.add(i);
        }

        ArrayList<Integer> target = new ArrayList<>();

        Runnable runnable = () -> {target.addAll(source);};

        //Мы хотим двумя разными потоками выполнять одно действие - Runnable runnable = () -> {target.addAll(source)};
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        //При этом у нас всегда будет выводиться разный результат так как, мы добавляем элементы в ArrayList
        //используя несколько потоков наш результат невозможно предугадать. Поэтому нам нужно синхронизировать
        //наш ArrayList, сделаем это в след примере
        System.out.println(target);

        //07:45

    }
}
