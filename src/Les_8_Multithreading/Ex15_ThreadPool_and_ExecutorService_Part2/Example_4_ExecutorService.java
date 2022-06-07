package Les_8_Multithreading.Ex15_ThreadPool_and_ExecutorService_Part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example_4_ExecutorService {
    public static void main(String[] args) {

        //Так же мы можем создать кэшированный ThreadPool.
        //Метод newCachedThreadPool() создаст ThreadPool, который будет создавать в себе новые потоки
        //по надобности.
        //Допустим пришло первое задание, он создал thred1 - thred1 выполняет первое задание,
        // тем временем пришло второе задание, он создал thred2 - thred2 выполняет второе задание. Когда
        // пришло третье задание, если thred1 уже освободился, он будет переиспользован и займется
        // выплнение третьего задания. Если когда приходит четвертое задание и оба этих треда thred1
        // и thred2 заняты, то создастся трети тред - thred3. Наступает момент когда задания не приходят
        // и если через 60 секунд после того как мы использовали последний раз какой - либо из созданных
        // тредов, например thred3, то CachedThreadPool удалит thred3. Он посчитает что этот thred3 ему
        // уже не нужен. Но если будет новый наплыв заданий, то этот кешированный ThreadPool начнет
        // создавать нове потоки.

        ExecutorService executorService = Executors.newCachedThreadPool();

    }
}
