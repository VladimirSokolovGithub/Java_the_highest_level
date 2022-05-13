package Les_8_Multithreading.Ex3_Thread_name_and_Thread_priority;

public class Example_2_Methods_of_Thread implements Runnable {
    //Так же очень важный момент в том, что самостоятельно никогда не нужно запускать метод run()

    //метод currentThread()
    //У класса Thread так же есть метод currentThread(), это  статический метод Thread.currentThread(), он
    // вызывается с указанием класса перед самим методом. Метод показывает(возвращает) текущий выполняющийся поток,
    // т.е. если мы его запускаем в методе run, он вернёт поток в котором мы сейчас находимся.
    //Thread.currentThread().getName() - получим имя текущего потока.
    public void run(){
        System.out.println("Method run(). Thread name = " + Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new Example_2_Methods_of_Thread());
        thread.start();
//        thread.run(); //когда мы запускаем самостоятельно метод run(), то он не запускает отдельный поток,
                        //а выполняется, как часть потока main. Так делать нельзя.
        System.out.println("Method main. Thread name = " + Thread.currentThread().getName());
    }
}
