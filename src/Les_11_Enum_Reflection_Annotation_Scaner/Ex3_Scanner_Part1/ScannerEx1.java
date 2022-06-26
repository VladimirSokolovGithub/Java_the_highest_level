package Les_11_Enum_Reflection_Annotation_Scaner.Ex3_Scanner_Part1;

import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);

        //Работа с консолью
//        System.out.println("Enter a number!");
//        int i = scanner.nextInt(); //считываем число
//        System.out.println("Entered number = " + i);

//        System.out.println("enter two numbers");
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        System.out.println("Частное = " + x/y);
//        System.out.println("Остаток от деления = " + x%y);

//        System.out.println("Напишите пару слов");
//        String s = scanner.nextLine(); //считывает строку
//        System.out.println("Вы написали: " + s);

//        System.out.println("Напишите две строки");
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
//        System.out.println("Вы написали в первой строке: " + s1);
//        System.out.println("Вы написали во второй строке: " + s2);

//        System.out.println("Напишите пару слов");
//        String s = scanner.next(); //читает значение до первого пробела
//        System.out.println("Вы написали: " + s);

//        System.out.println("введите дробное число");
//        double d = scanner.nextDouble();
//        System.out.println("введенное число: " + d);

//        scanner.close();

        //Далее примеры не с консолью.

//        Scanner scanner2 = new Scanner("Привет мой друг!");
//        String s = scanner2.next(); //читает значение до первого пробела
//        System.out.println(s);

        Scanner scanner2 = new Scanner("Привет мой друг!\nКак поживаешь?\nЧто хорошего?");

        //        String s1 = scanner2.nextLine(); //читает значение до первого пробела
//        System.out.println(s1);
//        System.out.println(scanner2.nextLine());
//        System.out.println(scanner2.nextLine());

//        while (scanner2.hasNextLine()){
//            System.out.println(scanner2.nextLine());
//        }

        //как прочитать из строки третий символ
        System.out.println(scanner2.next().charAt(2));
        scanner2.close();




        






    }
}
