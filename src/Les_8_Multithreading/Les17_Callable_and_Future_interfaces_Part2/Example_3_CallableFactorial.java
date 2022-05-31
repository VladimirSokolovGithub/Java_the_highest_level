package Les_8_Multithreading.Les17_Callable_and_Future_interfaces_Part2;

import java.util.concurrent.*;
import java.util.logging.SocketHandler;

public class Example_3_CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial3 factorial3 = new Factorial3(6);

        Future<Integer> future = executorService.submit(factorial3);
        //Когда мы делаем submit(factorial2) и возвращаем Future, результата работы нашего task-a пока что
        //нет. Он будет в будущем, когда task полностью выполнится. Поэтому интерфейс так и называется
        //Future - будущее. И когда мы пытаемся вытащить из future результат нашего task-a, используя метод
        //get(), а этот task ещё не закончил свою работу, наш Thread, который вызвал метод get(), в нашем случае
        // это Main, будет заблокирован до тех пор, пока task не завершится(т.е пока факториал не будет найден и
        // future не вернет нам результат.).

        //метод isDone() -
        //Так же с помощью Future мы можем проверить завершён ли наш task. Это проверяется с помощью метода
        //isDone().

        //метод submit() -
        //метод submit() мы можем использовать когда мы работаем с Runnable тоже.
        //Рассмотрим это в примере Example_1_RunnableFactorial.

        try {
            System.out.println(future.isDone()); //Проверка закончился ли наш task
            System.out.println("Хотим получить результат");
            factorialResult = future.get(); //Метод get() блокирует поток в котором вызван, до тех пор
                                            // пока task не завершит свою работу
            //Для того, чтобы увидеть эту блокировку, мы добавили сон в методе call().
            System.out.println("Получили результат");
            System.out.println(future.isDone());//Проверка закончился ли наш task
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }

        //Почему здесь нам уже не нужно использовать и вызывать у executorService метод
        // awaitTermination(10, TimeUnit.SECONDS)? Потому что когда мы дойдём до System.out.println(factorialResult)
        //factorialResult уже будет хранить вычисленное значение.

        System.out.println(factorialResult);
    }
}

class  Factorial3 implements Callable<Integer> {
    int f;

    public Factorial3(int f){
        this.f = f;
    }

    @Override
    public Integer call() throws Exception{
        if (f <= 0){
            throw new Exception("Вы ввели неверное число");
        }
        int result = 1;
        for (int i = 1; i <= f; i++){
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}
//***Дополнительная информация***
//Runnable мы можем использовать как с ExecutorService-ами, так и при отдельном создании Thread.
//Callable<> мы можем использовать только с ExecutorService-ами.
//Если нам не нужно чтобы task возвращал результат, то нужно использовать Runnable, если нужно
//чтобы task возвращал результат, то используем Callable<>.

