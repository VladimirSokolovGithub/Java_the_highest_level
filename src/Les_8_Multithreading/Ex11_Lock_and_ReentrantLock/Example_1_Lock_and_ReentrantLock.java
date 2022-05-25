package Les_8_Multithreading.Ex11_Lock_and_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example_1_Lock_and_ReentrantLock {

    //Lock - интерфейс, который имплементируется классом ReentrantLock.
    //Так же как и ключевое слово synchronized, Lock нужен для достижения синхронизации между потоками

    //У интерфейса Lock есть следующие методы:
    //1. lock() - когда вызываем метод lock(), мы активируем наш lock и тогда кодом который идёт после метода
    //lock() в одно и то же время может воспользоваться только один поток. После того кака мы написали код,
    //мы должны на нашем объекте вызвать метод unlock(). Метод unlock() вызывается всегда в блоке finally,
    //для того чтобы если вдруг выбрасывается какой-то exception наш lock, наш замок открывался в любом случае.


    //2. unlock() - открывает наш замок, залоченный методом lock().

    //Если у нас будет несколько потоков и какой-то один из них вызовет один из наших методов звонка,
    //то другой поток вызвав один из этих методов увидит, что замок закрыт и замок будет закрыт до тех пор
    //пока первый поток не откроет этот замок после выполнения этого метода.

    //В этом примере можно lock заменить на synchronized блок и программа будет работать так же.
    //Цель класса ReentrantLock и synchronized блока, одинаковая. С помощью них мы добиваемся, что бы
    //только один поток работал в один момент времени, а остальные ждали его завершения.

    //Какой плюс есть в synchronized конструкции по отношению к Локу - Lock?
    //В synchronized конструкции нам не нужно заботиться, чтобы закрыть Lock, это происходит автоматически.
    //Но у Lock перед synchronized конструкциями есть тоже плюсы о которых расскажу в следующем примере.

    public static void main(String[] args) {

        Call call = new Call();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                call.mobileCall();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                call.skypeCall();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run(){
                call.whatsappCall();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Call{
    private Lock lock = new ReentrantLock(); //Создаём переменную lock типа интерфейса Lock и помещаем в неё
                                             //ссылку на объект класса ReentrantLock().

    void mobileCall(){
        lock.lock();
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    void skypeCall(){
        lock.lock();
        try {
            System.out.println("Skype call starts");
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    void whatsappCall(){
        lock.lock();
        try {
            System.out.println("Whatsapp call starts");
            Thread.sleep(7000);
            System.out.println("Whatsapp call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}