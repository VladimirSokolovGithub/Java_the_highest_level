package Les_9_NIO.Ex13_Channel_and_Buffer_Important_ethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Example_1_MethodsChannelAndBuffer {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("C:\\Users\\Dell\\IdeaProjects\\Java_the_highest_level" +
                "\\src\\Les_9_NIO\\Ex13_Channel_and_Buffer_Important_ethods\\text5.txt", "r");
            FileChannel channel = file.getChannel();
        ){
            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());

            //метод rewind() - помещает позицию курсора на ячейку с индексом ноль, т.е.в начало буфера.
            buffer.rewind();
            System.out.println((char) buffer.get()); //a
            System.out.println("---------------------------------------------");

            //метод clear() ставил наш курсор (position) на нулевую ячейку, что бы мы могли
            // при записи информации в буфер начинать с нулевой ячейки и перезаписывать все элементы.

            //Если же у нас в буфере остались элементы, которые мы ещё не прочли и мы не хотим затирать
            // эти элементы другими новыми байтами, мы можем вызвать метод compact().

            //метод compact() - после вызова метода компакт, он копирует непрочитанные элементы в буфере
            //в начало буфера, начиная с нулевой ячейки. И если брать наш пример, то у нас остается один
            //байт для записи информации и position уже указывает на свободную ячейку буфера, на наш
            //оставшийся один байт.

            buffer.compact();
            channel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }
            System.out.println("---------------------------------------------");

            //Прочтём оставшиеся 4 символа из файла.
            //метод mark() - ставит метку на текущую позицию курсора
            //метод reset() - метод возвращает курсор на позицию, которую мы запомнили с помощью
                            // метода mark().
            buffer.clear();
            channel.read(buffer); // записали оставшиеся 4 символа из файла в буфер
            buffer.flip(); //переходим в режим чтения
            System.out.println((char) buffer.get());
            buffer.mark(); //поставим метку на текущую позицию курсора т.е. на символ 'h'
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            //теперь мы вернемся к позиции, где была буква 'h'
            buffer.reset(); //метод возвращает курсор на позицию, которую мы запомнили с помощью
                            // метода mark().
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
