package designType.main.com.sansan.cn.adapter;

public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targerTable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}
