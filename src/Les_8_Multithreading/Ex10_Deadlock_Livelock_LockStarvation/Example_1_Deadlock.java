package Les_8_Multithreading.Ex10_Deadlock_Livelock_LockStarvation;

public class Example_1_Deadlock {

    //Deadlock - ситуация, когда 2 или более потоков заблокированы(залочены) навсегда,
    // ожидают друг друга и ничего не делают.

    //Это возникает когда несколько потоков используют синхронизацию на нескольких объектах.
    // И эти потоки используют синхронизацию на этих объектах не в одинаковом порядке.

    public static final Object lock1 = new Object(); //будем проводить синхронизацию на этих двух объектах
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

class Thread10 extends Thread{
    //В методе run() используем synchronized блок, в котором будем делать lock на объекте Example_1_Deadlock
    public void run(){
        System.out.println("Thread10: Попытка захватить монитор объекта lock1");
        synchronized (Example_1_Deadlock.lock1){
            System.out.println("Thread10: Монитор объекта lock1 захвачен");

            System.out.println("Thread10: Попытка захватить монитор объекта lock2");
            synchronized (Example_1_Deadlock.lock2){
                System.out.println("Thread10: Мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}

//class Thread20 extends Thread{
//    //В методе run() используем synchronized блок, в котором будем делать lock на объекте Example_1_Deadlock
//    public void run(){
//        System.out.println("Thread20: Попытка захватить монитор объекта lock2");
//        synchronized (Example_1_Deadlock.lock2){
//            System.out.println("Thread20: Монитор объекта lock2 захвачен");
//
//            System.out.println("Thread20: Попытка захватить монитор объекта lock1");
//            synchronized (Example_1_Deadlock.lock1){
//                System.out.println("Thread20: Мониторы объектов lock2 и lock1 захвачены");
//            }
//        }
//    }
//}

//Для того что бы избежать такой ситуации с Deadlock, нам просто нужно изменить порядок наших локов,
// смотрим пример ниже.
//т.е. если поток thread10 лочит в таком порядке lock1 и затем lock2, то для того что бы не вогзник
//Deadlock, поток thread20 должен тоже делать лок в таком же порядке, как и thread10.
//Это произойдет потому что какой из потоков сделает лок объекта lock1, тот же поток затем сделает
//лок объекта lock2 и завершит свою работу. После этого начнётся работа следующего потока, он так же
// сначала залочит lock1, а затем lock2 и тоже завершит свою работу.

class Thread20 extends Thread{
    //В методе run() используем synchronized блок, в котором будем делать lock на объекте Example_1_Deadlock
    public void run(){
        System.out.println("Thread20: Попытка захватить монитор объекта lock1");
        synchronized (Example_1_Deadlock.lock1){
            System.out.println("Thread20: Монитор объекта lock1 захвачен");

            System.out.println("Thread20: Попытка захватить монитор объекта lock2");
            synchronized (Example_1_Deadlock.lock2){
                System.out.println("Thread20: Мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}