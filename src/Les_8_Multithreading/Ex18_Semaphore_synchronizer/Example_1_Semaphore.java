package Les_8_Multithreading.Ex18_Semaphore_synchronizer;

import java.util.concurrent.Semaphore;

//*******************************
//Синхронизатор Semaphore

//До этого мы рассматривали много Concurrency (параллельная обработка) примеров. Где Concurrency был
//low level (на низком уровне). Это означает, что мы сами писали lock-и, делали синхронизацию и т.д.
//Теперь мы рассмотрим несколько hi level Concurrency примеров, где мы сами не будем писать ни lock-и,
//ни синхронизации, а будем пользоваться готовыми решениями, которые в свою очередь внутри себя используют
//low level Concurrency механизмы. Такие готовые решения называют Synchronizers (Синхронизаторы).

//Semaphore - это синхронизатор, позволяющий ограничить доступ к какому-то ресурсу. В конструктор
//Semaphore нужно передавать количество потоков, которым Semaphore будет разрешать одновременно использовать
// этот ресурс.

//Если в конструктор Semaphore передаётся 1 поток, т.е. он изначально разрешает только одному thread-у
//использовать ресурс, тогда использование Semaphore будет такое же, как и использование
// lock-а т.е. ReentrantLock-а.

//Методы Semaphore -

//acquire() - метод acquire() предназначен для попытки получить разрешение от Semaphore-а. Метод заблокирует
// поток, пока ресурс не будет для него доступен. После доступности мы получим разрешение использовать этот
// общий ресурс и counter Semaphore-а уменьшается на единицу.

//release() - метод release() говорит о том, что мы освобождаем разрешение Semaphore-а, тем самым
// увеличивается counter у Semaphore-а на единицу. И этот метод release() всегда нужно использовать
// в блоке finally. Так как если выбросится Exception и работа потока прервётся, нам необходимо освободить
// доступ к ресурсу.

//*******************************


//Синхронизатор Semaphore.
//Рассмотрим пример, вернемся в прошлое, когда не было мобильных телефонов и люди которые находились
//вне дома, могли позвонить кому-то используя телефонные будки. Допустим у нас две телефонные будки
//и к ним подошли 5 желающих позвонить. Естественно в одно и то же время каждой будкой может пользоваться
//только один человек. Здесь мы можем использовать Semaphore, поставив ограничение на двух людей которые
//одновременно могут звонить.


public class Example_1_Semaphore {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("Vladimir", callBox);
        new Person("Oleg", callBox);
        new Person("Elena", callBox);
        new Person("Viktor", callBox);
        new Person("Marina", callBox);
    }
}

class Person extends Thread {
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox){
        this.name = name;
        this.callBox = callBox;
        this.start(); //При создании объекта Person, thread будет сразу запускаться.
    }

    @Override
    public void run(){
        try {
            System.out.println(name + " ждёт...");
            callBox.acquire();
            System.out.println(name + " пользуется телефоном");
            sleep(2000);
            System.out.println(name + " завершил звонок");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            callBox.release(); //В блоке finally обязательно нужно вызвать метод release()
        }

    }
}


