package Les_9_IO.Ex7_Serialization_Part1.deserialization2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        List<String> employees;
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\Dell\\IdeaProjects" +
                        "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex7_Serialization_Part1" +
                        "\\serialization1\\employees1.bin"))
        ) {
            //для чтения информации из файла мы вызываем на inputStream метод readObject(). Мы должны
            //сохранить результат работы нашего inputStream.readObject() в наш List работников, но так
            //как readObject() возвращает Object нам придется использовать кастинг и привести всё к
            //типу ArrayList
            employees = (ArrayList)inputStream.readObject();
            System.out.println("Done!");
            System.out.println(employees);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
