package Les_4_NestedClasses.Anonymous_inner_class;

public class AnonymousClass {

    private int x = 5;


    public static void main(String[] args) {

        //Таким образом создал какой-то класс, объектом которого является abc. Класс имплементирует интерфейс
        // Math и оверрадит его единственный метод doOperation(), и всё это написано в одном statement-е.

        Math abc = new Math(){
            //так же сюда в анонимный класс можно добавить переменные, методы. Без проблем.
            int c = 10;
            void def(){}

            @Override
            public int doOperation(int a, int b){
                AnonymousClass ac = new AnonymousClass();
                return a + b + ac.x;
            }
        };

        //создадим ещё анонимный класс
        Math abc2 = new Math(){
            @Override
            public int doOperation(int a, int b){
                return a * b;
            }
        };

        System.out.println(abc.doOperation(3, 6));
        System.out.println(abc2.doOperation(3, 6));
    }
}

//interface Math{
//    int doOperation(int a, int b);
//}

//Так же это можно проделывать не только с интерфейсами, но и с классами.
//Тогда бы мы говорили, что какой-то анонимный класс extends (экстендит) класс Math,
//оверрадит его метод и в итоге мы имеем объект abc2.

class Math{
    int doOperation(int a, int b){
        return a / b;
    }
}

//Анонимный класс используется тогда, когда нам на ходу нужно создать объект какого либо класса или интерфейса,
//который имплементит или экстендит его и оверрадит (видоизменяет) его метод. И этим всем нам нужно воспользоваться
//один раз.
