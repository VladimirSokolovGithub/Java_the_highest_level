package Les_8_Multithreading.Ex21_AtomicInteger_class;

import java.util.concurrent.atomic.AtomicInteger;


//AtomicInteger - это класс, который предоставляет возможность работать с целочисленными значениями int,
//используя атомарные операции.
//Кроме AtomicInteger есть ещё и другие классы AtomicBoolean, AtomicLong, AtomicIntegerArray и все они работают по
//похожему принципу.

//методы AtomicInteger - являются атомарными.

//incrementAndGet() - увеличь и дай.

//getAndIncrement() - дай и увеличь.

//addAbdGet() - прибавь число переданное в параметре и верни.

//getAndAdd() - возвращает старое значение и потом добавляет.

//decrementAndGet() - уменьшает на 1 и возвращает.

//getAndDecrement() - верни старое значение и потом уменьши на 1.

public class Example_2_AtomicInteger {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void increment(){
//        counter.incrementAndGet();
//        counter.addAndGet(5);
        counter.addAndGet(-5);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl19());
        Thread thread2 = new Thread(new MyRunnableImpl19());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class MyRunnableImpl19 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            Example_2_AtomicInteger.increment();
        }
    }
}