package designType.main.com.sansan.cn.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable Obj = new Decorator(source);
        Obj.method();
    }
}
