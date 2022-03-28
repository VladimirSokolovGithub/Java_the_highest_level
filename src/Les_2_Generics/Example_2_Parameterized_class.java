package Les_2_Generics;

public class Example_2_Parameterized_class {
    public static void main(String[] args) {
        Info<String> info1 = new Info<>("Hello");
        System.out.println(info1);
        String s = info1.getValue();

        Info<Integer> info2 = new Info<>(18);
        System.out.println(info2);
        Integer i1 = info2.getValue();
    }
}

//Мы хотим создать класс, но пока не знаем какого типа будет значение которое будет содержаться в этом классе

class Info <T> {
    private T value; //Такая переменная не может быть static, так как static принадлежит всему классу и всем
                    // объектам типа Info т.е. она одна общая для всех объектов и не может быть разных типов

    public Info(T value){
        this.value = value;
    }

    public String toString(){
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}

//Правила типизации типов в даймонд скобках:
//1. Это должна быть одна заглавная буква, любая. Но в java приняты следующие
// в ArrayList например это <E> - элемент
// у Map это <K> - это ключи key
// у Map это <V> - это value значение
// <T> - это Type - заполнитель типа