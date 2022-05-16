package Les_8_Multithreading.Ex7_Data_race_and_Synchronized_methods;

public class Example_1_Synchronized_methods {

    //Разберем технику синхронизации потоков, когда в нашем приложении несколько потоков хотят
    //менять значение какой-то переменной.
    //Так как потоки могут менять данные одновременно из-за этого могут возникнуть какие-то
    //нежелательные последствия.

    //Что бы не допускать таких последствий нам нужно быть уверенным в том, что в одно и то же время
    //с переменной "count" т.е. чтение этой переменной и запись в неё нового значения, будет производиться
    //только одним потоком. Что бы этого добиться мы можем поставить lock - замок и добиться того, что
    // метод increment() в одно и то же время работает только для одного потока. Это достигается с помощью
    //ключевого слова "synchronized" которое мы применяем на нашем методе.

    public static void main(String[] args) {
        MyRunnableImpl1 runnable = new MyRunnableImpl1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter{
    volatile static int count = 0; //здесь ключевое слово volatile на результат не влияет
                                    // так как с этой переменной одновременно работают несколько потоков
}

class MyRunnableImpl1 implements Runnable{

    public synchronized void increment(){ //ключевое слово "synchronized"
        Counter.count ++;
        System.out.print(Counter.count + " ");
    }

//    public void increment(){ //без ключевого слова "synchronized"
//        Counter.count ++;
//        System.out.print(Counter.count + " ");
//    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            increment();
        }
    }
}
