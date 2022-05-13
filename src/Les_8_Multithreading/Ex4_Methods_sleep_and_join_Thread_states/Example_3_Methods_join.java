package Les_8_Multithreading.Ex4_Methods_sleep_and_join_Thread_states;

public class Example_3_Methods_join {
    //У метода join() так же есть второй вариант с параметром в миллисекундах. С этим параметром текущий
    // поток (в нашем случае метод main) будет ждать пока не завершиться поток thread.join(1500); или пока
    // не пройдёт 1,5 секунды. Т.е какое событие случится первым, то и подстегнет поток main продолжить свою
    // работу.
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker());
        thread.start();
//        thread.join();
        thread.join(1500);
        System.out.println("Method main ends");
    }
}

class Worker implements Runnable {
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