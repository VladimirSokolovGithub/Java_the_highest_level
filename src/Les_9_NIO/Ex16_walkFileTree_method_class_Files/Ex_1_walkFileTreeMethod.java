package Les_9_NIO.Ex16_walkFileTree_method_class_Files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Ex_1_walkFileTreeMethod {
    public static void main(String[] args) throws IOException {
        //Во множестве ситуаций, нам нужно совершать обход по дереву файлов, например когда мы ищем
        //какой-то файл или папку. Или когда мы хотим удалить папки или другие файлы, мы должны прогуляться
        //по дереву, сначала удалить все внутренние файлы и папки и только после этого мы сможем удалить
        //саму папку тоже. Или же когда мы хотим скопировать папку с каким-то содержимым, мы должны
        // прогуляться по дереву файлов и скопировать всё содержимое файлов вместе с папкой.

        //*** метод Files.walkFileTree(Path start, FileVisitor visitor) - используется для обхода
        //дерева файлов. Параметр Path start - это путь с которого мы начинаем обход.
        // FileVisitor - второй параметр, это интерфейс имплементируя который, мы будем описывать
        // всю логику обхода дерева файлов.

        //Интерфейс FileVisitor - содержит 4 метода:
        //(смотрим в презентацию 1_Files.walkFileTree method)
        //1. preVisitDirectory - описываем что мы будем делать при входе в директорию.
        //2. visitFile - описываем что мы будем делать с конкретным файлом(например копировать и т.д.).
        //3. postVisitDirectory - поработали со всеми файлами папки, что нам дальше делать.
        //4. visitFileFailed - файл не доступен (например нет прав доступа).
        //Интерфейс FileVisitor работает с джинериками.

        //Так же есть класс SimpleFileVisitor - который уже имплементировал интерфейс FileVisitor и
        //реализовал все его 4 метода. Т.е. мы можем экстендить его и оверайдить только один нужный
        //нам метод, если нам не нужны все 4.

        //***Пример1 - выведем информацию о всех файлах и директориях внутри папки X в консоль.

        Path path = Paths.get("C:\\Users\\Dell\\Desktop\\X");
        Files.walkFileTree(path, new MyFileVisitor());

    }
}

class MyFileVisitor implements FileVisitor<Path> {

    //Все эти 4 метода возвращают FileVisitResult - это enum и он содержит 4 значения:
    //CONTINUE, TERMINATE, SKIP_SUBTREE, SKIP_SIBLINGS.

    //метод preVisitDirectory()
    //Когда мы зашли в первую директорию и перед тем как мы поработали со всеми её файлами, вызывается
    //метод preVisitDirectory(). После вызова этого метода и срабатывания когда в теле этого метода, мы
    //должны сказать программе, что мы делаем дальше. И у нас есть 4 варианта, что мы можем делать
    // дальше (смотрим в презентацию 2_enum FileVisitResult).


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    //метод visitFile()
    //Когда исследуется какой-то файл мы будем выводить информацию в консоль об имени файла и продолжать
    //дальше.

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("file name: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    //метод visitFileFailed()
    //Если будет какая-то ошибка при изучении файла, будем выводить сообщение в консоль и будем
    //прекращать обход по файлам.

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error while visiting file: " + file.getFileName());
        return FileVisitResult.TERMINATE;
    }

    //метод postVisitDirectory()
    //Будем выводить информацию в консоль, что мы выходим из директории и говорить - продолжай работу дальше.

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from directory: " + dir);
        return FileVisitResult.CONTINUE;
    }
}
