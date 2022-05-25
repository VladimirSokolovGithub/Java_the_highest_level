package Les_8_Multithreading.Ex9_Methods_wait_and_notify;

public class Example_1_wait_notify {
    //Иногда при взаимодействии потоков встаёт вопрос об извещении одних потоков о действии других.
    //Например, действия одного потока могут зависеть от результата действий другого потока. И нужно
    //как-то известить один поток, что другой поток произвёл эту работу. И для подобных ситуаций у класса
    //Object определено ряд методов:

    //wait() - освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока
    //другой поток не вызовет метод notify() или notifyAll();

    //notify() - НЕ освобождает монитор и будит поток, у которого ранее был вызван метод wait();

    //notifyAll() - НЕ освобождает монитор и будит все потоки у которых ранее был вызван метод wait();

    //Важно запомнить, что все эти методы wait(), notify(), notifyAll(), вызываются из синхронизированного
    //контекста (синхронизированного метода или синхронизированного блока). Данные методы вызываются на объекте,
    //который используется для создания lock-a в наших synchronized методах или блоках.

    //wait() может принимать в параметр миллисекунды. Это означает что столько будет ждать тот поток который,
    //поставлен на ожидание максимум по времени, и по истечении этого времени этот поток снова станет активным и
    //не важно был ли вызван метод notify().

    //Так же рекомендовано использовать wait() именно в while loop-e так как это рекомендовано Java dock.
    //Это делается для того что иногда поток может проснуться без видимых причин и условие будет перепроверено
    //ещё раз. Если бы мы использовали if loop, то тогда это условие не было бы перепроверено и поток стал бы бодрствовать.

    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }


}

class Market{
    private int breadCount = 0; //количество булок хлеба

    private final Object lock = new Object();

    //метод покупки хлеба потребителем
    public synchronized void getBread(){
        while (breadCount < 1){
            try {
                wait(); //Если хлеба нет, нужно ждать
//                this.wait(); //Это то же самое что и строчкой выше
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--; //берем 1 булку хлеба
        System.out.println("Потребитель купил 1 булку хлеба");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        notify(); //После того как мы взяли хлеб мы должны сообщить производителю, что он может добавить хлеб на витрину
//        this.notify(); //Это то же самое что и строчкой выше
    }

    //Метод добавления хлеба на витрину производителем
    public synchronized void putBread(){
        while (breadCount >= 5){
            try {
                wait(); //Если хлеб на витрине в количестве 5, то ждём
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++; //Если хлеба меньше чем 5, то добавляем 1 хлеб
        System.out.println("Производитель добавил на витрину 1 булку хлеба");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        notify(); //Извещаем потребителя, что хлеб добавлен и его можно покупать
    }
}

//Создадим потоки производителя - Producer и потребителя - Consumer или Customer
class Producer implements Runnable {
    Market market;
    Producer(Market market){
        this.market = market;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;
    Consumer(Market market){
        this.market = market;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            market.getBread();
        }
    }
}