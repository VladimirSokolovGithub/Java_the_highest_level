package Les_8_Multithreading.Ex21_AtomicInteger_class;

//
public class Example_1_AtomicIntegerClass {
    static int counter = 0;

    //Если мы не синхронизировали метод increment(), то у нас не всегда будет выводиться в консоль число 200.
//    public static void increment(){
//        counter++;
//    }

    //поэтому мы писали так:
    public synchronized static void increment(){
        counter++;
    }

    //На самом деле synchronized очень тяжелая штука, каждый раз идёт блокировка монитора, потом его
    //разблокировка и т.д. А делаем мы это потому что увеличение на один операция не атомарная, так как
    //это три операции - сначала значение считывается из памяти, потом увеличивается на один, потом записывается
    //в память.
    //Поэтому java для таких случаев предлагает пользоваться классом AtomicInteger, в нём все операции которые нам
    //нужны происходят атомарно.

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl18());
        Thread thread2 = new Thread(new MyRunnableImpl18());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class MyRunnableImpl18 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            Example_1_AtomicIntegerClass.increment();
        }
    }
}