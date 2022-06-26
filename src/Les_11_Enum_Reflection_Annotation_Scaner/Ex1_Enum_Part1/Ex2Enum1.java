package Les_11_Enum_Reflection_Annotation_Scaner.Ex1_Enum_Part1;

//Enum можно создать как класс в отдельном файле, можно его создать внутри класса - он будет nested enum.
//Внутри метода создать enum мы не сможем.

public class Ex2Enum1 {
    public static void main(String[] args) {
        Today today = new Today(WeekDays.MONDAY);
        today.daysInfo();
    }
}

enum WeekDays{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
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
    }
}