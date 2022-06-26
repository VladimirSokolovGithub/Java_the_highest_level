package Les_11_Enum_Reflection_Annotation_Scaner.Reflection_Part2;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorEx4 {

    //Рассмотрим ещё один пример, что можно сделать с помощью рефлексии, чего без неё не сделаешь.
    void sum(int a, int b){
        int result = a + b;
        System.out.println("Сумма " + a + " и " + b + " = " + result);
    }

    void subtraction(int a, int b){
        int result = a - b;
        System.out.println("Разность " + a + " и " + b + " = " + result);
    }

    void multiplication(int a, int b){
        int result = a * b;
        System.out.println("Произведение " + a + " и " + b + " = " + result);
    }

    void division(int a, int b){
        int result = a / b;
        System.out.println("Частное " + a + " и " + b + " = " + result);
    }

}

//Напишем такой код, который будет читать этот файл и в файле я буду указывать какой метод я хочу вызывать, и
// задавать аргументы к этому методу. После чего будет выводиться действие этого метода нашего калькулятора.
// Если бы не рефлексия, то мы бы не смогли справиться с этой задачей. Так как мы не смогли бы прочитав название
// нашего метода вызвать этот метод в классе калькулятор. Без рефлексии этого сделать бы было невозможно.

class TestCalculator{
    public static void main(String[] args) {
        //Во-первых, нам нужно читать этот файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("test100.txt"))){
            //прочитаем имя нашего метода и его аргументы.
            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            CalculatorEx4 calculator = new CalculatorEx4();
            Class cl = calculator.getClass();
            Method method = null;

            //У нас в классе 4 метода и нам нужно найти тот метод, который мы прочитаем из файла - methodName.
            Method[] methods = cl.getDeclaredMethods(); //используем getDeclaredMethods(), для того чтобы
                                                        // не было лишних методов унаследованных от класса Object
            for (Method myMethod : methods){
                if (myMethod.getName().equals(methodName)){
                    method = myMethod;
                }
            }

            method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}