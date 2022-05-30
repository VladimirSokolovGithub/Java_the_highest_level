package Les_8_Multithreading.Les15_ThreadPool_and_ExecutorService_Part2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Example_2_ScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        // метод scheduleAtFixedRate() - этот метод планирует задачу для периодического выполнения.
        //Впервые наша задача, наш task new RunnableImpl300() обработается через 3 секунды после запуска
        //метода scheduleAtFixedRate() и потом будет выполняться с периодичностью в одну секунду.
        //Т.е. этот период в одну секунду это период перед началом выполнения этого задания и началом
        //выполнения следующего задания и так далее пока не вызовется метод shutdown(). (т.е. period -
        // это время между началом n-го task-а и task-а n+1)

        //Но если наш task работает больше одной секунды, например 2 секунды тогда наш scheduledExecutorService
        // уже абсолютно ничего не ждёт для того, чтобы начать выполнять второй task, но после полного
        //выполнения первого task-а.
        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl400()
                , 3, 1, TimeUnit.SECONDS);

        //Нам нужно сделать так, чтобы поток Main поспал 20 секунд, для того, чтобы наш метод
        // scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl300(), 3, 1, TimeUnit.SECONDS);
        //отработал с заложенной в него периодичностью, а не сразу прекратил работу при помощи метода
        //shutdown(), выполнившись всего один раз.
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
    }
}


class RunnableImpl400 implements Runnable{
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