package Les_8_Multithreading.Ex8_Monitor_and_Synchronized_blocks;

public class Example_1_Monitor {
    //Монитор - это специальный механизм благодаря которому достигается корректная работа при синхронизации.
    //В Java у каждого класса и каждого объекта есть привязанная к нему сущность которая называется Монитор.
    //Монитор может иметь статус свободен или занят.
    //Именно этот механизм используется в Java, когда мы пишем ключевое слово "synchronized".
    //Таким образом когда один поток заходит в область кода, которая помечена как "synchronized",
    // то тогда монитор объекта или класса принимает состояние "Занято".
    //В одно и то же время монитор может заниматься только одним потоком. И теперь пока монитор снова не станет
    //свободным, другие потоки не смогут работать с этим кодом.

    //***Важно***
    //Следует помнить, что любая блокировка с помощью синхронизации идёт на объекте или на классе,
    // а не на каком то коде.

    //Synchronized blocks (Синхронизированные блоки) работают так же как и Synchronized methods, только
    //синхронизируют не весь код, как в методе, а лишь его часть.

//    synchronized {
//        counter++;
//    }

    //Так же хочется отметить что невозможно синхронизировать конструктор так как JVM гарантирует, что конструктор
    //может обрабатываться в одно и то же время только одним потоком.
}
