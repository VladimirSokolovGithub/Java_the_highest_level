package Les_9_IO_And_NIO.Ex8_Serialization_Part2.serialization1;

import Les_9_IO_And_NIO.Ex7_Serialization_Part1.serialization1.Car;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx1 {
    public static void main(String[] args) {
        Car car = new Car("Nissan Tiida", "white");
//        Employee2 employee2 = new Employee2("Uliya"
//                , "Sokolova"
//                , "IT"
////                ,42
//                ,500, car);
        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\Dell\\IdeaProjects" +
                        "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex8_Serialization_Part2" +
                        "\\serialization1\\employees3.bin")
        )) {
//            outputStream.writeObject(employee2);
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
