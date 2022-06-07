package Les_9_IO_And_NIO.Ex3_Try_with_resources;

import java.io.FileWriter;
import java.io.IOException;

public class Example_1_TryWithResources {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно, —\n" +
                "Вот последний секрет из постигнутых мной.\n";

        String s = "\nHello";

        //После слова try мы можем открыть круглые скобки и записать туда ресурсы, которые после срабатывания нашего
        //кода будут автоматически закрыты. Когда ресурс один, после него можно не ставить точку с запятой.
        //Далее всё делается, как и в обычном try-catch, в фигурных скобках пишется блок try, затем catch, finally.
        //В данном случае нам блок finally уже не нужен так как ресурс writer закроется автоматически.
        //На самом деле после компиляции этого кода, java компилятор внутренне переведет этот Try With Resources
        //в обычный try и finally блок.

        try(FileWriter writer = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level\\src\\Les_9_IO_And_NIO" +
                "\\Ex1_Introduction_to_Streams_FileWriter\\text1.txt", true)) {
            writer.write(rubai);
            writer.write(s);
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
