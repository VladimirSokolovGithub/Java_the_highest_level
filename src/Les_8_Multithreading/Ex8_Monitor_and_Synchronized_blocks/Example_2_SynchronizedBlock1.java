package Les_8_Multithreading.Ex8_Monitor_and_Synchronized_blocks;

public class Example_2_SynchronizedBlock1 {

    public static void main(String[] args) {
        MyRunnableImpl2 runnable = new MyRunnableImpl2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Counter2 {
    volatile static int count = 0;

}

class MyRunnableImpl2 implements Runnable {

    //Здесь слово synchronized мы из названия метода убрали и сделаем synchronized block.
    //Мы пишем слово synchronized в круглых скобках пишется объект на котором мы будем синхронизироваться.
    // т.е. объект, чей монитор для синхронизации мы будем использовать. И далее в фигурные скобки
    // помещается код который должен быть синхронизирован.
    //Синхронизация будет происходить на объекте "this". Т.е. перед тем как будет вызываться метод doWork1(),
    //он не статичный, нужно будет создать объект MyRunnableImpl2.
    //"this" означает, что синхронизация будет вестись на объекте класса MyRunnableImpl2 который мы создадим.

    private void doWork1() {
        doWork2(); //Эту часть кода будут выполнять сразу несколько потоков и работать с методом doWork2()
                    // одновременно

        synchronized (this) { //А в этой части кода в synchronized block потоки, уже будут работать по одному(по очереди)
            Counter2.count++;
            System.out.println(Counter2.count);
        }
    }

    private void doWork2(){
        System.out.println("Ura!!!");
    }


    //Так выглядел синхронизированный метод

//    public synchronized void doWork1() {
//        Counter2.count++;
//        System.out.println(Counter2.count);
//    }

    //Отличие от синхронизированных методов от synchronized block в том, что в методах мы явно сами не указываем
    //объект, на котором будет вестись синхронизация и чей монитор будет блокироваться потоком. А в
    // synchronized block мы должны явно указать, монитор какого объекта будет использоваться для синхронизации.

    //Когда мы работаем с synchronized methods и если у нас метод не статичный, то у нас всегда идёт
    //синхронизация на объекте this

    //Самое главное отличие синхронизированного метода от синхронизированного бока в том, что мы можем
    //синхронизировать не весь метод, а его часть.

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}
