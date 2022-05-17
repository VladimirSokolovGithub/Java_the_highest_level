package Les_8_Multithreading.Ex8_Monitor_and_Synchronized_blocks;



public class Example_3_SynchronizedBlock2 {

    volatile static int counter = 0;

    //Когда мы используем ключевое слово synchronized у статичного метода, то монитор на объекте this
    //использоваться не может. В этом случае когда метод статичный и синхронизированный (static synchronized), то
    //используется монитор всего класса. В нашем случае в круглых скобках синхронизированного блока будет
    //указано - (Example_3_SynchronizedBlock2.class)

//    public static synchronized void increment(){
//        counter++;
//    }

    //Вот как будет выглядеть synchronized block в статичном методе
    public static void increment(){
        synchronized(Example_3_SynchronizedBlock2.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R2());
        Thread thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class R2 implements Runnable{
    @Override
    public void run() {
        for (int i =0; i < 1000; i++){ //затем со 100 увеличим до 1000
            Example_3_SynchronizedBlock2.increment();
        }
    }
}
