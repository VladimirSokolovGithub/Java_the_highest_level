package Les_3_Collection.Interface_ListIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Example_1_ListIterator {
    public static void main(String[] args) {
        //Будем проверять String палиндром ли он, т.е. это какие-то предложения, строки, которые одинаково
        //читаются и слева направо и с право на лево

        String s = "madam";
        List<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()){ //метод toCharArray() преобразует String в массив символов
            list.add(ch);
        }
        System.out.println(list);

        //Теперь мы создадим два ListIterator и будем идти по нашему list с двух сторон и сравнивать эти
        //символы, если символы одинаковые я иду дальше, если следующие одинаковые, иду дальше. Если
        //мы не найдем разницу в символах, значит наш String палиндром, если нет, то не палиндром

        ListIterator<Character> iterator = list.listIterator(); //это by Default начинает с нулевой позиции
        ListIterator<Character> reversIterator = list.listIterator(list.size()); // в параметр помещаем
        //list.size() т.е. говорим с какой позиции нужно начинать итерацию, в нашем случае с конца

        boolean isPalindrome = true;
        //далее мы проверяем iterator имеет ли следующий символ и reversIterator имеет ли предыдущий символ
        while (iterator.hasNext() && reversIterator.hasPrevious()){
            if (iterator.next() != reversIterator.previous()){
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome){
            System.out.println("Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }

        //Этот код конечно будет работать не очень эффективно так как когда наши лист итераторы дойдут
        //до середины, то они пойдут дальше, а не остановятся

    }
}
