package designType.main.com.sansan.cn.decorator;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method");
    }
}