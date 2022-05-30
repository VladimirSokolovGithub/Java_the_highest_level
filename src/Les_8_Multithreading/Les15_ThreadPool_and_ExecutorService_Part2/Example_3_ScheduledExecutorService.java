package Les_8_Multithreading.Les15_ThreadPool_and_ExecutorService_Part2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example_3_ScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        // метод scheduleWithFixedDelay() - этот метод так же планирует задачу для периодического выполнения.
        // Этот метод принимает такие-же параметры, как и метод scheduleAtFixedRate(),
        // но period в этом методе означает, что между окончанием первого задания и началом второго должно
        // пройти заданное в period-е время, в нашем случае одна секунда.
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl500()
                , 3, 1, TimeUnit.SECONDS);

        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
    }
}


class RunnableImpl500 implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}