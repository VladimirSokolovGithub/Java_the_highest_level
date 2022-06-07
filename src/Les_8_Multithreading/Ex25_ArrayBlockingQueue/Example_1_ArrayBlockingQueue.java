package Les_8_Multithreading.Ex25_ArrayBlockingQueue;


//ArrayBlockingQueue - это потокобезопасная очередь с ограниченным размером.
//ArrayBlockingQueue помимо своих методов, также имеет все методы интерфейса Queue.

//Когда мы рассматривали очередь, то
//добавлять элемент в очередь мы могли с помощью методов add() и offer(). add() - выбрасывает Exception если
//очередь уже полная и некуда добавить элемент, а offer() Exception не выбрасывал. Но мы тогда не рассматривали
// очереди, которые имеют конкретный размер.

//При создании ArrayBlockingQueue мы обязательно должны указать что у неё есть какой-то размер.

//Обычно один или несколько потоков добавляют элементы в конец очереди, а другой или другие потоки, забирают
//элементы из начала очереди.

import java.util.concurrent.ArrayBlockingQueue;

public class Example_1_ArrayBlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4); //Эта очередь может содержать только 4 эл.
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
//        queue.add(5); //Пытаемся добавить пятый элемент в очередь из 4-х эл., то выброситься
                    // IllegalStateException: Queue full
//        queue.offer(5); //Если же мы попробуем добавить пятый элемент с помощью метода offer(5), то Exception
                            //выброшен не будет, просто пятый элемент не добавится.
        System.out.println(queue);
    }
}
