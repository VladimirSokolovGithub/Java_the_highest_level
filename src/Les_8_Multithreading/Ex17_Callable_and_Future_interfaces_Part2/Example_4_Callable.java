package Les_8_Multithreading.Ex17_Callable_and_Future_interfaces_Part2;

//Ещё одна задача с Callable.
//Найдем сумму чисел от 1 до миллиарда не используя формулы, просто будет обычное сложение и
//это будет делать не один поток, а десять потоков, чтобы каждый делал сложение определённой группы чисел.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Example_4_Callable {

    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //Для удобства работы с 10-ю результатами этих task-ов создадим List
        List<Future<Long>> futureResults = new ArrayList<>();
        long valueDividedBy10 = value / 10;
        for (int i = 0; i < 10; i++){
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i+1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartSum = executorService.submit(task);
            futureResults.add(futurePartSum);
        }
        for (Future<Long> result : futureResults){
            sum += result.get();
        }
        executorService.shutdown();
        System.out.println("Total sum = " + sum);
    }
}

class PartialSum implements Callable<Long>{
    long from;
    long to;
    long localSum; //Значение суммы конкретного потока

    public PartialSum(long from, long to){
        this.from = from;
        this.to = to;
    }

    public Long call(){
        for (long i = from; i <= to; i++){
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
}