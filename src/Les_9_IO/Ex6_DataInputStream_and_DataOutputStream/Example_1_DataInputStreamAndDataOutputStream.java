package Les_9_IO.Ex6_DataInputStream_and_DataOutputStream;

import java.io.*;

//DataInputStream и DataOutputStream позволяют записывать в файл и читать из него примитивные типы данных

public class Example_1_DataInputStreamAndDataOutputStream {
    public static void main(String[] args) {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("C:\\Users\\Dell\\IdeaProjects" +
                "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex6_DataInputStream_and_DataOutputStream" +
                "\\my_test.bin"));
             DataInputStream inputStream = new DataInputStream(new FileInputStream("C:\\Users\\Dell\\IdeaProjects" +
                     "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex6_DataInputStream_and_DataOutputStream" +
                     "\\my_test.bin"));
        ) {
            //Записываем в файл информацию.
            outputStream.writeBoolean(true);
            outputStream.writeByte(5);
            outputStream.writeShort(120);
            outputStream.writeInt(500);
            outputStream.writeLong(1_000_000L);
            outputStream.writeFloat(3.14F);
            outputStream.writeDouble(123.456);

            //Читаем из файла информацию.
            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readShort());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readFloat());
            System.out.println(inputStream.readDouble());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
