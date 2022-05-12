package Les_8_Multithreading.Ex2_Options_for_creating_threads;

public class Example_2_Options_for_creating_threads_1 {
    //Рассмотрим два варианта создания нового потока:

    //1 способ.
    // Нужно унаследовать наш клас от класса Thread и переопределить его метод run, в который и будет помещена
    //вся логика, которую будет выполнять наш новый поток. Для запуска новых потоков, из нашего примера,
    // мы должны создать объекты классов MyThread1 и MyThread2 и и вызвать у них метод start(). Метод run() будет
    // вызван jvm автоматически после вызова метода start().

    public static void main(String[] args) {
        //В нашем случае, при таком запуске потоков, потоки не синхронизированы и мы не знаем какой запуститься
        // первым, какой вторым, и как они будут выполняться. При каждом новом запуске результат будет разный.
        // Так как мы не знаем какой поток окажется шустрее и захватит нашу консоль для вывода на экран информации.

        //Метод main так же сам по себе является потоком, главным потоком. Поэтому в нашем примере работают
        // три потока, а не два. Они работают параллельно и к примеру main может закончить работу, а наши два потока
        // будут продолжать работать, и программа не остановится, пока все потоки не закончат работу.
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();

        //Так же например можно создать несколько потоков одного класса, например MyThread1. И они так же будут
        // работать параллельно
//        MyThread1 myThread3 = new MyThread1();
//        MyThread1 myThread4 = new MyThread1();
//        myThread3.start();
//        myThread4.start();
    }
}

class MyThread1 extends Thread {
    public void run(){
        for (int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
    }
}

class MyThread2 extends Thread {
    public void run(){
        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }
}


