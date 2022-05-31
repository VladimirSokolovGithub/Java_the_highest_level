package Les_8_Multithreading.Les16_Callable_and_Future_interfaces_Part1;

import java.util.concurrent.*;

//Интерфейс Callable имеет в себе так же только один метод call(). Метод call() может выбрасывать
//Exception и благодаря generics имеет return type. То есть при создании Callable, мы должны указать
//с каким типом этот Callable<V> будет работать, т.е какой тип данных будет возвращать метод call().

//Таким образом интерфейс Callable, как и интерфейс Runnable представляет собой какое-то задание (task),
//которое должно быть выполнено потоком.

public class Example_2_CallableFactorial {
    static int factorialResult;

    //метод submit(), так же как и метод execute(), добавляет наш task в Thread poll, но помимо этого
    //он ещё и возвращает результат нашего task-a. Этот результат хранится в объекте типа Future.
    //Future тоже работает с generics.

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(5);
        //Для интерфейса Callable мы не можем вызвать метод execute(), так как он принимает Runnable.
        //Для Callable существует метод submit().
        //метод submit(), так же как и метод execute(), добавляет наш task в Thread poll, но помимо этого
        //он ещё и возвращает результат нашего task-a. Этот результат хранится в объекте типа Future.
        //Future тоже работает с generics и соответственно может принимать нужный нам тип(в нашем случае Integer).

        Future<Integer> future = executorService.submit(factorial2);

        //Далее нам нужно получить результат task-a из объекта Future. Это можно сделать с помощью
        //метода get().
        //future.get() выбрасывает Exception. А почему он выбрасывает Exception, потому что метод call() это
        //допускает. Поэтому мы должны обернуть эту конструкцию в try-catch.

        try {
            factorialResult = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause()); //e - это наш Exception, а с помощью метода getCause() мы можем
                                              //вывести причину по которой наш Exception был выброшен.
                                //А что это за причина покажет наше сообщение в методе call() класса Factorial2.
        }
        //после чего мы должны закрыть наш ExecutorService. И нужно запомнить, что ExecutorService очень
        //хорошо закрывается в finally блоках.
        finally {
            executorService.shutdown();
        }
        //И выведем наш факториал в консоль.
        System.out.println(factorialResult);

    }
}

//Наш интерфейс Callable<Integer> будет возвращать тип Integer, так как мы работаем с натуральными целыми
// числами и находим факториал.

class  Factorial2 implements Callable<Integer>{
    int f;

    public Factorial2(int f){
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
        }
        return result;
    }
}

