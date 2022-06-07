package Les_8_Multithreading.Ex20_Exchanger_synchronizer;


//Синхронизатор Exchanger<V> - нужен для обмена информацией между двумя потоками. Оба потока получат
// информацию друг от друга одновременно. Exchanger<V> использует generics.
//Для обмена информацией нужен метод - exchange()

//Первый поток захотел поделиться информацией, вызвав метод exchange() он заблокируется до тех пор,
// пока второй поток тоже не будет готов поделится информацией. Только когда второй поток тоже посылает
//необходимую информацию и вызывает метод exchange(), происходит обмен информацией и естественно
// первый поток выходит из блокировки.

//Информация которой они обмениваются должна быть одного типа данных.


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

//Рассмотрим Exchanger на примере игры - камень, ножницы, бумага
public class Example_1_Exchanger {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.SCISSORS);
        friend1Action.add(Action.PAPER);
        friend1Action.add(Action.SCISSORS);

        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.PAPER);
        friend2Action.add(Action.STONE);
        friend2Action.add(Action.STONE);

        new BestFriend("Artem", friend1Action, exchanger);
        new BestFriend("Maksim", friend2Action, exchanger);
    }
}

enum Action{
    STONE, SCISSORS, PAPER;
}

class BestFriend extends Thread{
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger){
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction, Action friendsAction){
        if ((myAction == Action.STONE && friendsAction == Action.SCISSORS)
        || (myAction == Action.SCISSORS && friendsAction == Action.PAPER)
        || (myAction == Action.PAPER && friendsAction == Action.STONE)) {
            System.out.println(name + " WINS!!!");
        }
    }

    //Как мы получаем ответ от друга с помощью Exchanger.
    //Когда мы вызываем метод exchange() он возвращает нам информацию полученную от второго потока.
    //Т.е. в параметр exchange() мы передаём свою информацию, а в output-е получаем информацию от второго потока.
    @Override
    public void run(){
        Action reply; //ответ друга
        for (Action action : myActions){
            try {
                reply = exchanger.exchange(action); //С помощью Exchanger и метода exchange(action), в параметр
                //передаём свой action и в output-е метода exchange(action) получаю ответ. Если друг пока не готов
                //показать Бумагу, ножницы или камень, мой поток здесь заблокируется и пока мой друг не вызовет
                //тоже метод exchange() со своим action, мой поток будет в блокировке. А как только друг вызовет
                //метод exchange(), мы получим в output-е его значение и присвоим в переменную reply.
                whoWins(action, reply);
                sleep(2000); //спим 2 сек.после первой игры.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}