package Les_10_RegularExpressions.Ex4_MethodsOfTheStringClass_matches_and_split;

//Рассмотрим два метода String matches() и split(), которые работают с регулярными выражениями.
//public boolean matches(String regex) - возвращает boolean true или false - сверяет String
// с регулярным выражением. Метод matches() используем тогда, когда нам нужно подтвердить или
// опровергнуть одно соответствие нашему шаблону. Если добавить в наш String s2 второй email, то
// мы получим false так как мы ждём один email а получаем два.

//public String[] split (String regex) - делит наш String на несколько частей по принципу указанному
// в regex параметре.

import java.util.Arrays;

public class StringMethods_matches_and_split {
    public static void main(String[] args) {
        String s
                = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48," +
                " email: vivamov@mail.ru, Postcode: AA99, Phone Number: +123456789;"
                + "Petrova Mariya, France, Paris, Lomonosov street, 33, Flat 18," +
                " email: masha@yandex.ru, Postcode: FR54, Phone Number: +987654321;"
                + "Chuck Norris, USA, Hollywood, All stars street, 87, Flat 21," +
                " email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478952;";

        //метод matches()
        String s2 = "chuck@gmail.com";
        boolean result = s2.matches("\\w+@\\w+\\.\\w++");
        System.out.println(result);

        //метод split()
        //Поделим String s на несколько частей и в качестве разделителя будем использовать символ - пробел.
        //Все элементы через пробел будут добавлены в массив array.
        String[] array = s.split(" ");
        System.out.println(Arrays.toString(array));

    }
}
