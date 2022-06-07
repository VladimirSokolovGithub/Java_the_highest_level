package Les_8_Multithreading.Ex15_ThreadPool_and_ExecutorService_Part2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example_1_ScheduledExecutorService {
    //Когда нам необходимо запускать поток или несколько потоков из пула по какому-то расписанию, то
    //нужно использовать ScheduledExecutorService.

    //Этот pool создается, используя factory метод класса Executors:
    //Executors.newScheduledThreadPool(int count)

    //Рассмотрим:
    // метод schedule() - выполнит наши task-и через определенный период времени

    // метод scheduleAtFixedRate() - этот метод планирует задачу для периодического выполнения.

    // метод scheduleWithFixedDelay() - этот метод так же планирует задачу для периодического выполнения.
    // Этот метод принимает такие-же параметры, как и метод scheduleAtFixedRate(),
    // но period в этом методе означает, что между окончанием первого задания и началом второго должно
    // пройти заданное в period-е время.

    public static void main(String[] args) {

        //Для начала нам нужно создать объект типа ScheduledExecutorService.
        //Он создаётся с помощью метода newScheduledThreadPool(1) класса Executors.
        //В параметре указывается количество потоков которые будут созданы в нашем ThreadPool.
        //Метод execute(new RunnableImpl300()) передаёт наше задание (task) в ThreadPool, где оно выполняется
        //одним из потоков. В нашем случае всего одним потоком. Но для одного потока нет необходимости
        //использовать ScheduledExecutorService, для этого мы можем использовать обычный ExecutorService.
        //ScheduledExecutorService используется тогда, когда нам необходимо устанавливать какие-то расписания
        // запуска наших потоков.


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        //        for (int i = 0; i < 10; i++){
//            scheduledExecutorService.execute(new RunnableImpl300());
//        }

        // метод schedule() - выполнит наши task-и через определенный период времени.
        //Это читается как, выполни задание new RunnableImpl300() через 3 секунды.
        //Т.е. это отсрочит время начала выполнения этого task-а на 3 секунды.
        scheduledExecutorService.schedule(new RunnableImpl300(), 3, TimeUnit.SECONDS);

        //В конце нужно выполнить метод shutdown() что бы наша программа завершилась
        scheduledExecutorService.shutdown();
    }
}

class RunnableImpl300 implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}