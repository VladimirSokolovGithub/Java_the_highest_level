package Les_8_Multithreading.Ex2_Options_for_creating_threads;

public class Example_2_Options_for_creating_threads_3 extends Thread {
    //Так же наш пример из Example_2_........._2 можно записать короче с меньшим использованием кода.
    //Для этого мы сразу наследуем наш текущий клас от класса Thread, переопределяем метод run() и пишем
    //в нем нашу логику, после чего в методе main создаём объект нашего класса(новый поток) и запускаем его
    //с помощью метода start(), и далее прямо в методе main пишем ещё какую то логику - это и будет
    // наш второй поток.
    //Так же можно проделать и с классом который implements Runnable, но уже создав объект класса
    // Thread.

    public void run(){
        for (int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Example_2_Options_for_creating_threads_3 thread1 = new Example_2_Options_for_creating_threads_3();
        thread1.start();

        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }
}
