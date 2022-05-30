package Les_8_Multithreading.Les12_DaemonThreads;

public class Example_1_DaemonThreads {
    //Все потоки которые создавали ранее, назывались User Threads.

    //Daemon потоки предназначены для выполнения фоновых задач и оказания различных сервисов User потокам.

    //При завершении работы последнего User потока, программа завершает своё выполнение
    //не дожидаясь окончания работы Daemon потоков.

    //Объявить поток Демоном очень просто. После создания потока, нужно обязательно перед запуском потока,
    // вызвать его метод setDaemon() и передать в качестве параметра значение true.

    //Проверить является - ли поток Демоном можно вызвав его метод isDaemon().

    public static void main(String[] args) {
        System.out.println("Main thread starts");

        UserThread userThread = new UserThread();
        userThread.setName("user_thread");

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("daemon_thread");
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        System.out.println("Main thread ends");
    }

}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Daemon: " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Daemon: " + isDaemon());
        for (int i = 1; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}