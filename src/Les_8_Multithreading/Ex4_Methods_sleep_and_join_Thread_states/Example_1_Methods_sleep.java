package Les_8_Multithreading.Ex4_Methods_sleep_and_join_Thread_states;

public class Example_1_Methods_sleep {

    //Этот пример не связан с многопоточностью, мы просто попробуем усыпить поток main.

    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i > 0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Поехали!!!");
    }
}
