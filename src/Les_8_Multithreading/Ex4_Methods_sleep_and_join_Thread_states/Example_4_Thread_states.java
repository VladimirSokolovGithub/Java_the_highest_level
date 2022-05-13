package Les_8_Multithreading.Ex4_Methods_sleep_and_join_Thread_states;

public class Example_4_Thread_states {
    //Состояния потоков

    //1. NEW - состояние после создания, до вызова метода start().

    //2. RUNNABLE - состояние сразу после вызова метода start(), состояние выполнения.
    //В свою очередь Runnable делится на два состояния:
    // - ready - готовность
    // - running - когда поток на самом деле выполняется
    //После вызова метода start() поток либо находится в состоянии ready(готов) - он ждёт операционную систему,
    // которая должна запустить его. Он ждёт потому что у нас в очереди может быть много потоков, которые ожидают
    // своего выполнения и тогда наш поток не сможет сразу начать работать, а будет стоять в очереди. И только
    // после того, как операционная система запустила поток, он перейдет в состояние running.


    //3. TERMINATED - состояние когда работа потока завершена.


    //Пример
    //В примере ниже у нас всё отработает гладко так как у нас поток очень медленный и спит 2,5 секунды.
    //Но если поток очень быстрый, то состояние RUNNABLE мы можем и не увидеть, пока оно будет выводится
    // на экран, поток может стать уже TERMINATED
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker2());
        System.out.println(thread.getState()); // состояние после создания //метод getState() возвращает состояние потока
        thread.start();
        System.out.println(thread.getState()); // состояние после запуска потока
        thread.join();
        System.out.println(thread.getState()); //состояние после завершения потока
        System.out.println("Method main ends");
    }
}

class Worker2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work ends");
    }
}

