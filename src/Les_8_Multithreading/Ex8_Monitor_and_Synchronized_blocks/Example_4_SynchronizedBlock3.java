package Les_8_Multithreading.Ex8_Monitor_and_Synchronized_blocks;

public class Example_4_SynchronizedBlock3 {
    //Так же мы можем синхронизировать работу нескольких методов.
    //Например, используем следующую задачу:
    //Нам могут звонить на мобильный телефон используя мобильную связь, используя skype, и с помощью whats app.
    //Договоримся что у нас будут три разных потока ответственные за звонки с разных каналов.
    //И если мы уже разговариваем используя любой из этих каналов и если нам в это время приходит звонок с
    //другого канала, то этот звонок будет ждать до тех пор, пока не закончиться текущий.

//    static final Car car = new Car(); //Так не стоит делать
    static final Object lock = new Object();

    //Здесь мы просто создали класс Car, он пустой и сделали синхронизацию на мониторе объекта car класса Car.
    //Но так делать не стоит, не нужно выдумывать какой-то клас.
    //Обычно пишут создавая объект lock класса Object
    void mobileCall()   {
//        synchronized(car) {
        synchronized(lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }

    void skypeCall()  {
//        synchronized(car) {
        synchronized(lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }

    void whatsappCall()  {
//        synchronized(car) {
        synchronized(lock) {
            System.out.println("WhatsApp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WhatsApp call ends");
        }
    }

    //Вот так работать не будет, так как синхронизация идёт по this, в все объекты this разные

//    synchronized void mobileCall()   {
//        System.out.println(this);
//        System.out.println("Mobile call starts");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Mobile call ends");
//    }
//
//    synchronized void skypeCall()  {
//        System.out.println(this);
//        System.out.println("Skype call starts");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Skype call ends");
//    }
//
//    synchronized void whatsappCall()  {
//        System.out.println(this);
//        System.out.println("WhatsApp call starts");
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("WhatsApp call ends");
//    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplWhatsApp());

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class RunnableImplMobile implements Runnable{
    @Override
    public void run() {
        new Example_4_SynchronizedBlock3().mobileCall();
    }
}

class RunnableImplSkype implements Runnable{
    @Override
    public void run() {
        new Example_4_SynchronizedBlock3().skypeCall();
    }
}

class RunnableImplWhatsApp implements Runnable{
    @Override
    public void run() {
        new Example_4_SynchronizedBlock3().whatsappCall();
    }
}

//class Car{ //Так не стоит делать
//
//}
