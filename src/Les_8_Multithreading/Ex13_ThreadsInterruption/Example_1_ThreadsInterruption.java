package Les_8_Multithreading.Ex13_ThreadsInterruption;

public class Example_1_ThreadsInterruption {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");

        //создадим поток нашего класса InterruptedThread
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000); //Main спит 2 секунды
        //В предыдущих версиях Java использовался метод stop() для прерывания потока. Но этот метод является
        //устаревшим и в данный момент не рекомендован к использованию. Этот метод просто прерывал поток грубо,
        //и некоторые объекты и процессы оставались в непонятном и неоконченном состоянии.
//        thread.stop();

        //Теперь мы прервём наш поток используя метод interrupt(). Но на самом деле этот метод не прерывает
        //наш поток. Но поток сам может проверить хотят ли его прервать. И вот этот наш метод interrupt()
        //означает, что поток Main хочет прервать поток thread. Он не может его прервать, но он посылает
        //сигнал потоку thread, что я хочу тебя прервать, а поток thread может проверить хотят ли его прервать.
        //Если поток thread видит что его хотят прервать, он может реагировать на это совершенно поразному.
        //Если программист захочет он может завершить работу этого потока или же продолжить его работу.
        //Просто насколько это будет правильным зависит от конкретно поставленных целей.
        //Мы можем проверить хотят ли наш поток прервать используя метод isInterrupted() в методе run(). Он
        //вернет true, если какой-то другой поток захочет его прервать.
        thread.interrupt();

        thread.join();
        System.out.println("Main ends");
    }
}

class InterruptedThread extends Thread {
    //будем считать сумму корней чисел от 1 до 1 000 000 000
    double sqrtSum = 0;
    @Override
    public void run(){
        for (int i = 1; i <= 1000000000; i++){
            if (isInterrupted()){ //Мы можем проверить хотят ли наш поток прервать используя метод isInterrupted()
                System.out.println("Поток хотят прервать");
                System.out.println("Мы убедились, что состояние всех объектов нормальное и решили " +
                        "завершить работу потока");
                System.out.println(sqrtSum);
                return; //завершим работу потока выйдя из цикла.
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна. Давайте завершим его работу");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}

//Внутри условной конструкции if (isInterrupted() мы проверим если наш поток кто-то хочет прервать,
// мы можем выполнить какие - то действия.

//InterruptedException выбрасывается тогда, когда поток спит, а его хотят прервать.