package Les_9_NIO.Ex15_Interface_Path_and_class_Files_Part2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex_2_PathAndFiles {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("text15.txt");
        Path directoryPath = Paths.get("C:\\Users\\Dell\\Desktop\\M");
        Path directoryBPath = Paths.get("C:\\Users\\Dell\\Desktop\\B");

        //*** метод copy() - копирует файл в директорию directoryPath и можно назначить ему новое имя.

        //скопирует файл text15.txt в папку M.
        // Метод resolve объединит пути добавив в путь имя файла к папке M - C:\Users\Dell\Desktop\M\text15.txt

        //Если после создания файла ещё раз вызвать этот метод то выйдет FileAlreadyExistsException так,
        // как такой файл уже существует. Если мы захотим перезаписать имеющийся у нас файл, то нам нужно
        // использовать дополнительный параметр метода copy() - StandardCopyOption.REPLACE_EXISTING.
        //т.е. если такой файл есть его нужно заменить.

//        Files.copy(filePath, directoryPath.resolve(filePath));
//        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);

        //так же можно в метод resolve("test16.txt") просто добавить название нового файла
//        Files.copy(filePath, directoryPath.resolve("test16.txt"));

        //Копирование папок(директорий).
        //Если папка будет с файлом, то скопируется пустая папка без содержимого. Мы не можем
        // с помощью метода copy() скопировать папку вместе с её содержимым. Если мы хотим скопировать
        // и содержимое папки, то сначало нужно вручную скопировать папку, а потом отдельно и её содержимое.
//        Files.copy(directoryBPath, directoryPath.resolve("B"));
//        System.out.println("Done!");


        //*** метод move() - перемещает скопированный файл с одного места на другое, не оставляя старый файл
        // на прежнем месте, а удаляя его. Т.е. это как вырезать и вставить.


//        Files.move(filePath, directoryPath.resolve("text15.txt"));

        //*** метод move() - так же может переименовывать файлы и директории. Для этого мы должны исходный
         //файл переместить в эту же папку, но уже с другим именем. Таким образом переименовать можно только
        //внутри одной и той же папки.
//        Files.move(Paths.get("text10.txt"), Paths.get("text11.txt"));


        //*** метод delete() - удаляет файлы и папки.
//        Files.delete(Paths.get("text11.txt"));

        //Попробуем удалить папку M - она не пустая.
        //Выброситься DirectoryNotEmptyException так как мы не можем удалить папку, которая не пуста.
        //Для удаления не пустой папки сначала нужно удалить из неё все файлы.
        //Пустая папка удалится без проблем.

//        Files.delete(directoryPath);






    }
}
