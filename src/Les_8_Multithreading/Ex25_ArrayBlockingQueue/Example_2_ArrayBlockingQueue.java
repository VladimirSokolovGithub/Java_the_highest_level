package Les_8_Multithreading.Ex25_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Example_2_ArrayBlockingQueue {
    //Пусть у нас будет очередь, которая может содержать не более 4-х элементов. Элемент будет добавляться в конец
    //и браться из начала. У нас есть производитель(Producer), в нашем примере он производит числа. И есть
    //потребитель (Consumer), он потребляет эти числа. Producer будет добавлять элементы в конец очереди, а
    //Consumer забирать и удалять элементы из начала очереди.(Здесь будет соблюдаться правила FiFO).
    //Producer будет поставлять число каждую 1 секунду. Consumer будет забирать число каждые 3 сек.

    //У ArrayBlockingQueue есть 2 метода:
    //1. put() - с помощью этого метода Producer будет добавлять элементы в очередь.
    //2. take() - с помощью этого метода Consumer будет брать элементы из очереди

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);

        //Используем здесь уже другую технику, не будем создавать Runnable, а сразу будем создавать Thread.

        //Это будет Thread производитель (Producer).
        new Thread(() -> {
            int i = 0;
            while (true){
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Producer added the number: " + i + " " + arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //Поток для Consumer.
        new Thread(() -> {
            while (true){
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer take the number: " + j + " " + arrayBlockingQueue);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
