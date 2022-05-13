package Les_8_Multithreading.Ex2_Options_for_creating_threads;

public class Example_2_Options_for_creating_threads_4 {
    //Допустим мы хотим создать по быстрому поток и запустить его не используя класс который
    //implements Runnable. Для этого нужно создать поток и в параметр конструктора поставить
    //анонимный класс, который имплементирует интерфейс Runnable и далее вызвать метод start().

    //1 вариант
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        }).start();

        //2 вариант
        //Так как Runnable это функциональный интерфейс то в параметре класса Thread можно использовать
        //лямбда выражение для описания метода run() и его запуска с помощью метода start().
        new Thread(() -> System.out.println("hello")).start();
    }

}
