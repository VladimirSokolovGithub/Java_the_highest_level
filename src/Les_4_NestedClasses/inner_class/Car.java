package Les_4_NestedClasses.inner_class;

public class Car {
    String color;
    private static int doorCount;
    Engine engine;

    //1. первый вариант конструктора, для создания объекта inner класса

//    public Car(String color, int doorCount, int horsePower) {
//        this.color = color;
//        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower); //здесь this наш текущий объект класса Car, точка новый мотор
//                                                    //и передаём в качестве параметра horsePower.
//        //Таким образом в создании объекта inner класса всегда задействован объект внешнего класса.
//    }

    //2. Второй вариант конструктора, для создания объекта inner класса

    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
        //Мы не можем обратиться к переменной(полю) inner класса из внешнего класса, пока не создадим его объект.
        //При этом внутри внешнего класса Car мы можем создать объект inner класса обычным способом. Но только внутри.
        Engine e = new Engine(200);
        System.out.println(e.horsePower);
    }

    public void setEngine(Engine engine) {
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

    //************************************
    //inner класс может содержать только non static элементы, за исключением final static КОНСТАНТ.

    //inner класс может обращаться к private переменным внешнего класса без создания объекта внешнего класса.

    //inner класс может обращаться к static переменным внешнего класса без создания объекта внешнего класса.

    //inner класс может extends and implements, всё будет без проблем работать.

    //inner класс может быть final или abstract, без проблем.

    //Так же inner классы могут иметь внутри себя свои inner классы, но это не очень хорошая практика
    //это понижает читаемость кода.

    //    private class Engine { //inner class Engine так же может быть private и будет виден внутри класса Car
                            //но не будет виден снаружи
    public class Engine {
        private int horsePower;
        public final static String NAME = "ZVER";

        public Engine(int horsePower) {
            System.out.println(doorCount); //обращение к private static переменной внешнего класса Car
            this.horsePower = horsePower;
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
        //1.первый вариант
//        Car car = new Car("black", 4, 300);
        //Таким образом мы создали объект класса Engine в конструкторе внешнего класса Car с помощью текущего
        //объекта класса Car. Мы не сможем создать объект внутреннего inner класса без объекта внешнего класса.
//        System.out.println(car);

        //2.второй вариант

        Car car2 = new Car("red", 4);
        Car.Engine engine = car2.new Engine(300);
        car2.setEngine(engine);
        System.out.println(engine);
        System.out.println(car2);

        //3.третий вариант
        //Можно одновременно создать и внешний класс и внутренний класс, так писать можно, но тогда у нас
        //теряется ссылка на объект Car и остается только ссылка на мотор, но какой машине принадлежит
        //этот мотор, становится неизвестно.
        Car.Engine engine2 = new Car("yellow", 4).new Engine(200);
    }
}

