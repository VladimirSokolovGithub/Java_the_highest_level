package Les_5_LambdaExpressions.lambda_expressions_part1;

public class Example_2 {
    static void def(I i){
        System.out.println(i.abc("Hello"));
    }

    public static void main(String[] args) {
        def((String str) -> {return str.length();});
    }
}

interface I{
    int abc(String s);
}
