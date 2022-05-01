package Les_5_LambdaExpressions.Consumer;

import Les_5_LambdaExpressions.Supplier.Car;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Example_1_Consumer {
    //Рассмотрим интерфейс Consumer<T> - потребитель, он противоположен интерфейсу Supplier<T>,
    //он ничего не возвращает, он принимает какой-то объект типа T в своем методе void accept(T t).

    //Придумаем задачку, создам метод, который будет менять мою машину, как её менять я буду решать при вызове
    //этого метода при помощи лямбда выражения.

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier){
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            al.add(carSupplier.get());
        }
        return al;
    }

    //Вот такой метод у нас получился, а что делать уже с этой машиной я буду задавать при использовании этого
    //метода в методе main.
    public static void changeCar(Car car, Consumer<Car> carConsumer){
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("Nissan Tiida", "Silver metalic", 1.6));
        System.out.println("Our cars: " + ourCars);

        //Ниже пример с интерфейсом Consumer<T> и методом changeCar()
        changeCar(ourCars.get(0)
                , car -> {car.color = "red"; car.engine = 2.4;
                    System.out.println("upgraded car: " + car);} );

        System.out.println("Our cars: " + ourCars);
    }

}
