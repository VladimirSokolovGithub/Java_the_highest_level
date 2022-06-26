package Les_11_Enum_Reflection_Annotation_Scaner.Ex2_Enum_Part2;

//enum является дочерним классом для java.lang.Enum
//В Enum могут содержаться переменные, методы, конструкторы.

//Часто используемые методы - valueOf() and values().

//метод valueOf() - позволяет получать нам элемент enum из какого - то String значения.
// Позволяет создать enum из String значения.

//метод values() - возвращает массив констант которые принадлежат enum-у.

//Для каждого дня у нас будет своё настроение.


import java.util.Arrays;

public class Ex1Enum2 {
    public static void main(String[] args) {
        Today today = new Today(WeekDays.MONDAY);
        today.daysInfo();
        System.out.println(today.weekDay);

        //Мы не можем создать enum с помощью ключевого слова new, причиной тому private конструктор, который
        //срабатывает внутри и служит для придания значения final переменной, например - MONDAY("bad").
        WeekDays w1 = WeekDays.FRIDAY;
        WeekDays w2 = WeekDays.FRIDAY;
        WeekDays w3 = WeekDays.MONDAY;
        //Можем сравнивать enum-ы с помощью оператора ==
        System.out.println(w1 == w2); //true
        System.out.println(w1 == w3); //false

        System.out.println(WeekDays.FRIDAY.equals(WeekDays2.FRIDAY)); //false - константы разных типов

        WeekDays w15 = WeekDays.valueOf("MONDAY"); //позволяет создать enum из String значения
        System.out.println(w15);

        WeekDays [] array = WeekDays.values(); //Передали все значения констант в массив array.
        System.out.println(Arrays.toString(array));
    }
}

enum WeekDays{
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY("good"),
    SATURDAY("great"),
    SUNDAY("good");

    private String mood;

    //После объявления конструктора нам компилятор подчеркнул наши энумы-константы так как для каждого элемента
    // enum мы в скобках должны передать наш String mood.

    //Наш конструктор в enum может быть только private. Мы можем этот модификатор доступа не указывать,
    // но он по умолчанию будет private. Этот конструктор срабатывает внутренне, когда каждому элементу
    // enum-а даётся значение в скобках, он срабатывает автоматически. Конструктор enum-а мы не сможем
    // сами вручную вызвать.
    //Конструкторов может быть несколько, в том числе и конструктор без параметров.

    private WeekDays(String mood){
        this.mood = mood;
    }

    private WeekDays(){
    }

    //Напишем метод, который будет возвращать наше настроение.
    public String getMood(){
        return mood;
    }
}

enum WeekDays2 {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

class Today{
    WeekDays weekDay;

    public Today(WeekDays weekDay){
        this.weekDay = weekDay;
    }

    void daysInfo(){
        switch (weekDay){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("go to work!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("you can relax");
                break;
        }
        System.out.println("mood on this day " + weekDay.getMood());
    }
}