package Les_3_Collection.Stack;

import java.util.Stack;

public class Example_2_Stack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //Метод push() добавляет элемент в коллекцию Stack на самый верхний уровень, вверху будет "Katya"
        stack.push("Vladimir");
        stack.push("Misha");
        stack.push("Oleg");
        stack.push("Katya");
        System.out.println(stack);

        //Метод pop() возвращает нам элемент, который находится в самом верху Стека и удаляет этот элемент
        System.out.println(stack.pop());
        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop()); //Если применить метод pop() к пустому стеку, то будет EmptyStackException
        //но мы можем этого избежать если будем проверять пуст ли стек с пом.метода isEmpty()

//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//            System.out.println(stack);
//        }

        //Метод peek() возвращает элемент на самом верху стека, но не удаляет его
        System.out.println(stack.peek());
        System.out.println(stack);



    }
}
