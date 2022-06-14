package Les_9_NIO.Ex12_Channel_and_Buffer_Writing_to_a_file;

//Рассмотрим как мы можем писать в файл используя канал и буфер.

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Ex1_ChannelAndBuffer_WritingToFile {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level" +
                "\\src\\Les_9_NIO\\Ex12_Channel_and_Buffer_Writing_to_a_file\\text10.txt", "rw");
            FileChannel channel = file.getChannel(); //создаём channel
        ){
            ByteBuffer buffer = ByteBuffer.allocate(25); //создали буфер вместимостью 25 байт
            StringBuilder stix = new StringBuilder();
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


            //****** Запись в файл **********
            String text = "\nThere are only two ways to live your life." +
                    " One is as though nothing is a miracle. The other is as" +
                    " though everything is a miracle.";

            //Мы можем создать буфер двумя способами:

            //1. Конкретно под эту цитату указав её размер в параметре метода allocate(text.getBytes().length).
//            ByteBuffer buffer2 = ByteBuffer.allocate(text.getBytes().length);
//            buffer2.put(text.getBytes()); //занесем нашу цитату в буфер с помощью метода put.
//            //теперь что бы читать из буфера нам нужно вызвать метод flip().
//            buffer2.flip();
//            channel.write(buffer2); //записываем в файл информацию из буфера.

            //2. Второй вариант создания буфера с помощью метода wrap(text.getBytes()) и передадим в него
            //массив байт нашего текста(нашей цитаты). Метод wrap() записывает информацию из текста в
            // буфер, теперь нам не нужно указывать вручную размер буфера, нам не нужно записывать в
            // буфер с помощью метода put(), нам не нужно делать flip(). Метод wrap() делает эти три
            // вещи автоматически.
            ByteBuffer buffer3 = ByteBuffer.wrap(text.getBytes());
            channel.write(buffer3);//записываем в файл информацию из буфера


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
