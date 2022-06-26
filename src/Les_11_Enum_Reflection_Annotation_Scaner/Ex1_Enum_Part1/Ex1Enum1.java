package Les_11_Enum_Reflection_Annotation_Scaner.Ex1_Enum_Part1;

public class Ex1Enum1 {

    void method(String dayOfWeek){
        System.out.println("Today is " + dayOfWeek);
    }

    public static void main(String[] args) {
        Ex1Enum1 en  = new Ex1Enum1();
        en.method("Monday");
    }
}
