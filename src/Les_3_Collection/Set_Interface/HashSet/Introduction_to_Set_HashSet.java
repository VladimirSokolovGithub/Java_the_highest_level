package Les_3_Collection.Set_Interface.HashSet;

import java.util.HashSet;
import java.util.Set;

public class Introduction_to_Set_HashSet {
    //Set переводится как множество, набор уникальных элементов.
    //Set это коллекция уникальных элементов(Set не позволяет хранить одинаковые элементы).
    //Методы данной коллекции очень быстры.
    //В основе любого Set лежит урезанная версия Map. Set хранит только значения.

    //В основе HashSet находится объект HashMap, который и хранит в качестве ключей значения HashSet,
    //а в качестве значения HashMap хранит заглушку(какую-то константу) и не обращает на неё внимание.
    //HashSet не запоминает порядок добавления элементов.
    //HashSet может содержать значение null.

    //HashSet так же как и HashMap не хранит элементы в том порядке в котором они добавлены

    //Так же обязательно необходимо переопределять методы equals() и hashCode() так как в основе лежит HashMap
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("Vladimir"); //Добавляет элемент в HashSet. Внутри него используется метод put(), который
                                //принадлежит HashMap
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
        set.add("Igor"); //если попытаемся добавить дубликат, то ничего не произойдет так, как Set не может
                        //содержать дубликатов(одинаковые значения).
        set.add(null);

        System.out.println(set);

        for (String s : set){
            System.out.println(s);
        }

        set.remove("Vladimir");
        System.out.println(set); //метод удаляет элемент из Set

        System.out.println(set.size()); //выводит размер коллекции

        System.out.println(set.isEmpty()); //проверяет пустой ли наш Set

        System.out.println(set.contains("Misha")); //проверяет, содержит ли Set определенный объект

        //У Set нет метода get().








    }
}
