package Les_3_Collection.Queue.QueueAndLinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class Example_2_LinkedListAndQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        //Метод add()
        queue.add("Vladimir"); //метод add() добавляет элемент в конец очереди
        queue.add("Oleg");
        queue.add("Ivan");
        queue.add("Mariya");
        queue.add("Aleksandr");

        System.out.println(queue);

        //Метод offer()
        //Есть два метода add()  and offer() - для добавления элементов в очередь. Если у нас очередь ограниченная,
        //допустим 4-ми элементами, то при добавлении с помощью метода add() 5-го элемента выбросится исключение.
        //Но если бы мы в эту ограниченную очередь добавляли 5-й элемент с помощью метода offer(), то Exception
        //бы не выбрасывался, но элемент просто не добавился бы в очередь
        //Эти два метода будут рассмотрены в многопоточности.

        //Метод remove()
//        System.out.println(queue.remove()); //метод remove() удаляет элемент и возвращает его
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove()); //Если с помощью метода remove() удаляется несуществующий элемент,
                                            //т.е. очередь пуста, то выбрасывается Exception
        System.out.println(queue);

        //Метода poll()
        //Если же мы удаляем элемент с помощью метода poll(), то Exception не выбросится и вернется null/
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

        System.out.println(queue);

        //Метод element()
        //Метод element() показывает верхний элемент в очереди/
        //Если очередь пуста, то выбрасывается Exception

//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());


        //Метод peek() - так же показывает верхний(первый) элемент в очереди, но Exception не выбрасывается, а
        //возвращается null
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());

        //Так же мы можем удалить элемент из середины очереди указав в параметре сам объект
        //Но если часто так удалять элементы из середины, тогда теряется смысл использовать эту коллекцию Queue
        queue.remove("Ivan");
        System.out.println(queue);
    }
}
