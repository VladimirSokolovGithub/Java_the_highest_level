package Les_10_RegularExpressions.Ex6__method_replaceAll_and_group;

//методы replaceAll() and group()
//В этом уроке о замене чего - либо в нашем String

public class Ex1_replaceAll_and_group {
    public static void main(String[] args) {
        String s1 = "Privet,              moy   drug!   Kak  idet izuchenie     Java           ?";
        System.out.println(s1);
//        s1 = s1.replace("Java", "SQL");

        //есть метод replaceAll() и он принимает regular expression.
//        s1 = s1.replaceAll(" {2,}", " ");
//        s1 = s1.replaceAll("\\bi\\w+", "4444");
        //метод replaceFirst() - меняет первое совпадение
        s1 = s1.replaceFirst("\\bi\\w+", "4444");
        System.out.println(s1);

    }
}
