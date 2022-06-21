package Les_10_RegularExpressions.Ex6__method_replaceAll_and_group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2_replaceAll_and_group {
    public static void main(String[] args) {
        String myString = "12345678912345670325987;98765432165498750921654;85274196345612381122333";
        //информация о банковских картах
        //1234 5678 9123 4567 03/25 (987) - нормальный шаблон
        //03/25 1234 5678 9123 4567 (987) - месяц и год передвинем вперед.
//Нужно из формата нашего myString сделать нужный нам и удобочитаемый формат

        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        //У нас 7 групп - группа это выражение взятое в скобки. Счёт идёт слева на право и начинается с 1.
        Matcher matcher = pattern.matcher(myString);

//        String myNewString = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
//        //$5 - обозначает пятую группу
//        System.out.println(myNewString);

        //метод group() без аргумента выводит полное соответствие.
        while (matcher.find()){
            System.out.println(matcher.group(7)); //например хочу увидеть 7 группу
        }

    }
}
