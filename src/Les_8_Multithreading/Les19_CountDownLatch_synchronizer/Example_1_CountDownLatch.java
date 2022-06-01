package Les_8_Multithreading.Les19_CountDownLatch_synchronizer;

import java.util.concurrent.CountDownLatch;

//Synchronizer CountDownLatch - замок с обратным отсчётом.
//Данный синхронизатор позволяет нескольким потокам ждать до тех пор, пока не закончится обратный отсчёт,
// т.е не настанет ноль. Другими словами CountDownLatch предоставляет возможность любому количеству потоков
// ожидать до тех пор, пока не завершиться определенное количество операций. После окончания этих операций
// потоки будут отпущены, чтобы продолжить свою деятельность. В конструктор CountDownLatch обязательно
// передаётся количество операций которое должно быть выполнено, что бы замок отпустил заблокированные потоки.

//методы CountDownLatch -

//await() - если счётчик CountDownLatch больше нуля, наш поток будет заблокирован до тех пор, пока
// счётчик не станет равен нулю. Если же счётчик уже ноль, то наш поток будет беспрепятственно
// выполнять свою работу.

//countDown() - с помощью метода countDown() уменьшим счётчик на единицу.

//getCount() - с помощью метода getCount() можно получить значение счётчика



//Пример CountDownLatch
//Представим ситуацию которая может произойти в магазинах в день черной пятницы. Когда во многих магазинах
//бывают огромные скидки. С утра у магазина стоит очередь наготове и несколько человек, которые стоят одни
//из первых не могут приступить к покупкам пока не выполняться определенные операции:
//1.Работники магазина должны прийти на работу.
//2.Всё в магазине должно быть разложено по полкам. В магазине должен быть включен свет.
//3.Магазин должен открыться.


public class Example_1_CountDownLatch {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market Staff came to work");
        countDownLatch.countDown(); //с помощью метода countDown() уменьшим счётчик на единицу
        System.out.println("countDownLatch = " + countDownLatch.getCount()); //выведем значение счётчика
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready so let's open market");
        countDownLatch.countDown(); //с помощью метода countDown() уменьшим счётчик на единицу
        System.out.println("countDownLatch = " + countDownLatch.getCount()); //выведем значение счётчика
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown(); //с помощью метода countDown() уменьшим счётчик на единицу
        System.out.println("countDownLatch = " + countDownLatch.getCount()); //выведем значение счётчика
    }

    public static void main(String[] args) throws InterruptedException {
        new Friend("Vladimir", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Elena", countDownLatch);
        new Friend("Viktor", countDownLatch);
        new Friend("Marina", countDownLatch);
        //Все пять потоков запустятся и пока счётчик не станет равным нулю они будут ждать и лишь потом, они
        // все сразу продолжат свою работу.

        //Запустим наши методы. Каждый из них уменьшит счётчик CountDownLatch на единицу.
        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start(); //При создании объекта Friend, thread будет сразу запускаться.
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " приступил к покупкам");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}