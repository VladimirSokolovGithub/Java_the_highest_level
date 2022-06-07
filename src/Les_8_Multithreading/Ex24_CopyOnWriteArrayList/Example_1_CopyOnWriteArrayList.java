package Les_8_Multithreading.Ex24_CopyOnWriteArrayList;

//CopyOnWriteArrayList имплементирует интерфейс List.

//CopyOnWriteArrayList следует использовать тогда, когда нам нужно добиться потокобезопасности.У нас небольшое
//количество операций по изменению элементов и большое количество по их чтению.

// CopyOnWriteArrayList - это коллекция ArrayList с алгоритмом CopyOnWrite.
// CopyOnWrite - при каждом изменении элементов данной коллекции, создаётся клон-копия list-а нового вида.

//*******
//Так же есть похожая коллекция CopyOnWriteArraySet - которая работает по схожему сценарию. Поэтому мы его
// рассматривать не будем, но нужно знать что он есть.

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example_1_CopyOnWriteArrayList {
    public static void main(String[] args) throws InterruptedException {

//        ArrayList<String> list = new ArrayList<>(); //Если использовать обычный ArrayList с несколькими потоками,
//                                                    // то мы получим ConcurrentModificationException
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Vladimir");
        list.add("Oleg");
        list.add("Sergey");
        list.add("Artem");
        list.add("Maksim");
        System.out.println(list);

        Runnable runnable1 = () -> {
            //Перед тем как наш поток начал итерироваться по нашей коллекции iterator-у передалось состояние нашей
            // коллекции на момент создания итератора. Т.е. передались те элементы, которые изначально были в него
            // добавлены. Поэтому в выводе в консоль мы и получили список этих элементов несмотря на то, что через
            // 200 миллисекунд второй поток удалил последний элемент и добавил на его место новый элемент Uliya. Наш
            // первый поток всё равно вывел элемент Maksim.
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };

        //В этом потоке когда мы изменили CopyOnWriteArrayList, на строчке 53 list.remove(4); создалась новая копия
        // нашей коллекции. Потом мы добавили элемент на строчке 54 list.add("Uliya");, создалась ещё одна новая
        // копия коллекции. И только после того как итератор закончил работу, старая копия уже никому не нужна, и
        // на строчке кода 66 System.out.println(list); наш поток main уже работает с самой новой копией.
        //При этом конечно процесс создания копий, он ресурсозатратный, потому что каждый раз при каком нибудь
        // действии над нашей коллекцией создаётся новая копия. Поэтому эту коллекцию следует использовать, тогда,
        // когда у нас немного операций по изменению коллекции и много операций чтения.
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4);
            list.add("Uliya");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }
}
