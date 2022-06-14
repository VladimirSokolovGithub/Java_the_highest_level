package Les_9_IO.Ex7_Serialization_Part1.serialization1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Vladimir");
        employees.add("Artem");
        employees.add("Maksim");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\Dell\\IdeaProjects" +
                        "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex7_Serialization_Part1" +
                        "\\serialization1\\employees1.bin"))
        ) {
            outputStream.writeObject(employees); //с помощью метода writeObject(employees) записываем наш
                                                 //List с работниками в наш файл employees1.bin
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
