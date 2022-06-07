package Les_9_IO_And_NIO.Ex3_Try_with_resources;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example_2_TryWithResources {
    public static void main(String[] args) throws IOException {
        //Пример с двумя ресурсами, которые обязательно нужно разделять точкой с запятой.
        //Из-за того, что Try With Resources всё-таки внутренне создаст finally блок, мы можем
        // catch блок здесь не писать, так как синтаксически мы можем использовать try блок как с
        // catch блоком отдельно, так и с finally блоком без блока catch. Но обязательно в сигнатуре метода
        // он должен выбрасывать Exception. Получается что у нас есть код, где есть только один Try With Resources
        // блок. Но просто try блок естественно один быть не может.
        try (FileReader reader = new FileReader("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level\\src\\Les_9_IO_And_NIO" +
                "\\Ex1_Introduction_to_Streams_FileWriter\\text1.txt");
             FileWriter writer = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level\\src\\Les_9_IO_And_NIO" +
                     "\\Ex1_Introduction_to_Streams_FileWriter\\text1.txt", true);) {
            int character;
            while ((character = reader.read()) != -1){
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done!");

        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
