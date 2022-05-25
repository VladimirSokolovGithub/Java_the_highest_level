package Les_8_Multithreading.Ex9_Methods_wait_and_notify;

public class Example_2_wait_notify {

    public static void main(String[] args) {
        Market2 market2 = new Market2();
        Producer2 producer2 = new Producer2(market2);
        Consumer2 consumer2 = new Consumer2(market2);

        Thread thread1 = new Thread(producer2);
        Thread thread2 = new Thread(consumer2);

        thread1.start();
        thread2.start();
    }


}

class Market2{
    private int breadCount = 0; //количество булок хлеба

    //Нужно понимать на мониторе какого объекта мы делаем синхронизацию, на том же самом объекте нужно вызывать и
    //wait и notify.

    //И Важное замечание, что wait освобождает монитор, а notify не освобождает монитор.
    private final Object lock = new Object();

    //метод покупки хлеба потребителем
    public void getBread(){
        synchronized(lock) {
            while (breadCount < 1) {
                try {
                    lock.wait(); //Если хлеба нет, нужно ждать
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        breadCount--; //берем 1 булку хлеба
        System.out.println("Потребитель купил 1 булку хлеба");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        lock.notify(); //После того как мы взяли хлеб мы должны сообщить производителю, что он может добавить хлеб на витрину
    }

    //Метод добавления хлеба на витрину производителем
    public void putBread(){
        synchronized(lock) {
            while (breadCount >= 5) {
                try {
                    lock.wait(); //Если хлеб на витрине в количестве 5, то ждём
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        breadCount++; //Если хлеба меньше чем 5, то добавляем 1 хлеб
        System.out.println("Производитель добавил на витрину 1 булку хлеба");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        lock.notify(); //Извещаем потребителя, что хлеб добавлен и его можно покупать
    }
}

//Создадим потоки производителя - Producer и потребителя - Consumer или Customer
class Producer2 implements Runnable {
    Market2 market2;
    Producer2(Market2 market){
        this.market2 = market2;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            market2.putBread();
        }
    }
}

class Consumer2 implements Runnable {
    Market2 market2;
    Consumer2(Market2 market){
        this.market2 = market2;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            market2.getBread();
        }
    }
}

