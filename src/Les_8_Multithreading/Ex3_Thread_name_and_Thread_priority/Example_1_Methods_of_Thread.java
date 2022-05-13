package Les_8_Multithreading.Ex3_Thread_name_and_Thread_priority;

public class Example_1_Methods_of_Thread {
    //Приоритетная шкала у потоков от 1 до 10, где 10 это наивысший приоритет. Значение по by Default = 5.
    //С помощью методов getName() и getPriority() класса Thread мы можем узнать имя потока и его приоритет.
    //Имена по умолчанию = Thread-0, Thread-1 и т.д.
    //Имя потока можно задать самостоятельно(изменить).
    //Приоритет так же можно задать или изменить, но нет гарантии того, что поток с высшим приоритетом
    // запуститься быстрее чем поток с более низким приоритетом.

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("Name of myThread = " + myThread.getName() +
                " / Priority of myThread = " + myThread.getPriority());


        MyThread myThread2 = new MyThread();
        System.out.println("Name of myThread2 = " + myThread2.getName() +
                " / Priority of myThread2 = " + myThread2.getPriority());

        System.out.println("*****************************************************");

        myThread.setName("my_thread");
        myThread.setPriority(9);
        //Так же приоритет можно задавать с помощью готовых констант
//        myThread.setPriority(Thread.MIN_PRIORITY);
//        myThread.setPriority(Thread.NORM_PRIORITY);
//        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name of myThread = " + myThread.getName() +
                " / Priority of myThread = " + myThread.getPriority());

    }
}

class MyThread extends Thread{
    public void run(){
        System.out.println("Hello!");
    }
}
