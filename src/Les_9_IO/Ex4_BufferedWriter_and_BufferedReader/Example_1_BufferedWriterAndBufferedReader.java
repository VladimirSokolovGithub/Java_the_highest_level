package Les_9_IO.Ex4_BufferedWriter_and_BufferedReader;

import java.io.*;

//Буферизация - это процесс загрузки части файла происходящей во время потоковой передачи, например музыки или
// видео до их воспроизведения. То есть загружается часть файла, начинается его воспроизведение и затем уже
// в процессе воспроизведения загружается оставшаяся часть файла.

//BufferedWriter и BufferedReader это обёртки, они оборачивают FileWriter и FileReader, получая их в
//своих параметрах(в свой конструктор) и добавляют функциональность буферизации.

//Ниже в примере скопируем содержимое нашего файла text1.txt из Ex1 в новый файл text2.txt. Так же
//будем использовать Try With Resources.

//У BufferedReader есть метод readLine() - он читает сразу строчку.
public class Example_1_BufferedWriterAndBufferedReader {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dell\\IdeaProjects" +
                "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex1_Introduction_to_Streams_FileWriter\\text1.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\IdeaProjects" +
                    "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex4_BufferedWriter_and_BufferedReader\\text2.txt"))
        ) {
//           int character;
//           while ((character = reader.read()) != -1){
//               writer.write(character);
//           }
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.write('\n'); //так как метод readLine() не скопировал символы перевода строки на новую строчку,
                                        //то добавим их с помощью кода, отдельно поместим его после каждой строки.
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
