package Les_3_Collection.Queue.PriorityQueue;

import java.util.PriorityQueue;

public class Example_1_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(10);
        priorityQueue.add(8);
        //1, 4, 7, 8, 10 - натуральная сортировка у Integer.
        //Порядок добавления элементов не важен для PriorityQueue.

        System.out.println(priorityQueue);//Когда мы выводим PriorityQueue на экран у них нет сортировки
                                            // по приоритету, но при использовании ниже элементов приоритет
                                            //уже будет соблюдаться.
        System.out.println();
        System.out.println(priorityQueue.peek());

        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());


    }
}
