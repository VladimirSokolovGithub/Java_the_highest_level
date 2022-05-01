package Les_5_LambdaExpressions.lambda_expressions_part2;


public class Example_1 {

    static void def(I i){
        System.out.println(i.abc());
    }

    public static void main(String[] args) {
        def(() -> {return 18;});
        def(() -> 18);
    }
}

interface I{
    int abc();
}

