package Les_8_Multithreading.Ex2_Options_for_creating_threads;

public class Example_2_Options_for_creating_threads_2 {
    //Рассмотрим два варианта создания нового потока:

    // 2 способ.
    // Если наш клас уже наследовался и имеет родителя, то в таком случае создать поток можно создать
    // с помощью интерфейса Runnable. В интерфейсе Runnable есть все го лишь один абстрактный метод
    // run(). Поэтому мы должны переопределить его метод run() и так же написать в нём всю
    // необходимую логику. Для запуска потоков необходимо создать объект класса Thread и в параметре
    // конструктора при создании объекта поместить объект нашего класса MyThread3. И у объекта класса
    // Thread вызвать метод start().

    //Клас Thread так же implements Runnable, поэтому у него так же есть метод run().

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread3());
        Thread thread2 = new Thread(new MyThread4());
        thread1.start();
        thread2.start();

    }
}

class MyThread3 implements Runnable {
    public void run(){
        for (int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable {
    public void run(){
        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }
}

