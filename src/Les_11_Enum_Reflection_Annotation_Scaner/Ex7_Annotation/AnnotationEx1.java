package Les_11_Enum_Reflection_Annotation_Scaner.Ex7_Annotation;

public class AnnotationEx1 {
    public static void main(String[] args) {
        Parent p = new Child("Vladimir");
        p.showInfo();
    }
}

class Parent {
    String name;

    public Parent(String name) {
        this.name = name;
    }

    //Помечает метод как устаревший. Но тогда нужно писать какой метод вместо этого
    // использовать и причину почему метод устарел.
    @Deprecated
    void showInfo() {
        System.out.println("It's Parent class. Name = " + name);
    }
}


class Child extends Parent {
    public Child(String name) {
        super(name);
    }

    //Когда мы переопределяем метод в subclass (классе наследнике), то очень рекомендуется
    // использовать аннотацию @Override. Так как это поможет увидеть ошибки на этапе компиляции.
    // Ошибки могут быть в имени метода, в наличии или отсутствии параметров, тогда без аннотации
    // Java будет думать, что это какой-то новый метод и не покажет нам ошибку. Либо мы можем изменить
    // метод в суперклассе и тогда так же не заметим ошибки.
    @Override
    void showInfo() {
        System.out.println("It's Child class. Name = " + name);
    }
}