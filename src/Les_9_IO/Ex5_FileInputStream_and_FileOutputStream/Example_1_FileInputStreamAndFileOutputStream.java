package Les_9_IO.Ex5_FileInputStream_and_FileOutputStream;

// Для работы с бинарными файлами у нас есть специальные streams, они называются
// FileInputStream and FileOutputStream.
// Рассмотрим пример из предыдущего урока и попытаемся скопировать картинку используя стримы
// предназначенные для работы с читабельным для человека текстом.
// Вро де бы программа отработала, но при попытке открыть новую картинку, файл не открывается и возникают проблемы
// в связи с тем, что картинка не была нормально скопирована. Таким образом мы не можем использовать стримы
// предназначенные для работы с текстовыми файлами для работы с бинарными файлами.

import java.io.*;

public class Example_1_FileInputStreamAndFileOutputStream {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dell\\Desktop\\JavaJpeg.jpeg"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\IdeaProjects" +
                    "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex5_FileInputStream_and_FileOutputStream" +
                    "\\JavaJpeg2.jpeg"))
        ) {
           int character;
           while ((character = reader.read()) != -1){
               writer.write(character);
           }

//            String line;
//            while ((line = reader.readLine()) != null){
//                writer.write(line);
//                writer.write('\n'); //так как метод readLine() не скопировал символы перевода строки на новую строчку,
//                //то добавим их с помощью кода, отдельно поместим его после каждой строки.
//            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
