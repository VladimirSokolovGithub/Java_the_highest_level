package Les_9_IO.Ex10_Class_File;

//Класс File позволяет управлять информацией о файлах и директориях.
//Класс File напрямую не работает с нашими потоками. Его задачей является управление информацией
//о файлах и каталога.

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Example_1_FileClass {
    public static void main(String[] args) throws IOException {
        //Самый часто используемый конструктор для создания файлов.
        File file = new File("C:\\Users\\Dell\\IdeaProjects" +
                "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex10_Class_File" +
                "\\text11.txt");

        File folder = new File("C:\\Users\\Dell\\Desktop\\A");

        //1. метод getAbsolutePath() - возвращает абсолютный путь файла.
        System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath() " + folder.getAbsolutePath());
        System.out.println("-----------------------------------------------------");

        //2. метод isAbsolute() - проверяет наш путь абсолютный или нет.
        System.out.println("file.isAbsolute() " + file.isAbsolute());
        System.out.println("folder.isAbsolute() " + folder.isAbsolute());
        System.out.println("-----------------------------------------------------");

        //3. метод isDirectory() - проверяет, является ли наш объект File директорией.
        System.out.println("file.isDirectory() " + file.isDirectory());
        System.out.println("folder.isDirectory() " + folder.isDirectory());
        System.out.println("-----------------------------------------------------");

        File file2 = new File("C:\\Users\\Dell\\Desktop\\A\\test20.txt");
        File folder2 = new File("C:\\Users\\Dell\\Desktop\\B");

        //4. метод exists() - проверяет наш объект File существует или нет.
        System.out.println("file.exists() " + file.exists());
        System.out.println("folder.exists() " + folder.exists());
        System.out.println("file2.exists() " + file2.exists());
        System.out.println("folder2.exists() " + folder2.exists());
        System.out.println("-----------------------------------------------------");

        //5. метод createNewFile() - создаёт новый файл, путь и название которого указаны в параметре.
        //6. метод mkdir() - make directory - создаёт новую папку, путь и название которой указаны в параметре.
        System.out.println("file2.createNewFile() " + file2.createNewFile());
        System.out.println("folder2.mkdir() " + folder2.mkdir());
        //если мы попытаемся создать файл который уже создан, то будет false так как такой файл уже существует
        System.out.println("file.createNewFile() " + file.createNewFile());
        System.out.println("-----------------------------------------------------");

        //7. метод length() - возвращает размер файла или папки
        System.out.println("file2.length() " + file2.length());
        //для директории метод folder.length() - не покажет нам размер папки, а вернёт ноль. Так как класс
        //File не предоставляет нам такой функциональности. Мы должны заходить в папку, читать размеры файлов
        //в этой папке и складывать эти размеры.
        System.out.println("folder.length() " + folder.length());
        System.out.println("-----------------------------------------------------");

        //8. метод delete() - удаляет файлы и папки.
        System.out.println("folder.delete() " + folder.delete()); //Это папка A - и удалить мы её не сможем,
                                                            // так как она не пуста и содержит файл test20.txt
        System.out.println("folder2.delete() " + folder2.delete());
        System.out.println("file2.delete() " + file2.delete());
        System.out.println("-----------------------------------------------------");

        //9. метод listFiles() - возвращает массив типа File
        File[] files = folder.listFiles();
        System.out.println(Arrays.toString(files));
        System.out.println("-----------------------------------------------------");

        File file3 = new File("C:\\Users\\Dell\\Desktop\\A\\test2.txt");

        //10. метод isHidden() - проверяет скрыта ли наша папка
        System.out.println("file3.isHidden() " + file3.isHidden());

        //11. метод canRead() - проверка файла на чтение
        System.out.println("file3.canRead() " + file3.canRead());

        //12. метод canWrite() - проверка файла на запись в этот файл
        System.out.println("file3.canWrite() " + file3.canWrite());

        //13. метод canExecute() - проверка файла на выполнение файла - на запуск этого файла
        System.out.println("file3.canExecute() " + file3.canExecute());
    }
}
