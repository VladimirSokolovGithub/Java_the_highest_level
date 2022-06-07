package Les_8_Multithreading.Ex22_Synchronized_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example_2_Synchronized_Collections {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            source.add(i);
        }


        //synchList - это синхронизированная обёртка для вновь созданного ArrayList или ещё говорят
        // synchronized view.
        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> {synchList.addAll(source);};

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
        System.out.println(synchList);


    }
}

