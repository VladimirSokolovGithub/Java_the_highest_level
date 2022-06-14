package Les_9_NIO.Ex17_The_walkFileTree_method_Copying_a_directory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Ex_1_CopyFileTree {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\Dell\\Desktop\\X");
        Path destination = Paths.get("C:\\Users\\Dell\\Desktop\\CopyHere");
        Files.walkFileTree(source, new MyFileVisitor2(source, destination));
        System.out.println("Done!");
    }
}

//Для копирования не пустых папок, мы будем гулять по дереву, а для этого нам нужно имплементировать
//интерфейс FileVisitor или экстендить клас SimpleFileVisitor.

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
    Path source; //откуда копируем
    Path destination; //куда копируем

    public MyFileVisitor2(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(dir));
        Files.copy(dir, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(file));
        Files.copy(file, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}