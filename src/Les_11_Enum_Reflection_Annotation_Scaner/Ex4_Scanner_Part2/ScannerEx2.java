package Les_11_Enum_Reflection_Annotation_Scaner.Ex4_Scanner_Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ScannerEx2 {
    public static void main(String[] args) {

        //В Scanner так же можно передать file.
        //Выведем из файла уникальные слова без дубликатов в алфавитном порядке.
        //Для этого будем использовать TreeSet - он содержит уникальные значения упорядоченно.

        Scanner scanner = null;
        Set<String> set = new TreeSet<>();
        try {
            scanner = new Scanner(new FileReader(new File("C:\\Users\\Dell\\Desktop\\text.txt")));
            scanner.useDelimiter("\\W"); //убирает знаки препинания
            while (scanner.hasNext()){
                String word = scanner.next();
                set.add(word);
            }
            for (String word: set){
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("We have a problem!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
