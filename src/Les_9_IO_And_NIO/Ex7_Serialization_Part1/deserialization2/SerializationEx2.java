package Les_9_IO_And_NIO.Ex7_Serialization_Part1.deserialization2;

import Les_9_IO_And_NIO.Ex7_Serialization_Part1.serialization1.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationEx2 {
    public static void main(String[] args) {
        Employee bestEmployee;
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\Dell\\IdeaProjects" +
                        "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex7_Serialization_Part1" +
                        "\\serialization1\\employees2.bin")
        )) {
            bestEmployee = (Employee) inputStream.readObject();
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
