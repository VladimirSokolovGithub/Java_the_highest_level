package Les_8_Multithreading.Les16_Callable_and_Future_interfaces_Part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example_1_RunnableFactorial {
    //Рассмотрим пример как мы можем найти факториал числа используя наш Runnable и ExecutorService.
    //Факториал числа N, это произведения всех натуральных чисел от 1-го до N включительно.

    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        executorService.execute(factorial);
        executorService.shutdown();

        //Далее мы просим наш Main поток подождать 10 секунд, для того чтобы наш Main поток не смог сразу
        // вывести наш факториал System.out.println(factorialResult), так как нужно сначала что бы выполнился
        // наш метод run(), иначе поток Main сразу выведет ноль и программа завершит свою работу.
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(factorialResult);

        //05:27
    }

}

class Factorial implements Runnable {
    int f;

    public Factorial(int f){
        this.f = f;
    }

    @Override
    public void run(){
        if (f <= 0){
            System.out.println("Вы ввели неверное число");
            return;
        }
        int result = 1;
        for (int i = 1; i <= f; i++){
            result *= i;
        }
        Example_1_RunnableFactorial.factorialResult = result;
    }
}
