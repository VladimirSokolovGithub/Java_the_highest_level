package Les_8_Multithreading.Ex14_ThreadPool_and_ExecutorService_Part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example_1_ThreadPool {
    //Очень часто на практике нам приходится создавать не один и два, а большее количество потоков.
    //Создание потока довольно затратная по времени операция. Управлять отдельно созданными потоками неудобно.

    //ThreadPool - это множество потоков, каждый из которых предназначен для выполнения той или иной задачи.
    //В Java с Thread Pool-ами удобнее всего работать посредством ExecutorService.

    //ThreadPool более эффективен с точки зрения различных процессов, которые происходят за кулисами, когда
    //мы работаем с множеством потоков.

    //В Java мы работаем с ThreadPool (пулом потоков) посредством объектов Executor.
    // Executor - это интерфейс. Переводится как исполнитель.
    //Мы будем рассматривать 2 вида Executor-ов. Интерфейс ExecutorService и ScheduledExecutorService

    public static void main(String[] args) throws InterruptedException {
        //Есть вариант создания самого ThreadPoolExecutor с указанием определенных параметров.
        //ExecutorService executorService = new ThreadPoolExecutor();
        // Но напрямую ThreadPool практически некогда не создают.
        //Для того чтобы создать ThreadPool, мы всегда будем использовать один из factory
        // методов класса Executors - Executors.newFixedThreadPool(int count) - указать в параметрах
        // количество потоков которое необходимо создать.
        //метод Executors.newSingleThreadPool() - создаст pool с одним потоком.

        ExecutorService executorService = Executors.newFixedThreadPool(5); //создали Thread Pool,
                                                                                   // который хранит 5 потоков.
        for (int i = 0; i < 10; i++){
            //Вызываем у нашего объекта executorService метод execute(new RunnableImpl100()) и передаём
            // ему объект класса который имплементирует интерфейс Runnable.
            executorService.execute(new RunnableImpl100());
        }
        //В таком варианте выше, без метода shutdown() наша программа не заканчивает свою работу. Это
        //происходит потому, что executorService ждёт новых Task-ов что бы обработать и их тоже. Если
        //мы не намерены давать новые Task-и, то обязательно нужно заканчивать работу executorService-а
        //добавив метод executorService.shutdown(). И тогда как только все задания выполнятся программа
        //завершиться.
        executorService.shutdown();

        //Метод awaitTermination() принимает 2 параметра, 1-й это timeout(количество секунд, дней, минут),
        // которые принимают нужное значение с помощью второго параметра - TimeUnit. Метод выбрасывает
        // InterruptedException. Этот метод работает практически как метод join. Он заставляет ожидать поток
        // в котором он вызывается. В данном случае мы вызываем кго внутри потока Main, значит поток Main
        // будет ждать до тех пор, пока executorService не закончит всю свою работу, либо не пройдёт указанное
        //в параметре время. То есть какое из событий наступит раньше, закончит работу наш
        // Thread Pool - executorService или наступит timeout в методе.
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        //Теперь поток Main ждёт и "Main ends" выводится в конце, это происходит из - за работы метода
        //executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Main ends");
    }
}

class RunnableImpl100 implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(4000); //если поменять на 500 миллисекунд, то сначала закончит
                                     // работу executorService, а потом поток Main
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}

//Внутри потока Main был создан Thread Pool из пяти потоков, затем с помощью метода execute() мы передали
//какое-то задание, а именно в нашем случае (new RunnableImpl100()).