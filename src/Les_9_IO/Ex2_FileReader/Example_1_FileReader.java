package Les_9_IO.Ex2_FileReader;

import java.io.FileReader;
import java.io.IOException;

public class Example_1_FileReader {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level\\src\\Les_9_IO_And_NIO" +
                    "\\Ex1_Introduction_to_Streams_FileWriter\\text1.txt");
            int character;
            //Метод read() читает наш файл посимвольно и помещает прочитанный символ в переменную character.
            //Метод read() возвращает int. Это нужно для того что бы мы могли понять когда наступает конец файла.
            //Когда наступит конец файла метод read() вернет нам -1.
            while ((character = reader.read()) != -1){
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}
