package Les_9_NIO.Ex15_Interface_Path_and_class_Files_Part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ex_3_PathAndFiles {
    public static void main(String[] args) throws IOException {
        //С помощью класса Files мы можем записывать информацию в файл и читать информацию из файла.

        //*** метод Files.write(path, byte_array) - метод возвращает лист String

        Path filePath = Paths.get("test10.txt");
//        Files.createFile(filePath);
//        String dialog = "-Hello!\n-Hello!\n-How are you?\n-I am fine! How are you?\n-Super!";
//        Files.write(filePath, dialog.getBytes()); //переводим наш диалог в массив байтов.

        //*** метод Files.readAllLines(path) -
        List<String> stringList = Files.readAllLines(filePath);
        for (String s : stringList){
            System.out.println(s);
        }
    }
}
