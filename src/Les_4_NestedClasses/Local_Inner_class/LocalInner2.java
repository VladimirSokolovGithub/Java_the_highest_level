package Les_4_NestedClasses.Local_Inner_class;

public class LocalInner2 {
    public static void main(String[] args) {
        class Slogenie implements Math2{
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        }

        Slogenie slogenie = new Slogenie();
        slogenie.doOperation(5,10);
    }

}

interface Math2{
    int doOperation(int a, int b);
}