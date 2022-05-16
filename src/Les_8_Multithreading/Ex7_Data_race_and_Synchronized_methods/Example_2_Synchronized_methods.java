package Les_8_Multithreading.Ex7_Data_race_and_Synchronized_methods;

//Разберем технику синхронизации потоков, когда в нашем приложении несколько потоков хотят
//менять значение какой-то переменной.
//Так как потоки могут менять данные одновременно из-за этого могут возникнуть какие-то
//нежелательные последствия.

//Что бы не допускать таких последствий нам нужно быть уверенным в том, что в одно и то же время
//с переменной "count" т.е. чтение этой переменной и запись в неё нового значения, будет производиться
//только одним потоком. Что бы этого добиться мы можем поставить lock - замок и добиться того, что
// метод increment() в одно и то же время работает только для одного потока. Это достигается с помощью
//ключевого слова "synchronized" которое мы применяем на нашем методе.

//Ключевое слово "synchronized" не применимо к переменным. Переменные могут быть volatile,
// но не могут быть synchronized.

public class Example_2_Synchronized_methods {
    volatile static int counter = 0; //здесь ключевое слово volatile на результат не влияет
                                    // так как с этой переменной одновременно работают несколько потоков

    public static synchronized void increment(){ //ключевое слово "synchronized"
        counter++;
    }

//    public static void increment(){ //без ключевого слова "synchronized"
//        counter++;
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class R implements Runnable{
    @Override
    public void run() {
        for (int i =0; i < 1000; i++){ //затем со 100 увеличим до 1000
            Example_2_Synchronized_methods.increment();
        }
    }
}
