package Les_8_Multithreading.Ex23_ConcurrentHashMap;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Example_2_ConcurrentHashMap {
    public static void main(String[] args) throws InterruptedException {
        //Вместо обычного HashMap из прошлого примера мы лишь меняем эту строчку кода по созданию нашего
        // map2 на ConcurrentHashMap и наш map2 уже работает так как нужно, параллельно использую два потока.
        ConcurrentHashMap<Integer, String> map2 = new ConcurrentHashMap<>();
        map2.put(1, "Vladimir");
        map2.put(2, "Oleg");
        map2.put(3, "Sergey");
        map2.put(4, "Artem");
        map2.put(5, "Maksim");
        System.out.println(map2);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map2.keySet().iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + map2.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map2.put(6, "Elena");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map2);
    }
}
