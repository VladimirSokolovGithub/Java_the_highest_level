package Les_9_IO.Ex8_Serialization_Part2.deserialization2;

import Les_9_IO.Ex8_Serialization_Part2.serialization1.Employee2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationEx1 {
    public static void main(String[] args) {
        Employee2 bestEmployee;
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\Dell\\IdeaProjects" +
                        "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex8_Serialization_Part2" +
                        "\\serialization1\\employees3.bin")
        )) {
            bestEmployee = (Employee2) inputStream.readObject();
            System.out.println("Done!");
            System.out.println(bestEmployee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
