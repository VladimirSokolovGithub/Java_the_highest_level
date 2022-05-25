package Les_8_Multithreading.Ex11_Lock_and_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example_2_Bankomat {

    //Метод tryLock() - попытайся сделать локк.
    //Если замок открыт то tryLock() закроет(захватит) этот замок т.е выполнится тот же метод lock(),
    //если же замок закрыт т.е. код обрабатывается каким то другим потоком, тогда у нашего потока не
    //получается сделать Локк и он продолжает выполнять свой последующий код. Таким образом он в область
    //кода учитывающую синхронизацию вообще не зайдёт.

    //Метод tryLock() - позволяет делать Локк, когда ресурс свободен или делать что-то другое
    // когда ресурс занят.

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee("Vladimir", lock);
        new Employee("Oleg", lock);
        new Employee("Elena", lock);

        Thread.sleep(5000);
        new Employee("Viktor", lock);
        new Employee("Marina", lock);
    }

}

//Создадим класс Работник - который будет пользоваться банкоматом. Каждый работник будет новым потоком.
class Employee extends Thread {
    String name;
    //каждому работнику будет передаваться lock
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start(); //будем запускать поток при создании нового объекта, сразу в конструкторе.
    }

//    @Override
//    public void run() {
//        try {
//            System.out.println(name + " ждёт...");
//            lock.lock();
//            System.out.println(name + " пользуется банкоматом");
//            Thread.sleep(2000);
//            System.out.println(name + " завершил использование банкомата");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        finally {
//            lock.unlock();
//        }

    @Override
    public void run() {
        if (lock.tryLock()) {
            try {
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " завершил использование банкомата");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " не хочет ждать в очереди");
        }

    }
}