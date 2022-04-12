package Les_4_NestedClasses.static_nested_class;

public class Car {
    String color;
    int doorCount;
    Engine engine;
    private static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    void method(){
        System.out.println(Engine.countOfEngine); //можем использовать static переменную во внешнем классе
        Engine engine = new Engine(200);
//        Car.Engine engine2 = new Car.Engine(200);//такой синтаксис за пределами класса Car
        System.out.println(engine.horsePower);// для использования переменных nested static class Engine во
                                                //внешнем классе нужно сначала создать объект этого класса
    }

    //Внутри класса можно так же создать interface
    interface I{}
    //Внутри интерфейса если бы он был внешним можно создать interface и class

    //**********************************************************
    //nested static class Engine внутри внешнего класса Car
    //nested static class Engine можно использовать как обычный внешний класс, что приведено в примере
    // в классе Test, т.е. его можно создать без создания объекта внешнего класса.

    //Если применить модификатор к nested классу Engine применить модификатор private, то объект
    //класса Engine во внешнем классе Test уже создать будет нельзя.

    //Применив модификатор final мы не сможем наследоваться от этого класса

    //Применив модификатор abstract мы не сможем создать объект этого класса

    //class Engine может наследоваться от других классов

    //Так же другие классы могут наследоваться от класса Engine (extends Car.Engine), тогда в классе
    //Engine нужен дефолтный конструктор или вызвать в классе наследнике конструктор Engine с помощью
    //ключевого слова super.

    //nested static class Engine может содержать static элементы и non static элементы.

    //nested static class Engine может обращаться к private и не private элементам внешнего класса,
    // но только к static filed. Т.е. мы не можем обращаться к нестатическим элементам из статического
    //контекста.


    public static class Engine extends EngineDrawing {
        private int horsePower;
        static int countOfEngine;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
            countOfEngine++;
            System.out.println(a); //можем обращаться к static переменным внешнего класса
//            System.out.println(doorCount); //не можем обращаться к non static переменным внешнего класса
        }

        @Override
        public String toString() {
            return "My Engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        //Для создания объекта нашего nested static класса необходимо указать внешний класс в котором находится
        //статический вложенный класс.
        Car.Engine engine = new Car.Engine(256);
        System.out.println(engine);
        Car car = new Car("red", 2, engine);
        System.out.println(car);
    }
}

class EngineDrawing{
}

class BikeEngine extends Car.Engine {
    BikeEngine(){
        super(200);
    }
}
