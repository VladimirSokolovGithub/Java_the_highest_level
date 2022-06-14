package Les_9_IO.Ex9_Class_RandomAccessFile;

//До этого мы рассматривали разные виды стримов, они представляют файлы в виде потоков. Читать из них
//и писать в них можно только последовательно. Это невсегда удобно, так как иногда нужно записать
//какую то информацию в середину файла или его конец, или прочитать какой - то отрывок с конца большого файла.
//Читать для этого весь файл не очень эффективно.

//Класс RandomAccessFile позволяет читать информацию из любого места в файле и записывать информацию
// в любое место файла.

import java.io.FileNotFoundException;
import java.io.IOException;

public class Example_1_RandomAccessFileClass {
    public static void main(String[] args) {
        //Первый параметр в конструкторе, это путь к файлу, второй параметр, это режим работы с файлом.
        //r - чтение, w - запись, rw - и чтение и запись.
        try(java.io.RandomAccessFile file = new java.io.RandomAccessFile("C:\\Users\\Dell\\IdeaProjects" +
                "\\Java_the_highest_level\\src\\Les_9_IO_And_NIO\\Ex9_Class_RandomAccessFile" +
                "\\text10.txt", "rw")
        ){
            int a = file.read(); //Читать файл. Метод read() прочитает один байт на позиции где сейчас стоит
            // курсор (или pointer - указатель). В самом начале pointer стоит в начале нашего текста, перед
            // самым первым байтом. Т.е сейчас наш метод read() вернёт нам заглавную букву 'H'. read()
            // возвращает int и поэтому для его вывода в консоль придётся использовать кастинг.
            System.out.println((char) a);

//            a = file.read(); //теперь выведется следующая буква 'a'. Т.е. read() читает символ и сдвигает курсор.
//            System.out.println((char) a);

            String s1 = file.readLine(); //можем прочитать сразу строчку
            System.out.println(s1);

            //Допустим мы хотим прочитать строку со 101-го байта, мы должны переместить наш pointer на позицию 101.
            //Это достигается с помощью метода seek(101) - искать.
            file.seek(101);
            String s2 = file.readLine();
            System.out.println(s2);

            //Метод getFilePointer() - позволяет узнать на какой позиции находится pointer
            long position = file.getFilePointer();
            System.out.println(position);

            //Что будет если мы переместимся на нулевую позицию и попытаемся записать в этот файл слово Hello.
//            file.seek(0);
            //Метод для записи String. Но при этом наши первые 7 байт были
            // заменены и затерты словом  "Hello! "
//            file.writeBytes("Hello! ");

            //Добавим в конец стихотворения имя автора
            file.seek(file.length() - 1); //попали в конец файла
            file.writeBytes("\n\t\t\t\t\tWilliam Butler Yeats");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
