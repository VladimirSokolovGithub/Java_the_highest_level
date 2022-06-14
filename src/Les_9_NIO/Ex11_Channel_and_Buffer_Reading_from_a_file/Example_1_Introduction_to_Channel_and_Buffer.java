package Les_9_NIO.Ex11_Channel_and_Buffer_Reading_from_a_file;

//В этом уроке поговорим о пакете java.nio. - new input output
//Рассмотрим интерфейс Pass и клас Files, который предоставляет больше возможностей, чем класс File из
// пакета java.io.
//Так же поговорим о другом подходе к записи в файл и чтению из файла.
//В пакете io мы рассмотрели как можно работать с текстовыми файлами и бинарными файлами используя стримы.
//В пакете nio посмотрим как будем использовать Buffers и Channels для чтения и записи в файл.
//С помощью Channel и Buffer мы можем работать не только с файлами, но и например с сетью тоже.
//Пакеты io и nio очень богатые API и здесь мы рассмотрим общие базовые сведения об их функционале.

//Channel всегда либо читает информацию из файла в Buffer, либо записывает информацию из Buffer в файл.
//Buffer это просто блок памяти в который мы можем записывать информацию и читать информацию из него.
//Используя Buffer мы можем читать информацию из него, затем возвращаться к уже прочитанной информации,
//опять её просматривать, т.е. гулять по буферу туда-сюда, чего мы не могли делать в стримах пакета io.

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Example_1_Introduction_to_Channel_and_Buffer {
    public static void main(String[] args) {
        //Класс RandomAccessFile позволяет читать информацию из любого места в файле и записывать информацию
        // в любое место файла.
        try(RandomAccessFile file = new RandomAccessFile("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level" +
                "\\src\\Les_9_NIO\\Ex11_Channel_and_Buffer_Reading_from_a_file\\text10.txt", "rw");
            //Теперь из самого файла мы получаем канал для связи с этим файлом.
            FileChannel channel = file.getChannel(); //FileChannel это тоже ресурс, поэтому можем
                                                     // поместить его в блок try with resources
        ){
            //теперь будем читать из файла
            ByteBuffer buffer = ByteBuffer.allocate(25); //создаём буфер размером 25 байт. Если мы добавим сверх этого,
                                                    // то будет выброшен Exception, который скажет нам что буфер заполнен
            StringBuilder stix = new StringBuilder();

            //теперь с помощью channel читаем информацию из файла и записываем её в буфер.
            //Читаем 25 байт из файла и записываем в буфер.
            int byteRead = channel.read(buffer); //метод read(buffer) возвращает количество прочитанных байт.

            //так как буфер у нас 25 байт, помещаем это в цикл и будем читать до тех пор, пока есть что ситать.
            while (byteRead > 0) {
                System.out.println("Read " + byteRead);

                buffer.flip(); //метод flip() - переводится как кувырок или сальто. Будем считать,
                               // что мы делаем сальто назад. Этот метод читает записанную в буфер информацию c
                               // position до limit.
                //Прочитаем информацию из буфера по одному байту за раз.
                while (buffer.hasRemaining()){ //пока у буфера есть что читать hasRemaining()
                     stix.append((char)buffer.get());
                }

                buffer.clear(); //Метод clear() подготавливает наш буфер к записи и
                                // переводит позицию на нулевую и начинает запись новой порции информации.
                byteRead = channel.read(buffer);
            }
            System.out.println(stix);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
