package Les_9_IO_And_NIO.Ex7_Serialization_Part1.serialization1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//После запуска этой программы у нас выброситься NotSerializableException.
//Это означает, что чтобы объект класса мы могли сериализировать, он должен имплементировать интерфейс
//Serializable, т.е. наш клас Employee должен имплементировать интерфейс Serializable. Этот интерфейс
//не содержит ни одного метода - это интерфейс маркер(метка). Таким образом мы помечаем наш класс
//Employee теперь может сериализироваться. В предыдущем примере у нас всё сработало так как мы использовали
//ArrayList, а он имплементирует интерфейс Serializable, и элементы ArrayList, такие как, String тоже
//имплементирует Serializable.

//Далее добавим в нашу программу машину. Но после запуска мы опять увидим NotSerializableException.
//Это произошло потому, что все объекты, которые содержаться в объекте класса Employee, должны имплементировать
//интерфейс Serializable. Т.е мы хотим сделать сериализацию объекта класса Employee, поэтому все поля
//в классе Employee, должны уметь быть сериализированны. Таким образом класс Car так же должен имплементировать
//интерфейс Serializable, для того чтобы наш работник был благополучно записан в файл.

public class SerializationEx2 {
    public static void main(String[] args) {
        Car car = new Car("Nissan Tiida", "white");
        Employee employee = new Employee("Uliya", "IT", 42, 500, car);
        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\Dell\\IdeaProjects" +
                        "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex7_Serialization_Part1" +
                        "\\serialization1\\employees2.bin")
        )) {
            outputStream.writeObject(employee);
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
