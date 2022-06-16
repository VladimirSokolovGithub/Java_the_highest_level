package Les_10_RegularExpressions.Ex1_RegEx_Part123;

//Допустим нам нужно найти все email и конкретные email мы не знаем, но нам нужно вывести все email.
//Тогда нам нужно использовать регулярные выражения. Мы знаем как выглядит шаблон написания email,
//и с помощью регулярных выражений мы сможем осуществить по этому шаблону нужный поиск.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex_1_RegEx {
    public static void main(String[] args) {
        String s
                = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48," +
                " email: vivamov@mail.ru, Postcode: AA99, Phone Number: +123456789;"
                + "Petrova Mariya, France, Paris, Lomonosov street, 33, Flat 18," +
                " email: masha@yandex.ru, Postcode: FR54, Phone Number: +987654321;"
                + "Chuck Norris, USA, Hollywood, All stars street, 87, Flat 21," +
                " email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478952;";

        //Найдём все слова в нашем стринге s
//        Pattern pattern = Pattern.compile("\\w+");

        //найдём все номера домов и все номера квартир
//        Pattern pattern = Pattern.compile("\\b\\d{2}\\b"); //граница слова две цифры и граница слова
                                                           //таким образом ищем только числа из двух цифр
                                                           // без букв и большего количества символов

        //шаблон для всех номеров телефонов
//        Pattern pattern = Pattern.compile("\\+\\d{9}");

        //шаблон для поиска всех email
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
//        Pattern pattern = Pattern.compile("\\w+@\\w+\\.(ru | com)"); //второй вариант

        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
