package Les_8_Multithreading.Les14_ThreadPool_and_ExecutorService_Part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example_2_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //Рассмотрим ещё один вид ТредПулов. Создадим его с помощью фактори
        // метода Executors.newSingleThreadExecutor(), который создаст один поток.
        //В нашем примере все 10 заданий будут выполняться одним потоком, который содержится в нашем
        //тредпуле executorService. И все задания будут выполняться поочередно.
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++){
           executorService.execute(new RunnableImpl200());
        }
        executorService.shutdown();

    }
}

class RunnableImpl200 implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
