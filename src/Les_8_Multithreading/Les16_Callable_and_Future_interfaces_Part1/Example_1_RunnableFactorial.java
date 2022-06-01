package Les_8_Multithreading.Les16_Callable_and_Future_interfaces_Part1;

import java.util.concurrent.*;

public class Example_1_RunnableFactorial {
    //Рассмотрим пример как мы можем найти факториал числа используя наш Runnable и ExecutorService.
    //Факториал числа N, это произведения всех натуральных чисел от 1-го до N включительно.

    static int factorialResult;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        executorService.execute(factorial);

        //метод submit() -
        //метод submit() мы можем использовать когда мы работаем с Runnable тоже.
        //Рассмотрим это в примере Example_1_RunnableFactorial.
        //Но здесь Future уже используется без Generics так как метод run() интерфейса Runnable ничего
        //не возвращает. И метод get() вызванный у future всегда будет возвращать Null так как метод run()
        // интерфейса Runnable ничего не возвращает.
        //Возникает вопрос для чего нам использовать Future и метод submit() совместно с Runnable?
        // С его помощью мы можем делать cancel нашего task-а, или узнавать закончилась ли его работа
        // с помощью isDone().

//        Future future = executorService.submit(factorial);

        executorService.shutdown();

        //Далее мы просим наш Main поток подождать 10 секунд, для того чтобы наш Main поток не смог сразу
        // вывести наш факториал System.out.println(factorialResult), так как нужно сначала что бы выполнился
        // наш метод run(), иначе поток Main сразу выведет ноль и программа завершит свою работу.
        executorService.awaitTermination(10, TimeUnit.SECONDS);

//        System.out.println(future.get()); //Убедимся что get() вернёт Null.
//        System.out.println(future.isDone()); //Убедимся что get() вернёт Null.

        System.out.println(factorialResult);
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

        //В этом коде в методе run() есть недостатки, так как нам приходится использовать переменную вне
        //класса Factorial, чтобы передать значение переменной result. А всё потому, что return type
        //метода run - это void и он ничего не возвращает. Так же мы не можем выбросить в нём Exception, а
        //очень бы хотелось при вводе неправильного значения. А почему интерфейс Runnable не может выбрасывать
        //Exception? Потому что посмотрев в интерфейсе на сигнатуру метода run(), мы увидим что он Exception
        //не выбрасывает. Следовательно, когда мы делаем @Override метода run() мы не можем выбрасывать в нем
        //Exception. Это недостатки интерфейса Runnable. Но есть интерфейс Callable, который очень похож на
        //Runnable, но ко всему прочему может в output-е возвращать значение и позволяет выбрасывать Exception.
        //Интерфейс Callable имеет в себе так же только один метод call(). Метод call() может выбрасывать
        //Exception и благодаря generics имеет return type. То есть при создании Callable, мы должны указать
        //с каким типом этот Callable<V> будет работать, т.е какой тип данных будет возвращать метод call().

        //Таким образом интерфейс Callable, как и интерфейс Runnable представляет собой какое-то задание (task),
        //которое должно быть выполнено потоком. В следующем примере рассмотрим этот же пример нахождения
        // факториала натурального числа с использованием интерфейса Callable.
        Example_1_RunnableFactorial.factorialResult = result;
    }
}
