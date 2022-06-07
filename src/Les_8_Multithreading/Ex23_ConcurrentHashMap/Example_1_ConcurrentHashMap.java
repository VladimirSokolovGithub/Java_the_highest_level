package Les_8_Multithreading.Ex23_ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;

//ConcurrentHashMap имплементирует интерфейс ConcurrentMap, который в свою очередь происходит от интерфейса Map.

//В ConcurrentHashMap любое количество потоков могут читать информацию без каких либо lock-ов. Так же
// ConcurrentHashMap делит множество элементов, которые он хранит на сегменты.

public class Example_1_ConcurrentHashMap {
    public static void main(String[] args) throws InterruptedException {

        //Так как в этом примере с двумя потоками у нас обычный HashMap, а мы пытаемся одним потоком итерироваться
        //по нашему HashMap и выводить элементы, а вторым добавляем новый элемент в коллекцию и всё это
        //происходит одновременно, то выбрасывается ConcurrentModificationException.
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Vladimir");
        map.put(2, "Oleg");
        map.put(3, "Sergey");
        map.put(4, "Artem");
        map.put(5, "Maksim");
        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Elena");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
