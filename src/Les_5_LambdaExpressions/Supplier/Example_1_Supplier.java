package Les_5_LambdaExpressions.Supplier;
import java.util.ArrayList;
import java.util.function.Supplier;
public class Example_1_Supplier {
    //Продолжаем рассматривать функциональные интерфейсы из пакета java.util.function
    //интерфейс Supplier, переводится как поставщик, у него есть метод T get().
    //метод T get() не принимает параметров и возвращает объект типа T, т.е объект того типа,
    //который нам нужен. Т.е. интерфейс Supplier возвращает нам нужные объекты.

    //Создадим метод, который будет создавать нам три машины, помещать всё это в ArrayList и возвращать
    //этот ArrayList нам. А какие машины мы будем создавать, мы будем прописывать при помощи лямбда выражений
    //из метода main

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier){
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            al.add(carSupplier.get());
        }
        return al;
    }

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("Nissan Tiida", "Silver metalic", 1.6));
        System.out.println("Our cars: " + ourCars);
    }
}

