package Les_9_NIO.Ex14_Interface_Path_and_class_Files_Part1;

//В java 7 разработчики java решили изменить работу с файлами и директориями. Это
// произошло из-за того, что у класса File был ряд недостатков. Например, в нём не было
// метода copy(), который позволил бы скопировать файл из одного места в другое. И в место
// единого класса File, появились interface Path и class Files.

//Так же у нас появился класс Paths.

//Объект типа Path представляет собой путь к файлу или директории.
//Files - это utility класс, который содержит очень много статических и полезных методов
// для работы с файлами и директориями.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Ex_1_PathAndFiles {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level" +
                "\\src\\Les_9_NIO\\Ex14_Interface_Path_and_class_Files_Part1\\text15.txt");
        Path directoryPath = Paths.get("C:\\Users\\Dell\\Desktop\\M");

        //*********************************
        //Методы интерфейса Path
        //метод getFileName() - возвращает имя файла или директории которое расположено на пути filePath
        // и directoryPath.
        System.out.println("filePath.getFileName() - " + filePath.getFileName());
        System.out.println("directoryPath.getFileName() - " + directoryPath.getFileName());
        System.out.println("-----------------------------------------------------");

        //getParent() - возвращает родителя файла (папка в которой лежит файл) или директории,
        // либо null если указан относительный путь.
        System.out.println("filePath.getParent() - " + filePath.getParent());
        System.out.println("directoryPath.getParent() - " + directoryPath.getParent());
        System.out.println("-----------------------------------------------------");

        //getRoot() - возвращает Root т.е. корневую директорию откуда берёт начало наш файл или
        // директория, либо null если указан относительный путь.
        System.out.println("filePath.getRoot() - " + filePath.getRoot());
        System.out.println("directoryPath.getRoot() - " + directoryPath.getRoot());
        System.out.println("-----------------------------------------------------");

        //isAbsolute() - проверяет, работаем ли мы с абсолютным путём
        System.out.println("filePath.isAbsolute() - " + filePath.isAbsolute());
        System.out.println("directoryPath.isAbsolute() - " + directoryPath.isAbsolute());
        System.out.println("-----------------------------------------------------");

        //toAbsolutePath() - возвращает абсолютный путь нашего файла или директории.
        System.out.println("filePath.toAbsolutePath() - " + filePath.toAbsolutePath());
        System.out.println("directoryPath.toAbsolutePath() - " + directoryPath.toAbsolutePath());
        System.out.println("-----------------------------------------------------");

        //Зная абсолютны путь можно применить методы getParent() и getRoot() с помощью methodChaining.
        System.out.println("filePath.toAbsolutePath().getParent() - "
                + filePath.toAbsolutePath().getParent());
        System.out.println("filePath.toAbsolutePath().getRoot() - "
                + filePath.toAbsolutePath().getRoot());
        System.out.println("-----------------------------------------------------");

        //**** resolve() - объединяет два пути в один, например абсолютный путь директории и относительный
        //путь к файлу
        System.out.println("directoryPath.resolve(filePath) - "
                + directoryPath.resolve(filePath));
        System.out.println("-----------------------------------------------------");

        //**** relativize() - возвращает относительный путь относительно какого-то другого пути.
        // В нашем случае относительный путь anotherPath относительно пути directoryPath.
        Path anotherPath = Paths.get("C:\\Users\\Dell\\Desktop\\M\\N\\Z\\text20.tht");
        System.out.println("directoryPath.relativize(anotherPath) - "
                + directoryPath.relativize(anotherPath));
        System.out.println("-----------------------------------------------------");


        //****************************
        //Методы класса Files
        //exists() - существует ли файл или директория по указанному пути
        //createFile() - создаёт файл по указанному пути
        //createDirectories() - создаёт директорию по указанному пути

        if (!Files.exists(filePath)){  //если файл text15.txt по указанному пути не существует
            Files.createFile(filePath); //создадим наш файл - text15.txt
        }

        if (!Files.exists(directoryPath)){  //если директория М по указанному пути не существует
            Files.createDirectories(directoryPath); //создадим директорию М
        }
        System.out.println("-----------------------------------------------------");

        //Далее можем проверить наши права на файл
        //Files.isReadable - можем ли читать
        //Files.isWritable - можем ли писать в файл
        //Files.isExecutable - можем ли запускать файл
        System.out.println("Files.isReadable(filePath) - "
                + Files.isReadable(filePath));
        System.out.println("Files.isWritable(filePath) - "
                + Files.isWritable(filePath));
        System.out.println("Files.isExecutable(filePath) - "
                + Files.isExecutable(filePath));
        System.out.println("-----------------------------------------------------");

        //Files.isSameFile(path1, path2) - проверяет, ссылаются ли оба пути указанные в параметрах
        // на один и тот же файл.

        Path filePath2 = Paths.get("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level" +
                "\\src\\Les_9_NIO\\Ex14_Interface_Path_and_class_Files_Part1\\text15.txt");

        System.out.println("Files.isSameFile(filePath, filePath2) - "
                + Files.isSameFile(filePath, filePath2));
        System.out.println("-----------------------------------------------------");

        //size(filePath) - возвращает размер нашего файла в байтах.
        System.out.println("Files.size(filePath) - "
                + Files.size(filePath));
        System.out.println("-----------------------------------------------------");

        // getAttribute(filePath, "creationTime")- информация об атрибуте файла.
        //в параметрах путь к файлу и название атрибута, которое можно загуглить.
        System.out.println("Files.getAttribute(filePath, \"creationTime\") - "
                + Files.getAttribute(filePath, "creationTime"));
        System.out.println("Files.getAttribute(filePath, \"size\") - "
                + Files.getAttribute(filePath, "size"));
        System.out.println("-----------------------------------------------------");

        //readAttributes(filePath, "*") - Если мы хотим рассмотреть все атрибуты
        Map<String, Object> attributes = Files.readAttributes(filePath, "*");
        for (Map.Entry<String, Object> entry : attributes.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
