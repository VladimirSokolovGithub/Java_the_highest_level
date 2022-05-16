package Les_8_Multithreading.Ex6_The_Volatile_keyword;

public class Example_1_Volatile extends Thread {
    //При решении большинства задач очень важно что бы соблюдалась упорядоченность в действиях
    //наших потоков. Это достигается за счёт их синхронизации. Синхронизации посвящены несколько след.уроков.
    //Сегодня рассмотрим ключевое слово "volatile" - перевод изменчивый, непостоянный.

    //Пример. В одном потоке работает цикл, который мы хотим закончить из другого потока изменив переменную с
    //true на false.

//    boolean b = true;
    volatile boolean b = true;

    @Override
    public void run(){
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Loop is finished. counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Example_1_Volatile thread = new Example_1_Volatile();
        thread.start();
        Thread.sleep(3000); //Это sleep для потока main, что бы поток thread работал 3 сек.
        System.out.println("After 3 seconds it is time to wake up!");
        thread.b = false; //В этом примере переменная "b" не приняла значение false и наш loop не остановился
                          //и программа не закончила свою работу.
        //Для того чтобы избежать этого, необходимо у переменной "b" использовать ключевое слово "volatile", и
        //тогда значение переменной будет храниться только в main memory и не будет помещаться в кэши ядер процессора,
        //тем самым у двух потоков всегда будет одинаковое значение этой переменной.
        thread.join();
        System.out.println("End of program");
    }
}

//Но нужно не забывать, что переменная помеченная как "volatile" работает корректно только тогда, когда
//лишь один поток её изменяет, а другой или несколько других потоков её только читают.



