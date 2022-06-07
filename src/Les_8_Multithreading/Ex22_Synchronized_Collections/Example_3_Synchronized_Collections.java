package Les_8_Multithreading.Ex22_Synchronized_Collections;

import java.util.*;

public class Example_3_Synchronized_Collections {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 1000; i++){
            arrayList.add(i);
        }

        List<Integer> synchList = Collections.synchronizedList(arrayList);

        //Для перебора элементов в коллекции мы можем использовать итераторы.
        //Однако итераторы подвержены сбоям в многопоточном приложении.
        //Так например если один поток изменяет содержимое коллекции, а второй поток обрабатывает его итератором,
        // то при вызове метода iterator.hasNext() или iterator.next() будет выброшено исключение
        // ConcurrentModificationException. Что бы обезопасить приложение от вызова исключения, необходимо
        // целиком блокировать List на время перебора. Это означает то, что когда мы используем метод
        // synchList.remove(10), ставится lock и в этот момент никакой другой thread не может изменять наш
        // ArrayList. Но когда мы просто делаем итерацию по нашему ArrayList-у, то никакого lock-а не ставится.
        //Мы должны этот lock прописать вручную, чтобы всё нормально работало и ConcurrentModificationException не
        // выбрасывался. Это достигается с помощью блока - synchronized (synchList){}. Это будет означать, что
        // пока идёт перебор нашего ArrayList и вывод на экран наших элементов, до тех пор пока этот перебор и
        // вывод не закончится, метод synchList.remove(10) второго потока не будет вызван. Поток runnable2 будет
        // ждать выполнения потока runnable1.


        Runnable runnable1 = () -> {Iterator<Integer> iterator = synchList.iterator();
            synchronized (synchList) {
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        Runnable runnable2 = () -> synchList.remove(10);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(synchList);
    }
}

//В нашем примере так же в зависимости от того какой поток первым обработается, мы можем увидеть в output-е
//два случая. Первый случай когда сначала выполнится второй поток и 10-й элемент будет удалён. И второй случай,
//когда сначала все элементы будут выведены на экран и лишь потом 10-й элемент будет удалён.

//00-16