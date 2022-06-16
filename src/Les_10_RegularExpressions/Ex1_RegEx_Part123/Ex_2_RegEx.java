package Les_10_RegularExpressions.Ex1_RegEx_Part123;

//Клас для демонстрации работы регулярных выражений и их метасимволов.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Pattern и Matcher это два класса, которые находятся в пакете java.util.regex. и они помогают нам
// эффективно и очень быстро справляться с нашей задачей.
public class Ex_2_RegEx {
    public static void main(String[] args) {

//        String s1 = "ABCD ABCE ABCFABCGABCH";

        //Создание шаблона для поиска - объект типа Pattern.
        // Так как конструктор у класса Pattern private, то мы не можем создать объект с помощью new,
        // а создаём объект с помощью статического метода compile() передавая в параметр наш шаблон "ABCD".
//        Pattern pattern1 = Pattern.compile("ABC");

//        String s1 = "OPABMNCD";
//        Pattern pattern1 = Pattern.compile("[ABC]"); //Шаблон для поиска одного любого символа из скобок.

//        String s1 = "ABDOP";
//        Pattern pattern1 = Pattern.compile("AB[C-F]OP");//сначало идёт AB, потом одна из букв
                                                        // диапазона [C-F] и потом идет OP

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc[e-j4-7]");//[e-j4-7] - означает один из символов из этого диапазона

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc[^e-j4-7]");//^ - символ отрицания. т.е. один символ не из этих
                                                            //диапазонов.

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc(e|5)"); //четвертый символ нашего шаблона будет или 'e' или '5'

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc."); //точка это любой символ, выведется abc и ещё один символ после.

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("^abc");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc5abcg6abch$"); //так же можно уменьшить количество букв и это тоже
                                                                //будет конец строки

        //Как найти в этом стринге любую цифру
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("[0-9]");
        //Но для того чтобы это не писать мы можем использовать метасимволы.

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\d"); //поиск одной цифры от 0 до 9

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\D"); //поиск любого символа кроме цифр включая пробелы

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w"); //поиск любой буквы цифры или нижнего подчеркивания, кроме пробела

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w+"); //одно или более повторений в нашем стринге
                                                        // из диапазона [A-Za-z0-9_]

//        String s1 = "abcd!?abce====abc ++5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\W+"); //W-любой символ не из этого [A-Za-z0-9_] диапазона

//        String s1 = "poka abc Vladimir dom kino";
//        Pattern pattern1 = Pattern.compile("\\w{4}"); //одно или более повторений из диапазона [A-Za-z0-9_]
                                                        //длиной в 4 символа. Слово Vladimir будет разбито на два

//        String s1 = "poka     abc           Vladimir    dom     kino";
//        Pattern pattern1 = Pattern.compile("\\w\\s+\\w"); //[\t\n\r\f] - этому диапазону соответствует пробельный
                                                          // символ
//        String s1 = "abcd abc3 abcfa78abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\D{2,6}"); //не цифра, количество повторений (символов) от 2 до 6
//        Pattern pattern1 = Pattern.compile("\\D{2,}"); //не цифра, количество повторений (символов) от 2 до бесконечности


//        String s1 = "ABCABABDA";
//        Pattern pattern1 = Pattern.compile("(AB){2,3}"); //ABAB - от двух до трёх повторений AB

//        String s1 = "DABCDABABDABABABABD";
//        Pattern pattern1 = Pattern.compile("D(AB){2,}"); //ищем D потом от двух и более повторений AB DABABABAB и.т.д.

//        String s1 = "DABCDABABDA";
//        Pattern pattern1 = Pattern.compile("D(AB)?");

//        String s1 = "DABCDABABDA";
//        Pattern pattern1 = Pattern.compile("D(AB)*");

//        String s1 = "abcd abce abcfabcgabch";
//        Pattern pattern1 = Pattern.compile("\\Aabcd"); //ищет выражение abcd в начале стринга

//        String s1 = "abcd abce abcfabcgabch";
//        Pattern pattern1 = Pattern.compile("bch\\Z");

        String s1 = "abcd abcd4 af4ced7";
        Pattern pattern1 = Pattern.compile("[abcd][efgh3-8]");

        //Класс Matcher находит соответствие. Мы наш шаблон pattern1
        // с помощью метода matcher(s1) сверяем на соответствие с нашим стрингом s1, который передаем в параметр.
        // И при этом создается объект matcher.
        Matcher matcher = pattern1.matcher(s1);
        // Далее у нашего объекта matcher мы вызываем метод find(), который возвращает true если
        // какое-то совпадение было найдено. Если найдено несколько совр=падений, то он вернет true несколько раз.
        while (matcher.find()){
            System.out.println("Position: " + matcher.start() + "  " + matcher.group());
            //С помощью метода group() выводим на экран эти совпадения до тех пор, пока метод find() не вернет false.
            //Для того чтобы узнать, на какой позиции находится наш ABC, воспользуемся методом matcher.start().


        }
    }
}
