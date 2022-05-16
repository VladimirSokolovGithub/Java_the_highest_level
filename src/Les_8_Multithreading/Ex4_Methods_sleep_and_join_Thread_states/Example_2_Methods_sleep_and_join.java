package Les_8_Multithreading.Ex4_Methods_sleep_and_join_Thread_states;

//Так же метод sleep() может выбрасывать исключение InterruptedException так как поток может прервать другой
// поток т.е попросить его остановиться. Другими словами если поток thread1 попросит поток thread2 остановиться,
//а тот будет в свою очередь спать, то выбросится InterruptedException.


//В самом начале выведется в консоль информация из потока main - The end. Затем через секунду начнут работу
//потоки thread1 и thread2. Это произошло потому что метод(поток) main запустил два других потока и продолжил
//дальше свою работу, а запущенные потоки уже работают сами по себе отпочковавшись от потока main.


//Method join()
//Method join() так же может выбрасывать исключение InterruptedException.
//Поток в котором вызывается метод join() (не на котором - thread1.join()), а в котором(внутри которого),
// в нашем случае внутри метода(потока) main (thread1.join() в нашем случае вызывается внутри потока main),
// тогда метод(поток) main будет ждать тот поток на котором вызван метод join() т.е
// будет ждать завершения работы потока thread1.
// Т.е. в нашем примере метод main будет ждать окончания работы потоков thread1.join() и thread2.join()
// так как на них мы вызвали метод join() и только после их завершения продолжит свою работу и выведет
// сообщение - The end.

public class Example_2_Methods_sleep_and_join extends Thread {

    @Override
    public void run(){
        for (int i = 1; i <= 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        Example_2_Methods_sleep_and_join thread2 = new Example_2_Methods_sleep_and_join();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The end");
    }
}

class MyRunnable1 implements Runnable{
    @Override
    public void run(){
        for (int i = 1; i <= 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}




