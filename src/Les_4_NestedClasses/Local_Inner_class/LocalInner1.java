package Les_4_NestedClasses.Local_Inner_class;

public class LocalInner1 {
    //Локальные inner классы, это классы которые создаются в блоках кода (методах, конструкторах,
    // инициализаторах, циклах).
    //В отличие от static nested класса или inner класса, локальные inner классы не являются элементами класса,
    //они просто локальны для какого то метода или блока кода в котором определены.

    //Локальные inner классы не доступны вне блока когда в котором они созданы. По аналогии с локальной переменной

    //Локальные inner класс не может быть с модификатором static.

    //Такие классы очень редки на практике, но повышают инкапсуляцию.

    //Local inner класс может extends and implements, всё будет без проблем работать.

    //access modifier для Local inner класса указывать нельзя, так же как и для локальных переменных.

    //Локальные inner класс может обращаться к элементам блока, в котором он написан, при условии, что они
    //final или effectively final.

    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
    }

}

class Math{

    private int a = 10;

    private final int divisible = 21; //делимое
//    private int divisible = 21; //effectively final - это переменная после инициализации которой значение
                                    //далее ни в коде внешнего класса, в котором объявлен Локальный inner класс
                                    //ни в самом Локальныом inner классе не изменяется.

//Так же все делимое и делитель можно создать в параметрах метода. Но их тоже менять нельзя и желательно сделать
//final
    public void getResult(){
        class Division{ //класс Деление
//            private int divisible; //делимое
            private int divider; //делитель

//            public int getDivisible() {
//                return divisible;
//            }
//
//            public void setDivisible(int divisible) {
//                this.divisible = divisible;
//            }

            public int getDivider() {
                return divider;
            }

            public void setDivider(int divider) {
                this.divider = divider;
            }

            public int getDivisorQuotient(){ //частное от деления
                return divisible/divider;
            }

            public int getRemainderOfDivision(){ //остаток от деления
                System.out.println(a); //локальные inner классы могут видеть и использовать переменные внешнего класса
                return divisible % divider;
            }


        }

        Division division = new Division();
//        division.setDivisible(21);
        division.setDivider(4);
//        System.out.println("Delimoe = " + division.getDivisible());
        System.out.println("Delimoe = " + divisible);
        System.out.println("Delitel = " + division.getDivider());
        System.out.println("Chastnoe = " + division.getDivisorQuotient());
        System.out.println("Ostatok ot delenia = " + division.getRemainderOfDivision());
    }
}
