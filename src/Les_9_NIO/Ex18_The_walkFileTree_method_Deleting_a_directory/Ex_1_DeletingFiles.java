package Les_9_NIO.Ex18_The_walkFileTree_method_Deleting_a_directory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Ex_1_DeletingFiles {
    public static void main(String[] args) throws IOException {
        //Когда мы использовали метод delete() класса Files, мы могли удалить только определенные файлы и пустые папки.
        //Мы не могли удалять папки с содержимым. Но благодаря методу walkFileTree() мы можем обойти содержимое папки,
        //которую хотим удалить и удалить сначала всё содержимое, а затем удалить и папку тоже.

        Path path = Paths.get("C:\\Users\\Dell\\Desktop\\CopyHere");
        Files.walkFileTree(path, new MyFileVisitor3());

    }
}

class MyFileVisitor3 extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Delete name: " + file.getFileName());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Delete directory: " + dir.getFileName());
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}