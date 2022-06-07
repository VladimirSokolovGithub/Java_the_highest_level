package Les_9_IO_And_NIO.Ex5_FileInputStream_and_FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//В FileInputStream и FileOutputStream мы так же можем использовать буферизацию. Это достигается с помощью классов
//BufferedInputStream и BufferedOutputStream.

public class Example_2_FileInputStreamAndFileOutputStream {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Dell\\Desktop\\JavaJpeg.jpeg");
             FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Dell\\IdeaProjects" +
                     "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex5_FileInputStream_and_FileOutputStream" +
                     "\\JavaJpeg2.jpeg");
        ) {
            int i;
            while ((i = inputStream.read()) != -1){
                outputStream.write(i);
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
