package Les_3_Collection.Queue.Deque_ArrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class IntroductionToDeque_ArrayDeque {
    public static void main(String[] args) {
        //Deque - это двунаправленная очередь, которая позволяет добавлять элементы как в начало очереди,
        //так и в конец очереди.
        //То же самое при операциях с элементами мы можем брать их и с начал очереди и с конца.
        //Здесь работают два правила FIFO и LIFO.

        Deque<Integer> deque = new ArrayDeque<>();
        //4 метода добавления элементов в очередь addFirst - в начало, addLast - в конец,
        // offerFirst - в начало, offerLast- в конец.
        deque.addFirst(3);
        deque.addFirst(5);
        deque.addLast(7);
        deque.offerFirst(1);
        deque.offerLast(8);

        System.out.println(deque);

        //4 метода удаляют элементы из очереди removeFirst, removeLast, pollFirst, pollLast
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        System.out.println(deque.removeFirst());
        System.out.println(deque);

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println(deque.removeLast());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque);
        System.out.println(deque.pollLast());
        System.out.println(deque);

        //4 метода get/



    }
}
