package Les_9_NIO.Ex11_Channel_and_Buffer_Reading_from_a_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Example_2_Introduction_to_Channel_and_Buffer {
    public static void main(String[] args) {
        //Класс RandomAccessFile позволяет читать информацию из любого места в файле и записывать информацию
        // в любое место файла.
        try(RandomAccessFile file = new RandomAccessFile("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level" +
                "\\src\\Les_9_NIO\\Ex11_Channel_and_Buffer_Reading_from_a_file\\text10.txt", "rw");
            FileChannel channel = file.getChannel();
        ){

            ByteBuffer buffer = ByteBuffer.allocate(25); //создали буфер вместимостью 25 байт

            StringBuilder stix = new StringBuilder(); //создали StringBuilder куда будем добавлять наш текст

            int byteRead = channel.read(buffer); //первый раз прочитали информацию из файла в буфер

                        while (byteRead > 0) {  //проверяем если количество прочитанных байт в буфере > 0
                System.out.println("Read " + byteRead); //выводим в консоль сколько байт мы прочитали

                buffer.flip(); //переводим буфер в режим чтения

                while (buffer.hasRemaining()){ //пока у буфера есть что читать hasRemaining()
                    stix.append((char)buffer.get()); //читаем из буфера информацию и присоединяем к нашему StringBuilder stix
                }

                buffer.clear(); //переводим позицию в буфере на нулевую ячейку

                byteRead = channel.read(buffer); //и опять читаем информацию из файла и записываем в буфер
            }
            System.out.println(stix);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
