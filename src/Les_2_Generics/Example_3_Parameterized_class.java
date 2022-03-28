package Les_2_Generics;

public class Example_3_Parameterized_class {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Hello", 20);
        System.out.println("Значение пары: value1 = " + pair1.getFirstValue() +
                ", value2 = " + pair1.getSecondValue());

        Pair<Integer, Double> pair2 = new Pair<>(156, 3.14);
        System.out.println("Значение пары: value1 = " + pair2.getFirstValue() +
                ", value2 = " + pair2.getSecondValue());

        OtherPair<String> otherPair = new OtherPair<>("Hello", "Goodbye");
    }
}

//класс Пара
class Pair<V1, V2> {
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getFirstValue() {
        return value1;
    }

    public V2 getSecondValue() {
        return value2;
    }
}

class OtherPair<V> {
    private V value1;
    private V value2;

//пример из задания Example_3_Parameterized_method

    //Если мы создаём Generics параметризованный метод в параметризованном классе, то перед названием метода мы
    //уже можем не указывать, java и так понимает, что return type это - V

    public V abc (V value){
        return value;
    }
//    public <V> V abc (V value){
//        return value;
//    }

    public OtherPair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getFirstValue() {
        return value1;
    }

    public V getSecondValue() {
        return value2;
    }
}
