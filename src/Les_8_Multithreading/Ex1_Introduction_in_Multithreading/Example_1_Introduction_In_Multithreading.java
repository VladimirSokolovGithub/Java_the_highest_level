package Les_8_Multithreading.Ex1_Introduction_in_Multithreading;

public class Example_1_Introduction_In_Multithreading {
    //В main методе автоматически создался один поток и инструкции(код) выполнялся последовательно.
    //Основные цели многопоточности это Производительность и Concurrency(параллельная обработка) -
    // выполнение одновременно нескольких задач.
    public static void main(String[] args) {
        System.out.println("Hello!");
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }
        System.out.println("Goodbye!");
    }
}
